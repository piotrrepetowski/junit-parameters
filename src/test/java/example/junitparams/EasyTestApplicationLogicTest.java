package example.junitparams;

import org.easetech.easytest.annotation.DataLoader;
import org.easetech.easytest.annotation.Param;
import org.easetech.easytest.runner.DataDrivenTestRunner;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(DataDrivenTestRunner.class)
@DataLoader(filePaths = {"test-data.csv"})
public class EasyTestApplicationLogicTest {

    @Test
    public void testAdd(@Param(name = "a") int a, @Param(name = "b") int b, @Param(name = "expected") int expected) {
        assertEquals(expected, ApplicationLogic.add(a, b));
    }

    @Test
    public void testIsEmptyString(@Param(name = "input") String input, @Param(name = "expected") boolean expected) {
        // You can pas either null or empty string for param but not both.
        assertEquals(expected, ApplicationLogic.isEmptyString(input));
    }
}
