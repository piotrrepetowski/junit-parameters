package example.junitparams;

import java.util.Arrays;
import java.util.Collection;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(value = Parameterized.class)
public class JUnitApplicationLogicTest {

    private final String input;

    private final boolean expected;

    public JUnitApplicationLogicTest(String input, boolean expected) {
        this.input = input;
        this.expected = expected;
    }

    @Parameters
    public static Collection<Object[]> dataProvider() {
        Object[][] data = {{"", true}, {null, true}, {"  ", true}, {"foo", false}, {"  foo ", false}};
        return Arrays.asList(data);
    }

    @Test
    public void testAdd() {
        // Not able to parameterize other methods
        assertEquals(2, ApplicationLogic.add(1, 1));
    }

    @Test
    public void testIsEmptyString() {
        assertEquals(expected, ApplicationLogic.isEmptyString(input));
    }
}
