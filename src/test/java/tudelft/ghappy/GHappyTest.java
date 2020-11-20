package tudelft.ghappy;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import tudelft.mirror.Mirror;

public class GHappyTest {
    @Test
    public void g_is_happy() {
        GHappy gh = new GHappy();
        boolean result = gh.gHappy("buggy");
        Assertions.assertTrue(result);
    }
    @Test
    public void g_is_not_happy() {
        GHappy gh = new GHappy();
        boolean result = gh.gHappy("xxggyygxx");
        Assertions.assertFalse(result);
    }
    @Test
    public void g_is_not_found() {
        GHappy gh = new GHappy();
        boolean result = gh.gHappy("be");
        Assertions.assertFalse(result);
    }
}
