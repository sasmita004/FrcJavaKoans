package engine;

import static engine.Localizable.*;

public class Texts {
    // Sensei

    static Local<String> MOUNTAINS_ARE_AGAIN_MERELY_MOUNTAINS =
        local("Mountains are again merely mountains.")
        .fr("Les montagnes sont de nouveau de simples montagnes.");
    static Local<String> THINKING =
        local("Thinking %s ...")
        .fr("En pensant %s ...");
    static Local<String> HAS_DAMAGED_YOUR_KARMA =
        local("%s.%s has damaged your karma.")
        .fr("%s.%s a alourdi ton karma.");
    static Local<String> THE_MASTER_SAYS =
        local("The master says:")
        .fr("Le maître dit:");
    static Local<String> YOU_HAVE_NOT_REACHED_ENLIGHTMENT =
        local("  You have not yet reached enlightment ...")
        .fr("  Tu n'as pas encore atteint l'illumination ...");
    static Local<String> EXPECTED_METHOD_TO_BE_PUBLIC =
        local("Expected  method %s to be public, but found it not public.")
        .fr("Attendu à ce que la méthode %s soit publique, mais ce n'est pas le cas.");
    static Local<String> THE_METHOD_APPEARS_TO_PRODUCE_AN_ERROR =
        local("The method %s() appears to produce an error: %s.")
        .fr("La méthode %s() a produit une erreur: %s.");
    static Local<String> EXPECTED_TO_FIND_MEHOD_NO_PARAMS =
        local("Expected to find a method called '%s' in src/main/java/koans/english/%s.java but did not find it.")
        .fr("Attendu à une méthode nommée '%s' dans src/main/java/koans/french/%s.java mais ne la trouve pas.");
    static Local<String> EXPECTED_TO_FIND_MEHOD_ONE_PARAM =
        local("Expected to find a method called '%s' in src/main/java/koans/english/%s.java with a '%s' parameter but did not find it.")
        .fr("Attendu à une méthode nommée '%s' dans src/main/java/koans/french/%s.java avec un paramètre '%s' mais ne la trouve pas.");
    static Local<String> EXPECTED_TO_FIND_MEHOD_MANY_PARAMS =
        local("Expected to find a method called '%s' in src/main/java/koans/english/%s.java with parameters of type %s but did not find it.")
        .fr("Attendu à une méthode nommée '%s' dans src/main/java/koans/french/%s.java avec des paramètres de type %s mais ne la trouve pas.");
    static Local<String> PLEASE_MEDITATE_ON =
        local("Please meditate on %s in src/main/java/koans/english/%s.java")
        .fr("Tu peux méditer sur %s in src/main/java/koans/french/%s.java");
    static Local<String> CONSOLE =
        local("Console:")
        .fr("Console:");

    // Assertions
    
    static Local<String> EXPECTED_TO_SEE_IN_CONSOLE_BUT_SAW_NOTHING =
        local("Expected to see '%s' in the console, but did not saw it!")
        .fr("Attendu à voir '%s' dans la console, mais ne l'a pas vu!");
    static Local<String> EXPECTED_TO_SEE_IN_CONSOLE_BUT_SAW_INSTEAD =
        local("Expected to see '%s' in the console, but saw '%s' instead!")
        .fr("Attendu à voir '%s' dans la console, mais vu '%s' à la place!");
    static Local<String> OK_DISPLAYED_IN_CONSOLE =
        local("Ok: displayed '%s' in the console.")
        .fr("Ok: affiché '%s' dans la console.");
    static Local<String> OK_ASKED_FOR_LINE_IN_CONSOLE =
        local("Ok: asked for a line in the console.")
        .fr("Ok: demandé du texte dans la console.");
    static Local<String> EXPECTED_FOR_USER_TO_ANSWER_IN_CONSOLE =
        local("Expected the user to be able to answer in the console, but they were not!")
        .fr("Attendu à ce que l'utilisateur puisse répondre dans la console, mais iel ne la pas pu!");
    static Local<String> EXPECTED_TO_RETURN_INT_BUT_RETURNED_NULL =
        local("Expected %s to return %d but returned null instead!")
        .fr("Attendu à ce que %s retourne %d mais a retourné null à la place!");
    static Local<String> EXPECTED_TO_RETURN_INT_BUT_RETURNED_OTHER_TYPE =
        local("Expected %s to return an integer but returned a '%s' instead!")
        .fr("Attendu à ce que %s retourne un entier mais a retourné un '%s' à la place!");
    static Local<String> EXPECTED_TO_RETURN_INT_BUT_RETURNED =
        local("Expected %s to return %d but returned %d instead!")
        .fr("Attendu à ce que %s retourne %d mais a retourné %d à la place!");
    static Local<String> OK_RETURNED_INT =
        local("Ok: %s returned %d.")
        .fr("Ok: %s a retourné %d.");
    static Local<String> EXPECTED_TO_RETURN_STRING_BUT_RETURNED_NULL =
        local("Expected %s to return \"%s\" but returned null instead!")
        .fr("Attendu à ce que %s retourne \"%s\" mais a retourné null à la place!");
    static Local<String> EXPECTED_TO_RETURN_STRING_BUT_RETURNED_OTHER_TYPE =
        local("Expected %s to return a String but returned a %s instead!")
        .fr("Attendu à ce que %s retourne une String mais a retourné un '%s' à la place!");
    static Local<String> EXPECTED_TO_RETURN_STRING_BUT_RETURNED =
        local("Expected %s to return \"%s\" but returned \"%s\" instead!")
        .fr("Attendu à ce que %s retourne \"%s\" mais a retourné \"%s\" à la place!");
    static Local<String> OK_RETURNED_STRING =
        local("Ok: %s returned \"%s\".")
        .fr("Ok: %s a retourné \"%s\".");
}
