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
}
