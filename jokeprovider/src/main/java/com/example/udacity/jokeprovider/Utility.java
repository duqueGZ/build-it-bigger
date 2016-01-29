package com.example.udacity.jokeprovider;

import java.util.Arrays;
import java.util.List;

/**
 * Created by davidduque on 29/01/16.
 */
public final class Utility {

    public static final int NUM_JOKES = 10;

    // Set of jokes in english available from jokeprovider library.
    // English is the language used by default
    public static final List<String> ENGLISH_JOKES = Arrays.asList(
            "Did you hear about the restaurant on Mars? Great food, but no atmosphere!",
            "Opera is when a guy gets stabbed in the back, and instead of bleeding, he sings.",
            "Cats are smarter than dogs. You cannot get eight cats to pull a sled through snow",
            "Cannot find REALITY.SYS. Universe halted.",
            "My software never has bugs. It just develops random features.",
            "Bad command. Bad, bad command! Sit! Stay! Staaay...",
            "Error: Keyboard not attached. Press F1 to continue.",
            "If you're not part of the solution, you're part of the precipitate.",
            "Why isn't there mouse-flavored cat food?",
            "Pride is what we have. Vanity is what others have.");

    // Set of jokes in spanish, which is another language supported by this library.
    public static final List<String> SPANISH_JOKES = Arrays.asList(
            "¡Cómete la sopa de fideos! Y Fideos se quedó sin comer.",
            "Érase una vez un chiste tan malo, tan malo... que pegaba a los chistecitos.",
            "¿Cómo se llama un boomerang que no vuelve? Un palo.",
            "¿Cuál es el colmo de un jardinero? Que su novia se llame Rosa y lo deje plantado.",
            "¿Qué le dice una impresora a otra? ¿Esas hoja es tuya o es impresión mía?",
            "¿Qué hace un cable al ver a otro cable? Seguirle la corriente.",
            "Tienes menos futuro que un submarino descapotable.",
            "Estás más perdido que un pulpo en un garaje.",
            "Tienes más peligro que Espinete en una tienda de globos.",
            "¡No juegues con fuego! Y Fuego se quedó sin amigos.");
    private Utility() {
        // In order to avoid instantiation of this class
    }
}
