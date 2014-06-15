package example.junitparams;

import net.sf.twip.TwiP;
import net.sf.twip.Values;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(TwiP.class)
public class TwipApplicationLogicTest {

    public static final Integer[] A_VALUES = {1, 0, 2, 1};
    public static final Integer[] B_VALUES = {1, 0, 1, 2};

    public static final String[] EMPTY_VALUES = {null, "", "   "};
    public static final String[] NON_EMPTY_VALUES = {"foo", "  foo  "};

    @Test
    public void testAdd(@Values("A_VALUES") Integer a, @Values("B_VALUES") Integer b) {
        // Not allow to provided values for both parameters, helper object must be used
        assertEquals(a + b, ApplicationLogic.add(a, b));
    }

    @Test
    public void testIsEmptyStringWithEmptyValues(@Values("EMPTY_VALUES") String input) {
        assertTrue(ApplicationLogic.isEmptyString(input));
    }

    @Test
    public void testIsEmptyStringWithNonEmptyValues(@Values("NON_EMPTY_VALUES") String input) {
        assertFalse(ApplicationLogic.isEmptyString(input));
    }
}
