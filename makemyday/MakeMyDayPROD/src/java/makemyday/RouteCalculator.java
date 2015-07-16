package makemyday;

import json.JSONException;
import json.JSONObject;
import json.JSONArray;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.String;
import java.net.URL;
import java.util.ArrayList;

/**
 *
 * @author fchen
 */
public class RouteCalculator {

    String from;
    String to;
    String result;
    String distance;
    String duration;

    public RouteCalculator(String from, String to) {
        this.from = from.replace(" ", "+");
        this.to = to.replace(" ", "+");
    }
    
    

    private static String readUrl(String urlString) throws Exception {
        BufferedReader reader = null;
        try {
            URL url = new URL(urlString);
            reader = new BufferedReader(new InputStreamReader(url.openStream()));
            StringBuffer buffer = new StringBuffer();
            int read;
            char[] chars = new char[1024];
            while ((read = reader.read(chars)) != -1) {
                buffer.append(chars, 0, read);
            }

            return buffer.toString();
        } finally {
            if (reader != null) {
                reader.close();
            }
        }
    }

    public Route getRoute() throws Exception {

        String urlStr = "http://maps.googleapis.com/maps/api/distancematrix/json?origins=" + from + "&destinations=" + to + "&mode=driving&units=imperial&sensor=false";

        try {
            JSONObject json = new JSONObject(readUrl(urlStr));

            JSONArray a = json.getJSONArray("rows");
            JSONObject b = (JSONObject) a.get(0);
            JSONObject c = (JSONObject) ((JSONArray) b.get("elements")).get(0);
            JSONObject d = c.getJSONObject("distance");
            JSONObject e = c.getJSONObject("duration");
            distance = d.getString("text");
            duration = e.getString("text");
            result = "distance: " + distance + "\nduration: " + duration;
            //System.out.println(result);
            return new Route(distance, duration);

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;

    }

    public String getDistance() {
        return distance;
    }

    public String getDuration() {
        return duration;
    }

    public static void main(String[] args) throws Exception {
        RouteCalculator a = new RouteCalculator("8795 Elk Grove-Florin Road,Elk Grove", "Folsom & Embarcadero,SanFrancisco");
        Route r = a.getRoute();
    }
}
