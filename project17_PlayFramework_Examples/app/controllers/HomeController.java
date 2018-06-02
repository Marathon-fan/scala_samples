package controllers;

import play.mvc.*;
import play.libs.Json;
import java.util.*;

/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class HomeController extends Controller {

    /**
     * An action that renders an HTML page with a welcome message.
     * The configuration in the <code>routes</code> file means that
     * this method will be called when the application receives a
     * <code>GET</code> request with a path of <code>/</code>.
     */
    public Result index() {
        String name = request().getQueryString("name");
        Map<String, String> map = new HashMap<>();
        map.put("key1", "hello ");
        map.put("key2", String.format("your name is %s", name));

        // use "http://localhost:9000/?name=yourName" to test this RESTful application

        return ok(Json.toJson(map));
    }

}
