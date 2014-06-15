package example.junitparams;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(DataProviderRunner.class)
public class TNGApplicationLogicTest {

    @DataProvider
    public static Object[][] testAddDataProvider() {
        return new Object[][]{
            {1, 1, 2},
            {0, 0, 0},
            {2, 1, 3},
            {1, 2, 3}
        };
    }

    @DataProvider
    public static Object[][] testIsEmptyDataProvider() {
        return new Object[][]{
            {"", true},
            {null, true},
            {"   ", true},
            {"foo", false},
            {"  foo  ", false}
        };
    }

    @Test
    @UseDataProvider("testAddDataProvider")
    public void testAdd(int a, int b, int result) {
        assertEquals(result, ApplicationLogic.add(a, b));
    }

    @Test
    @UseDataProvider("testIsEmptyDataProvider")
    public void testIsEmptyString(String input, boolean expected) {
        assertEquals(expected, ApplicationLogic.isEmptyString(input));
    }
}
