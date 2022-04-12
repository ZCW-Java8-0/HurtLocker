import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexParser {

    public RegexParser(){}

    public static String splitItems(String PARSE_ME){
        String REGEX = "[;|*|%|^|#|@|!]";
        String REPLACE = "\n";
        Pattern pattern = Pattern.compile(REGEX);
        Matcher matcher = pattern.matcher(PARSE_ME);
        PARSE_ME = matcher.replaceAll(REPLACE);

        return PARSE_ME;
    }

    public static String removeColonsFromSplitString(String PARSE_ME){
        String REGEX = "(?=\\W):";
        String REPLACE = "\t";
        Pattern pattern = Pattern.compile(REGEX);
        Matcher matcher = pattern.matcher(PARSE_ME);
        PARSE_ME = matcher.replaceAll(REPLACE);

        return PARSE_ME;
    }
    public static String standardizeNameKey(String PARSE_ME) {
        String REGEX = "(?i)(n)...(?=\\W):";
        String REPLACE = "Name:";
        Pattern pattern = Pattern.compile(REGEX);
        Matcher matcher = pattern.matcher(PARSE_ME);
        PARSE_ME = matcher.replaceAll(REPLACE);

        return PARSE_ME;
    }
    public static String standardizePriceKey(String PARSE_ME) {
        String REGEX = "(?i)(p)....(?=\\W):";
        String REPLACE = "Price:";
        Pattern pattern = Pattern.compile(REGEX);
        Matcher matcher = pattern.matcher(PARSE_ME);
        PARSE_ME = matcher.replaceAll(REPLACE);

        return PARSE_ME;
    }

    public static String standardizeTypeKey(String PARSE_ME) {
        String REGEX = "(?i)(t)y..(?=\\W):";
        String REPLACE = "Type:";
        Pattern pattern = Pattern.compile(REGEX);
        Matcher matcher = pattern.matcher(PARSE_ME);
        PARSE_ME = matcher.replaceAll(REPLACE);

        return PARSE_ME;
    }

    public static String standardizeExpirationKey(String PARSE_ME) {
        String REGEX = "(?i)e.........(?=\\W):";
        String REPLACE = "Expiration:";
        Pattern pattern = Pattern.compile(REGEX);
        Matcher matcher = pattern.matcher(PARSE_ME);
        PARSE_ME = matcher.replaceAll(REPLACE);

        return PARSE_ME;
    }


    public static String standardizeBreadValue(String PARSE_ME) {
        String REGEX = "(?i)(br.ad)(?<=)";
        String REPLACE = "Bread";
        Pattern pattern = Pattern.compile(REGEX);
        Matcher matcher = pattern.matcher(PARSE_ME);
        PARSE_ME = matcher.replaceAll(REPLACE);

        return PARSE_ME;
    }
}
