import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexParser {

    public RegexParser(){}

    public static String splitItems(String PARSE_ME){
        String REGEX = "[;|*|%|^|#]";
        String REPLACE = "\n";
        Pattern p = Pattern.compile(REGEX);

        Matcher m = p.matcher(PARSE_ME);
        PARSE_ME = m.replaceAll(REPLACE);

        return PARSE_ME;
    }

    public static String removeColonsFromSplitString(String PARSE_ME){
        String REGEX = "(?=\\W):";
        String REPLACE = "\t";
        Pattern p = Pattern.compile(REGEX);
        Matcher m = p.matcher(PARSE_ME);
        PARSE_ME = m.replaceAll(REPLACE);

        return PARSE_ME;
    }
    public static String standardizeNameKey(String PARSE_ME) {
        String REGEX = "(n|N)...(?=\\W):";
        String REPLACE = "Name:";
        Pattern p = Pattern.compile(REGEX);
        Matcher m = p.matcher(PARSE_ME);
        PARSE_ME = m.replaceAll(REPLACE);

        return PARSE_ME;
    }
    public static String standardizePriceKey(String PARSE_ME) {
        String REGEX = "(p|P)....(?=\\W):";
        String REPLACE = "Price:";
        Pattern p = Pattern.compile(REGEX);
        Matcher m = p.matcher(PARSE_ME);
        PARSE_ME = m.replaceAll(REPLACE);

        return PARSE_ME;
    }

    public static String standardizeTypeKey(String PARSE_ME) {
        String REGEX = "(t|T)y..(?=\\W):";
        String REPLACE = "Type:";
        Pattern p = Pattern.compile(REGEX);
        Matcher m = p.matcher(PARSE_ME);
        PARSE_ME = m.replaceAll(REPLACE);

        return PARSE_ME;
    }
}
