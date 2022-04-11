import org.junit.jupiter.api.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.*;

class RegexParserTest {

    @Test
    void splitItems() {
        String regex = "[;|*|%|^|#{2}]";
        String testString = "naMe:Milk;price:3.23;type:Food;expiration:1/25/2016##" +
                "naME:BreaD;price:1.23;type:Food;expiration:1/02/2016##" +
                "NAMe:BrEAD;price:1.23;type:Food;expiration:2/25/2016##" +
                "naMe:MiLK;price:3.23;type:Food^expiration:1/11/2016##";
        String expected = "naMe:Milk\n" +
                "price:3.23\n" +
                "type:Food\n" +
                "expiration:1/25/2016\n" +
                "\n" +
                "naME:BreaD\n" +
                "price:1.23\n" +
                "type:Food\n" +
                "expiration:1/02/2016\n" +
                "\n" +
                "NAMe:BrEAD\n" +
                "price:1.23\n" +
                "type:Food\n" +
                "expiration:2/25/2016\n" +
                "\n" +
                "naMe:MiLK\n" +
                "price:3.23\n" +
                "type:Food\n" +
                "expiration:1/11/2016\n" +
                "\n";
        String actual = RegexParser.splitItems(testString);

        assertEquals(actual, expected);
    }


    @Test
    void removeColonsFromSplitString() {
        String testString = "naMe:Milk;price:3.23;type:Food;expiration:1/25/2016##" +
                "naME:BreaD;price:1.23;type:Food;expiration:1/02/2016##" +
                "NAMe:BrEAD;price:1.23;type:Food;expiration:2/25/2016##" +
                "naMe:MiLK;price:3.23;type:Food^expiration:1/11/2016##";
       String PARSE_ME = RegexParser.splitItems(testString);
       String actual = RegexParser.removeColonsFromSplitString(PARSE_ME);
       String expected = "naMe\tMilk\n" +
               "price\t3.23\n" +
               "type\tFood\n" +
               "expiration\t1/25/2016\n" +
               "\n" +
               "naME\tBreaD\n" +
               "price\t1.23\n" +
               "type\tFood\n" +
               "expiration\t1/02/2016\n" +
               "\n" +
               "NAMe\tBrEAD\n" +
               "price\t1.23\n" +
               "type\tFood\n" +
               "expiration\t2/25/2016\n" +
               "\n" +
               "naMe\tMiLK\n" +
               "price\t3.23\n" +
               "type\tFood\n" +
               "expiration\t1/11/2016\n" +
               "\n";

       assertEquals(actual,expected);

    }
}