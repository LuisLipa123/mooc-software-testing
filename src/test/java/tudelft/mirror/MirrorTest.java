package tudelft.mirror;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class MirrorTest {

    @Test
    void example_abXYZba_returns_ab() {
        Mirror m = new Mirror();
        assertEquals("ab", m.mirrorEnds("abXYZba"));
    }

    @Test
    void example_abca_returns_a() {
        Mirror m = new Mirror();
        assertEquals("a", m.mirrorEnds("abca"));
    }

    @Test
    void example_aba_returns_aba() {
        Mirror m = new Mirror();
        assertEquals("aba", m.mirrorEnds("aba"));
    }

    @Test
    void evenLengthPalindrome_abba_returns_abba() {
        Mirror m = new Mirror();
        assertEquals("abba", m.mirrorEnds("abba"));
    }

    @Test
    void noMirrorAtAll_ab_returns_empty() {
        Mirror m = new Mirror();
        assertEquals("", m.mirrorEnds("ab"));
    }
}
