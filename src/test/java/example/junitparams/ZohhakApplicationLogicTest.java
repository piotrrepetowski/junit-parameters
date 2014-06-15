package example.junitparams;

import com.googlecode.zohhak.api.TestWith;
import com.googlecode.zohhak.api.runners.ZohhakRunner;
import static org.junit.Assert.assertEquals;
import org.junit.runner.RunWith;

@RunWith(ZohhakRunner.class)
public class ZohhakApplicationLogicTest {

    @TestWith({
        "1, 1, 2",
        "0, 0, 0",
        "2, 1, 3",
        "1, 2, 3"
    })
    public void testAdd(int a, int b, int expected) {
        assertEquals(expected, ApplicationLogic.add(a, b));
    }

    @TestWith({
        "'', true",
        "null, true",
        "'   ', true",
        "foo, false",
        "'  foo  ', false"
    })
    public void testIsEmptyString(String input, boolean expected) {
        assertEquals(expected, ApplicationLogic.isEmptyString(input));
    }

}
