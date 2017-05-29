package br.com.saude.app.project.util;

/**
 * Created by tawan on 4/2/17.
 */
public final class RestUtil {

    private static final String URL_BASE_API = "https://api-saude-app.herokuapp.com/";

    private RestUtil(){}

    public static String getURLBASE() {
        return URL_BASE_API;
    }
}
