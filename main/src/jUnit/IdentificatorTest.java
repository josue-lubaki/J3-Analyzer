package jUnit;

import lexicalUnit.IdentificatorUnit;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

/**
 * @author Josue Lubaki
 * @version 1.0
 */
public class IdentificatorTest {

    @ParameterizedTest
    @ValueSource(strings = {"abcdefgh","     abcd      "})
    void isIdentificator(String identificator) {
        assertTrue(IdentificatorUnit.isIdentificator(identificator), "Taille de l'identifacteur inférieure à 8");
    }

    @ParameterizedTest
    @ValueSource(strings = {"ab_","_"})
    void containsUnderscore(String str) {
        assertTrue(IdentificatorUnit.containsUnderscore(str), "l'identifacteur contient underscore");
    }

}