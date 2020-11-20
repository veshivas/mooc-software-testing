package tudelft.caesarshift;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
public class CaesarShiftCipherTest {
    @Test
    public void encrypt_msg_positive_shift() {
        CaesarShiftCipher cs = new CaesarShiftCipher();
        String result = cs.CaesarShiftCipher("abc",3);
        Assertions.assertEquals("adbecf", result);
    }
    @Test
    public void encrypt_msg_negative_shift() {
        CaesarShiftCipher cs = new CaesarShiftCipher();
        String result = cs.CaesarShiftCipher("abc",-3);
        Assertions.assertEquals("axbycz", result);
    }
    @Test
    public void encrypt_msg_unsuccessful() {
        CaesarShiftCipher cs = new CaesarShiftCipher();
        String result = cs.CaesarShiftCipher("abc!",3);
        Assertions.assertEquals("invalid", result);
    }
    @Test
    public void encrypt_large_msg() {
        CaesarShiftCipher cs = new CaesarShiftCipher();
        String result = cs.CaesarShiftCipher("hope you are doing fine",3);
        Assertions.assertEquals("invalid", result);
    }
}
