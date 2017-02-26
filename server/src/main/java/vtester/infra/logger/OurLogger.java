package vtester.infra.logger;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by trond on 14.02.17.
 */
public class OurLogger {
    public static void logInputFromUser(String requsetJson) {
        System.out.println(requsetJson);
    }

    public static void logErrorOnRequest(HttpServletRequest req, Exception e) {
        e.printStackTrace();
        System.out.println(req);
    }
}
