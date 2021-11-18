package anagram;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import ru.josanr.anagram.Anagram;


public class TestAnagram {

    private final Anagram anagram = new Anagram();


    @Test
    void invertWords_shouldThrowException_whenParameterNull() {
        Assertions.assertThrows(NullPointerException.class, () -> {
            anagram.invertWords(null);
        });
    }

    @Test
    void invertWords_shouldReturnEmptyString_whenParameterEmpty() {
        Assertions.assertEquals("", anagram.invertWords(""));
    }

    @Test
    void invertWords_shouldReturnEmptyString_whenParameterIsSingleSpaceString() {
        Assertions.assertEquals("", anagram.invertWords(" "));
    }

    @Test
    void invertWords_shouldReturnEmptyString_whenParameterIsOnlySpaceString() {
        Assertions.assertEquals("", anagram.invertWords("      "));
    }

    @Test
    void invertWords_shouldReturnSingleCharString_whenParameterIsOnlySingleChar() {
        Assertions.assertEquals("i", anagram.invertWords("i"));
    }

    @Test
    void invertWords_shouldReturnSameString_whenParameterIsSameCharString() {
        Assertions.assertEquals("iiiiiii", anagram.invertWords("iiiiiii"));
    }

    @Test
    void invertWords_shouldReturnInvertedString_whenParameterIsSameCharStringInDifferentCaps() {
        Assertions.assertEquals("IIIiiiIiIi", anagram.invertWords("iIiIiiiIII"));
    }

    @ParameterizedTest
    @CsvSource({
            "abcd, dcba",
            "efgh, hgfe",
            "a1bcd, d1cba",
            "efg!h, hgf!e"
    })
    void invertWords_shouldReturnInvertedString_whenParameterIsString(final String input, final String expected) {
        Assertions.assertEquals(expected, anagram.invertWords(input));
    }

    @Test
    void invertWords_shouldReturnSameString_whenParameterIsOnlyNonAlphabetical() {
        Assertions.assertEquals("!@#$%^&", anagram.invertWords("!@#$%^&"));
    }

    @ParameterizedTest
    @CsvSource({
            "'In order to make tests more useful', 'nI redro ot ekam stset erom lufesu'",
            "'name! them in the& way you re@ad the docume&ntation', 'eman! meht ni eht& yaw uoy da@er eht noitat&nemucod'",
            "'you shouldn't name the src methods', 'uoy tndluoh's eman eht crs sdohtem'",
            "'This appr#oach will he(lp you', 'sihT hcao#rppa lliw pl(eh uoy'"
    })
    void invertWords_shouldReturnInvertedWordsDividedBySpace_whenParameterIsStringWithSpacesBetweenWords(final String input, final String expected) {
        Assertions.assertEquals(expected, anagram.invertWords(input));
    }

}
