package example.junitparams;

import junitparams.JUnitParamsRunner;
import static junitparams.JUnitParamsRunner.$;
import junitparams.Parameters;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(JUnitParamsRunner.class)
public class JUnitParamsApplicationLogicTest {

    @Test
    @Parameters(method = "testAddParameters")
    public void testAdd(int a, int b, int expected) {
        assertEquals(expected, ApplicationLogic.add(a, b));
    }

    private Object[] testAddParameters() {
        return $(
                $(1, 1, 2),
                $(0, 0, 0),
                $(2, 1, 3),
                $(1, 2, 3)
        );
    }

    @Test
    @Parameters
    public void testIsEmptyString(String input, boolean expected) {
        assertEquals(expected, ApplicationLogic.isEmptyString(input));
    }

    public Object[] parametersForTestIsEmptyString() {
        return $(
                $("", true),
                $(null, true),
                $("  ", true),
                $("foo", false),
                $("  foo  ", false)
        );
    }
}
