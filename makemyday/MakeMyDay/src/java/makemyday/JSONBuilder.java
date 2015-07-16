/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package makemyday;

import java.io.*;
import java.util.ArrayList;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;

/**
 *
 * @author fchen
 */
public class JSONBuilder {

    ArrayList<Event> eventList1;
    ArrayList<Event> eventList2;
    ArrayList<Route> routeList1;
    ArrayList<Route> routeList2;
    // PlanList p1;
    // PlanList p2;
    ArrayList[] pArr = new ArrayList[2];

    public JSONBuilder(ArrayList<Event> eventList1, ArrayList<Event> eventList2, ArrayList<Route> routeList1, ArrayList<Route> routeList2) {
        //this.p1 = new PlanList(eventList1, routeList1);
        //this.p2 = new PlanList(eventList2, routeList2);
        // p1.getList().add(0, new String("test"));
        pArr[0] = new ArrayList();
        pArr[1] = new ArrayList();
        for (Event e : eventList1) {
            pArr[0].add(e);
        }
        for (Route r : routeList1) {
            pArr[0].add(r);
        }
        for (Event e : eventList2) {
            pArr[1].add(e);
        }
        for (Route r : routeList2) {
            pArr[1].add(r);
        }
        // pArr[0] = p1.getList();
        //pArr[1] = p2.getList();

    }

    public JSONBuilder() {
    }

    public String build() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        mapper.enableDefaultTyping();
        mapper.configure(SerializationConfig.Feature.WRAP_ROOT_VALUE, true);
        mapper.configure(SerializationConfig.Feature.INDENT_OUTPUT, true);
        Writer strWriter = new StringWriter();

        mapper.writeValue(strWriter, pArr);

        String userDataJSON = strWriter.toString();
        userDataJSON = userDataJSON.replace("ArrayList[]", "planlist");
        userDataJSON = userDataJSON.replace("makemyday.Event", "event");
        userDataJSON = userDataJSON.replace("makemyday.Route", "route");
        System.out.println(userDataJSON);


        try {
            // Create file 
            FileWriter fstream = new FileWriter("/Users/Cherry/Dropbox/makemyday/MakeMyDay/web/json/jsonSample.json");
            //in RootFolder: MakeMyDay
            BufferedWriter out = new BufferedWriter(fstream);
            out.write(userDataJSON);

            System.out.println("json file writen");
            //Close the output stream
            out.close();
        } catch (Exception e) {//Catch exception if any
            System.err.println("Error: " + e.getMessage());
        }

        return userDataJSON;

    }
    
    public static void main(String[] args) throws Exception {
        ArrayList<Event> eventList1 = new ArrayList<Event>();
        ArrayList<Event> eventList2 = new ArrayList<Event>();
        ArrayList<Route> routeList1 = new ArrayList<Route>();
        ArrayList<Route> routeList2 = new ArrayList<Route>();
        Planner p = new Planner("94043", 50, "2012-07-07", new String[]{"Fitness", "spirituality", "hiking"});
        p.fetchEvent();


        eventList1 = p.plan1();
        eventList2 = p.plan2();
        routeList1 = p.getRouteList(eventList1);
        routeList2 = p.getRouteList(eventList2);

        for (int i = 0; i < routeList1.size(); ++i) {
            System.out.println(routeList1.get(i).toString());
        }

        for (int i = 0; i < routeList2.size(); ++i) {
            System.out.println(routeList2.get(i).toString());
        }
        JSONBuilder jb = new JSONBuilder(eventList1, eventList2, routeList1, routeList2);
        System.out.println(jb.build());

    }
}
