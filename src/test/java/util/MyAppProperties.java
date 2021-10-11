package util;

//import static java.util.regex.Pattern.quote;

import static jdk.nashorn.internal.parser.JSONParser.quote;

public class MyAppProperties {
    public static String  getBaseUrl()
    {
        String baseUrl = "https://www.ebay.com/";
        return baseUrl;
    }
    public static String getUserId()
    {
        String Userid = quote("admin");
        return Userid;
    }
    public static String getPwd()
    {
        String pwd = quote("admin@123");
        return pwd;
    }
}
