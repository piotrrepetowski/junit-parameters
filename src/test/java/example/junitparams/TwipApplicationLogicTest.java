package example.junitparams;

import net.sf.twip.TwiP;
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(TwiP.class)
public class TwipApplicationLogicTest {

    @Test
    public void testAdd(int a, int b) {
        assertEquals(a + b, ApplicationLogic.add(a, b));
    }

//    @Test
//    public void testIsEmptyString(String input, boolean expected) {
//        assertEquals(expected, ApplicationLogic.isEmptyString(input));
//    }
}
