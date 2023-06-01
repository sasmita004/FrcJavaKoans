package engine;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

/**
 * Intercepts the StdOut output and the StdIn input of koans so we can assert what the koan method does output to the console and read from it.
 * Also, allows to silent the output, so that successful koans are not polluting the console, and only the
 * first failing koan output is displayed.
 */
public class StdStreamsInterceptor {
    private static final PrintStream realOut = System.out;
    private static final InputStream realIn = System.in;

    public static class InterceptionResult {
        public final String[] stdOutLines;
        public final String[] stdInLines;
        public final Object returnValue;

        public InterceptionResult(String[] stdOutLines, String[] stdInLines, Object returnValue) {
            this.stdOutLines = stdOutLines;
            this.stdInLines = stdInLines;
            this.returnValue = returnValue;
        }
    }

    public interface ReflectionRunnable {
        Object run() throws IllegalAccessException, InvocationTargetException;
    }

    private static class OutputStreamMultiplexer extends OutputStream {
        private final OutputStream stream1;
        private final OutputStream stream2;
        
        public OutputStreamMultiplexer(OutputStream stream1, OutputStream stream2) {
            this.stream1 = stream1;
            this.stream2 = stream2;
        }

        @Override
        public void write(int b) throws IOException {
            stream1.write(b);
            stream2.write(b);
        }
    }

    
    private static class StdInInterceptor extends InputStream {
        private final ByteArrayOutputStream bos = new ByteArrayOutputStream();

        @Override
        public int read() throws IOException {
            int b = realIn.read();
            bos.write(b);
            return b;
        }

        @Override
        public int available() throws IOException {
            return realIn.available();
        }

        @Override
        public int read(byte[] b, int off, int len) throws IOException {
            var n = realIn.read(b, off, len);
            bos.write(b, off, len);
            return n;
        }

        public String[] lines() {
            try {
                bos.flush();
            }
            catch(IOException ioe) {
                // Do nothing: the assertion based on this will not pass anyway.
            }
            return StdStreamsInterceptor.lines(bos);
        }
    }

    private static String[] lines(ByteArrayOutputStream bos) {
        var lines = bos.toString().split("\\r?\\n", -1);
        return Arrays.copyOf(lines, lines.length - 1);
    }

    public static InterceptionResult capture(boolean silent, ReflectionRunnable executeFunc, String[] stdInputs) throws IllegalAccessException, InvocationTargetException {
        var bos = new ByteArrayOutputStream();
        var printStream = new PrintStream(silent ? bos : new OutputStreamMultiplexer(bos, realOut), true);

        var inputStream = silent ? new ByteArrayInputStream(String.join(System.lineSeparator(), stdInputs).getBytes()) : new StdInInterceptor();

        System.setOut(printStream);
        System.setIn(inputStream);
        Helpers.setupStdInForKoan();
        Object returnValue;
        try {
            returnValue = executeFunc.run();
        }
        finally {
            System.setOut(realOut);
            System.setIn(realIn);
            Helpers.cleanupStdInForKoan();
            printStream.close();
        }

        return new InterceptionResult(
            lines(bos),
            silent ? stdInputs : ((StdInInterceptor)inputStream).lines(),
            returnValue
        );
    }
}
