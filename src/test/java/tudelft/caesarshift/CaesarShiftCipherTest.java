package tudelft.caesarshift;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CaesarShiftCipherTest {

    @Test
    public void normalShift() {
        CaesarShiftCipher c = new CaesarShiftCipher();
        Assertions.assertEquals("cde", c.CaesarShiftCipher("abc", 2));
    }

    @Test
    public void wrapAroundShift() {
        CaesarShiftCipher c = new CaesarShiftCipher();
        Assertions.assertEquals("abc", c.CaesarShiftCipher("xyz", 3));
    }

    @Test
    public void invalidCharacters() {
        CaesarShiftCipher c = new CaesarShiftCipher();
        Assertions.assertEquals("invalid", c.CaesarShiftCipher("abC", 2));
    }

    // Extra recomendado
    @Test
    public void negativeShift() {
        CaesarShiftCipher c = new CaesarShiftCipher();
        Assertions.assertEquals("xyz", c.CaesarShiftCipher("abc", -3));
    }
}
