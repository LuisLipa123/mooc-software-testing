package tudelft.ghappy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GHappyTest {

    @Test
    public void allHappyGs() {
        GHappy gh = new GHappy();
        Assertions.assertTrue(gh.gHappy("xxggxx")); // todas felices
    }

    @Test
    public void singleUnhappyG() {
        GHappy gh = new GHappy();
        Assertions.assertFalse(gh.gHappy("xxgxx")); // g sola
    }

    @Test
    public void mixedHappyAndUnhappy() {
        GHappy gh = new GHappy();
        Assertions.assertFalse(gh.gHappy("xxggyygxx")); // una g sola al final
    }

    // Extra (recomendado)
    @Test
    public void noGs() {
        GHappy gh = new GHappy();
        Assertions.assertTrue(gh.gHappy("xxxx")); // no hay g → true
    }

    @Test
    public void edgeCaseStart() {
        GHappy gh = new GHappy();
        Assertions.assertFalse(gh.gHappy("gxx")); // g al inicio sola
    }
}
