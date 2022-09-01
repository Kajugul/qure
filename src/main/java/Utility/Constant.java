package Utility;

import org.apache.commons.lang3.RandomStringUtils;

public class Constant
{
    public static String URL = "https://demo.realworld.io/#/login";

    public static String getUSERNAME()
    {
        return RandomStringUtils.randomAlphabetic(5);
    }

    public static String getPASSWORD()
    {
        return RandomStringUtils.randomAlphanumeric(5);
    }

    public static String getEmail()
    {
        return RandomStringUtils.randomAlphabetic(5) + "@gmail.com";
    }
}
