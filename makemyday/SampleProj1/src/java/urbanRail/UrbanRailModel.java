package urbanRail;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.*;
import java.io.*;
import javax.servlet.http.HttpServletRequest;

/**
 * 
 * @author Fan Chen
 */
public class UrbanRailModel {

    private String cityTag;
    private String pictureURL;
    private int count = 0;
    private String secondURL = "";

    /**
     * doSearch method will use Google I am feeling lucky to search on urbanrail.net
     * for the rail map of the city. If the city exists and there is a rail picture
     * on urbanrail.net, then will fetch the url of the picture as well as the original
     * url of the webpage on urbanrail.net. Handle exception of error by display a 
     * 404 Erro Pic :)
     * @param search the city name
     */
    public void doSearch(String search) {
        String response = "";
        
        String searchRevised = "";
        for (int i = 0; i < search.length(); i++) {
            if (search.charAt(i) == ' ') {
                searchRevised += "%20";
            } else {
                searchRevised += search.charAt(i);
            }
        }

        try {
            // Create a URL for the desired page            
            URL url = new URL("http://google.com/search?q=" + searchRevised + "+site:urbanrail.net&btnI=Im+Feeling+Lucky");
            System.out.println(url.toString());

            // Create an HttpURLConnection.  This is useful for setting headers and for getting the
            // path of the resource that is returned (which may be different than the URL above if
            // redirected).

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setInstanceFollowRedirects(true);
                     
            //set User-Agent HTTP header
            System.setProperty("http.agent", "Mozilla/4.0 (compatible; MSIE 8.0; Windows NT 6.1; Trident/4.0)");
            connection.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 8.0; Windows NT 6.1; Trident/4.0)");

            //To get redirect URL: call getUrl() on URLConnection instance after calling getInputStream():
            
            connection.connect();
            connection.getInputStream();
            URL url2 = connection.getURL();
            secondURL = url2.toString();
            //System.out.println(secondURL);
            HttpURLConnection conn = (HttpURLConnection) url2.openConnection();

            // Read all the text returned by the server
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String str;
            while ((str = in.readLine()) != null) {
                // str is one line of text; readLine() strips the newline character(s)
                response += str;
            }

            in.close();
        } catch (MalformedURLException e) {
        } catch (IOException e) {
        } catch (Exception e) {
        }
        int start = response.indexOf("src=");
        int end = response.indexOf("\"", start + 5); // only start looking after the quote before http
        System.out.println(secondURL);

        int endStr = secondURL.lastIndexOf("/");
        if (!secondURL.contains("urbanrail.net/")) {
            pictureURL = "src=\"http://t0.gstatic.com/images?q=tbn:ANd9GcTljeQuDyuaXwlYvEZggbalzRgNbFlmV1YaPwRp_5OkEC2U1luLqA\"";
        }
        else{
        System.out.println("endStr: " + endStr);
        pictureURL = "src=\"" + secondURL.substring(0, endStr) + "/" + response.substring(start + 5, end + 1); // +1 to include the quote

        System.out.println(secondURL.substring(0, endStr));
        System.out.println(pictureURL);}

        cityTag = search;
    }

    /**
     * Return the redirected URL. Often times it's the URL on urbanrail.net
     * @return the redirected URL.
     */
    public String getWebsiteURL(){
        return (secondURL);
    }
    /**
     * Return the URL of the searched picture
     * @return the URL of the searched picture
     */
    public String getPrictureURL() {
        return (pictureURL);
    }

    /**
     * Return the City Name in String
     * @return the City Name in String
     */
    public String getCityTag() {
        return (cityTag);
    }
}