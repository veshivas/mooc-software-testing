package tudelft.mirror;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
public class MirrorTest {
    @Test
    public void mirror_found() {
        Mirror mr = new Mirror();
        String result = mr.mirrorEnds("abXYZba");
        Assertions.assertEquals("ab", result);
    }

    @Test
    public void mirror_uneven_input_length() {
        Mirror mr = new Mirror();
        String result = mr.mirrorEnds("aba");
        Assertions.assertEquals("", result);
    }

    @Test
    public void mirror_even_input_length() {
        Mirror mr = new Mirror();
        String result = mr.mirrorEnds("abcdea");
        Assertions.assertEquals("a", result);
    }
    @Test
    public void mirror_not_found() {
        Mirror mr = new Mirror();
        String result = mr.mirrorEnds("abcd");
        Assertions.assertEquals("", result);
    }
}
