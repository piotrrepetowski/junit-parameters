package example.junitparams;

import org.databene.benerator.anno.Bean;
import org.databene.benerator.anno.InvocationCount;
import org.databene.benerator.anno.Source;
import org.databene.benerator.util.UnsafeMethodParamsGenerator;
import org.databene.benerator.wrapper.ProductWrapper;
import org.databene.feed4junit.Feeder;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(Feeder.class)
@Bean(id = "isEmptyGenerator", type = Feed4JUnitApplicationLogicTest.IsEmptyGenerator.class)
public class Feed4JUnitApplicationLogicTest {

    @Test
    public void testAdd(int a, int b) {
        assertEquals(a + b, ApplicationLogic.add(a, b));
    }

    @Test
    @Source("feed4junit-data.csv")
    public void isEmpty(String input, boolean expected) {
        assertEquals(expected, ApplicationLogic.isEmptyString(input));
    }

    @Test
    @Source("isEmptyGenerator")
    @InvocationCount(3)
    public void isEmptyWithCustomGenerator(String input, boolean expected) {
        // Hard to code fixture in test file
        assertEquals(expected, ApplicationLogic.isEmptyString(input));
    }

    public static class IsEmptyGenerator extends UnsafeMethodParamsGenerator {

        private static final Object[][] DATA_SET = {
            {"", true},
            {null, true},
            {"  ", true},
            {"foo", false},
            {"  foo  ", false}
        };

        private static final String TAG_KEY = "lastIndex";

        @Override
        public ProductWrapper<Object[]> generate(ProductWrapper<Object[]> pw) {
            int dataSetIndex = 0;
            if (pw.getTag(TAG_KEY) != null) {
                dataSetIndex = Integer.parseInt(pw.getTag(TAG_KEY));
            }
            if (dataSetIndex < DATA_SET.length - 1) {
                ProductWrapper<Object[]> result = pw.wrap(DATA_SET[dataSetIndex]);
                dataSetIndex++;
                return result;
            } else {
                return null;
            }
        }

    }
}
