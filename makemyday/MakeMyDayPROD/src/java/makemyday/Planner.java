/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package makemyday;

import java.io.BufferedReader;

import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import json.*;
import java.util.*;
import json.JSONArray;
import json.JSONException;
import json.JSONObject;

/**
 *
 * @author fchen
 */
public class Planner {

    String zipCode;
    int radius;
    String date;//yyyy-mm-dd
    String[] cat = new String[3];
    ArrayList<Event>[] e;

    public String[] dateConverter(String date) {

        int first = date.indexOf("-");
        int sec = date.lastIndexOf("-");

        String dd = date.substring(sec + 1);
        String mm = date.substring(first + 1, sec);
        String yyyy = date.substring(0, first);

        String sDate = mm + dd + yyyy;
        String secondDay = String.valueOf(Integer.valueOf(dd) + 1);
        if (secondDay.length() == 1) {
            secondDay = "0" + secondDay;
        }
        String eDate = mm + secondDay + yyyy;

        String[] s = new String[]{sDate, eDate};

        return s;
    }

    public Planner(String zipCode, int radius, String date, String[] cat) {
        this.zipCode = zipCode;
        this.radius = radius;
        this.date = date;
        this.cat[0] = cat[0];
        this.cat[1] = cat[1];
        this.cat[2] = cat[2];
        e = new ArrayList[3];
        e[0] = new ArrayList<Event>();//length = 3
        e[1] = new ArrayList<Event>();//length = 3
        e[2] = new ArrayList<Event>();//length = 3
    }

    public Event[][] plan() {
        ArrayList<Event> plan1 = plan1();
        System.out.println("==========PLAN 1=================");
        for (int i = 0; i < plan1.size(); ++i) {
        	System.out.println(plan1.get(i).ToString());
        }
        
        System.out.println("==========PLAN 2=================");
        ArrayList<Event> plan2 = plan2();
        System.out.println("==========PLAN 2====XXXXXXXXXXXXXX=");
        for (int i = 0; i < plan2.size(); ++i) {
        	System.out.println(plan2.get(i).ToString());
        }
        System.out.println("==========PLAN 2====XXXXXXXXXXXXXX=");
        
        System.out.println("==========PLAN 3=================");
        ArrayList<Event> plan3 = plan3();
        for (int i = 0; i < plan3.size(); ++i) {
        	System.out.println(plan3.get(i).ToString());
        }
        
        
        System.out.println("==========END=================");
        return null;
    }
    
    

    public ArrayList<Route> getRouteList(ArrayList<Event> events) throws Exception {
    	ArrayList<Route> list = new ArrayList<Route>();
    	for (int i = 0; i < events.size() -1; ++i) {
    		RouteCalculator dir = new RouteCalculator(events.get(i).address, events.get(i+1).address);
    		Route r = dir.getRoute();
    		list.add(r);
    	}
    	return list;
    }
   
    
	public ArrayList<Event> plan3() {
		ArrayList<Event> eList = new ArrayList<Event>();
		for (int i = 0; i < e[0].size(); ++i) {
			eList.add(e[0].get(i));
		}
		for (int i = 0; i < e[1].size(); ++i) {
			eList.add(e[1].get(i));
		}
		for (int i = 0; i < e[2].size(); ++i) {
			eList.add(e[2].get(i));
		}
 		ArrayList<Event> sList = this.SortFinalTimes(eList);
		ArrayList<Event> rList = new ArrayList<Event>();
		//rList.add(sList.get(0));
		int j = 0;
		for (int i = 1; i < sList.size(); i++) {
			if (sList.get(i).startTime.compareTo(rList.get(j).endTime) >= 0) {
				rList.add(sList.get(i));
				j = i;
			}
		}
		return rList;
	}
    
    public Date AddTime(Date d, int hours) {
    	 Calendar cal=Calendar.getInstance();
         cal.setTimeZone(TimeZone.getTimeZone("America/Los_Angeles"));
         cal.setTime(d);
         cal.add(Calendar.HOUR_OF_DAY, hours);
         return cal.getTime();
    }
    
    public Boolean IsOverlapping(Event e, ArrayList<Event> array) {
        Date start = e.startTime;
        Date end = e.endTime;
        
  //    System.out.println(";;;;;;;;;;;;;"+start + "====" + end);
        for (int i = 0; i < array.size(); ++i) {
    //    	System.out.println(array.get(i).startTime);
     //   	System.out.println(array.get(i).endTime);
            if (start.after(array.get(i).startTime)
            		&& start.before(array.get(i).endTime)) {
                 //   && start.before(AddTime(array.get(i).endTime, 1))) {
                return true;
            }
            if (end.after(array.get(i).startTime)
                    && end.before(array.get(i).endTime)) {
                return true;
            }
            if (start.before(array.get(i).startTime) &&
            	end.after(array.get(i).endTime)) {
            	return true;
            }
        }
       // System.out.println("false");
        return false;
    }

    public Event GetNextBestEvent(ArrayList<Event> array, int index) {
        for (int i = 0; i < e[index].size(); ++i) {
            if (!IsOverlapping(e[index].get(i), array)) {
                return e[index].get(i);
            }
        }
        return null;
    }

    public ArrayList<Event> plan1() {
        ArrayList<Event> array = new ArrayList<Event>();
        int next_index = 1;
        if (e[0].size() > 0) {
            array.add(e[0].get(0));
        } else if (e[1].size() > 0) {
            array.add(e[1].get(0));
            next_index = 2;
        } else if (e[2].size() > 0) {
            array.add(e[2].get(0));
            next_index = -1;
        }
        if (next_index == -1) {
            return array;
        }
        Event event = this.GetNextBestEvent(array, next_index);
        if (event != null) {
            array.add(event);
        }
        next_index += 1;
        if (next_index > 2) {
            return array;
        }
        event = this.GetNextBestEvent(array, next_index);
        if (event != null) {
            array.add(event);
        }
        return timeStripper(array);
    }
    /*
    public ArrayList<Event> timeStripper(ArrayList<Event> in) {
    	ArrayList<Event> out = new ArrayList<Event>();
    	for (int i = 0; i < in.size(); ++i) {
    		Event eve = in.get(i);
    		
    	}
    	return out;
    	
    }
    */
    
    
      public ArrayList<Event> timeStripper(ArrayList<Event> in) {
    	ArrayList<Event> out = new ArrayList<Event>();
    	for (int i = 0; i < in.size(); ++i) {
    		Event eve = in.get(i);
    		String str = eve.startTime.toString();
    		eve.startTimeStr = str; 
    		eve.endTimeStr = eve.endTime.toString();
    		out.add(eve);
    	}
    	return out;	
    }
    
    public ArrayList<Event> plan2(){
    	//I have 3 arrrays - e1,e2,e3
    	//step1 - form single list of 27 events.
    	//ArrayList<Event>  mergeEvt= new ArrayList<Event>();
    	
    	ArrayList<Event>[] mergeEvt= new ArrayList[27];
    //	ArrayList<Event>[] arr = new ArrayList[3];
    	
    	boolean b0 = true, b1 = true, b2 = true;
    	if (e[0].size() == 0) {
    		b0 = false;
    	}
    	if (e[1].size() == 0) {
    		b1 = false;
    	}
    	if (e[2].size() == 0) {
    		b2 = false;
    	}
    	int prev_i = -1, prev_j = -1, prev_k = -1;
    	int indx=0;
    	for(int i=0;i<e[0].size() || i < 3;i++)
    	{
    		for(int j=0;j<e[1].size() || j < 3;j++)
    		{
    			for (int k=0;k<e[2].size() || k < 3;k++)
    			{
    				if (prev_i == i && prev_j == j && prev_k == k) {
    					continue;
    				}
    				
    				mergeEvt[indx] = new ArrayList<Event>();
    				if (i < e[0].size()) {
    					
    				mergeEvt[indx].add(e[0].get(i));
    				}
    				if (j < e[1].size()) {
    				
    				mergeEvt[indx].add(e[1].get(j));
    				}
    				if (k < e[2].size()) {
    					
    				mergeEvt[indx].add(e[2].get(k));
    				}
    				if (mergeEvt[indx].size() > 0) {
    				indx++;
    				}
    				prev_i = i;
    				prev_j = j;
    				prev_k = k;
    			}
    		}
    	}
    	ArrayList<Event>[] resultEvt= new ArrayList[indx];
    	int maxSize=-1;
    	int maxRSVP=0;
    	int maxInd=-1;
    	
//    	System.out.println(indx);
    	for(int i=0;i<indx;i++)
    	{
    	//	System.out.println(mergeEvt[i].size());
    		resultEvt[i]=activitySelect(mergeEvt[i]);
    	//	System.out.println(resultEvt[i].size());
    		int sumRSVP=computeRSVP(resultEvt[i]);
    	//	System.out.println("sumrsvp: " + sumRSVP);
    		if(maxSize<resultEvt[i].size())
    		{
    			maxInd=i;
    			maxSize=resultEvt[i].size();
    			maxRSVP=sumRSVP;
    		}
    		else if(maxSize==resultEvt[i].size())
    		{
    			if(sumRSVP>maxRSVP)
    			{
    				maxRSVP=sumRSVP;
    				maxInd=i;
    			}
    		}
    	}
    	//System.out.println("resultEvt size:" + resultEvt[maxInd].size());
    	//System.out.println("maxrsvp:" + maxRSVP);
    //	System.out.println(resultEvt[0].get(0));
    	return timeStripper(resultEvt[maxInd]);
    }
    public int computeRSVP(ArrayList<Event> rE)
    {
    	int sumRSVP=0;
    	for (int i=0;i<rE.size();i++)
    	{
    		sumRSVP+=rE.get(i).RSVPNum;
    	}
    		return sumRSVP;
    }
    
    public ArrayList<Event> SortFinalTimes(ArrayList<Event> eList) {
    	ArrayList<Date> endList = new ArrayList<Date>();
    	ArrayList<Integer> indexes = new ArrayList<Integer>();
    	ArrayList<Event> res=new ArrayList<Event>(eList.size());
    	res=eList;
    	for(int i=0;i<eList.size();i++)
    	{
    		indexes.add(i);
    		endList.add(i,eList.get(i).endTime);
    	}
    	
    	// Sort all final times
    	for(int i=0;i<endList.size()-1;i++)
    	{
    		for(int j=i+1;j<endList.size();j++)
    		{
    			if(endList.get(i).compareTo(endList.get(j))>0)
    			{
    				Event temp=eList.get(j);
    				res.set(j,eList.get(i));
    				res.set(i, temp);
    				//swap dates
    			/*	Date temp=endList.get(j);
    				endList.set(j, endList.get(i));
    				endList.set(i,temp);
    				
    				// swap indexes
    				int tempIndx=j;
    				System.out.println(tempIndx);
    				indexes.set(j, i);
    				indexes.set(i,tempIndx);*/
    			}
    		}
    	}
    	//for (int i = 0; i < indexes.size(); ++i) {
    		
    		//System.out.println("indx " + indexes.get(i));
    	//	finalList.add(eList.get(indexes.get(i)));
    	//}
    //	return finalList;
//    	System.out.println("res size: " + res.size());
    	return res;
    }
    public ArrayList<Event> activitySelect(ArrayList<Event> sList)
    {
    	ArrayList<Event> rList= new ArrayList();
    	
    	ArrayList<Event> eList = this.SortFinalTimes(sList);
    	//System.out.print("elist size:" + eList.size());
    	// Check for the next event with a non over lapping start time
    	for (int i = 0; i < eList.size(); ++i) {
    	if(!IsOverlapping(eList.get(i),rList))
    	{
    		//System.out.println("slist" + sList.get(i).eventName);
    		rList.add(eList.get(i));
    		//System.out.println("elist" + eList.get(i).eventName);
    	}
    	}
    	// Form the result list
    	return rList;
    }

    public void jsonBuilder(ArrayList<Event> a1, ArrayList<Event> a2) {
        JSONObject json = new JSONObject();
        String jsonStr = "";

        String[] name = new String[]{"eventName", "startTime", "endTime", "address", "RSVPNum", "cat"};

        
            jsonStr += "{\"plan\":[";
            for (int j = 0; j < 3; j++) {
                if (a1.get(j)==null) {
                    continue;
                }
                json = new JSONObject(a1.get(j), name);
                jsonStr += json.toString();
                jsonStr += "]";
            }
            for (int j = 0; j < 3; j++) {
                if (a2.get(j)==null) {
                    continue;
                }
                json = new JSONObject(a1.get(j), name);
                jsonStr += json.toString();
                jsonStr += "]";
            }
        
        System.out.println(json);

    }

    public Event parseJSONToEvent(JSONArray array, int index, String category, int catWeight) throws Exception {
        JSONObject j = (JSONObject) array.get(index);
        Event e = new Event();
        e.setEventName(j.getString("name"));
        e.setRSVPNum(Integer.valueOf(j.getString("rsvpcount")));
        e.setCategory(category);
        e.setCatWeight(catWeight);
        e.setEventUrl(j.getString("event_url"));
        e.setPhotoUrl(j.getString("photo_url"));

        String addr = j.getString("venue_address1");
        String city = j.getString("venue_city");
        if (!city.isEmpty() && !addr.isEmpty()) {
        	addr += ",";
        }
        addr += city;
        e.setAddress(addr);
        
       
        long utc_time = Long.valueOf(j.getString("utc_time"));
        Calendar cal=Calendar.getInstance();
        cal.setTimeZone(TimeZone.getTimeZone("America/Los_Angeles"));
        Date start = new Date(utc_time);
        e.setStartTime(start);
        
        cal.setTime(e.startTime);
        cal.add(Calendar.HOUR_OF_DAY, 3);
        e.setEndTime(cal.getTime());
            return e;
    }

	public ArrayList<Integer> GetTop3Events(ArrayList<Integer> A1)
	{
		ArrayList<Integer> A = A1;
		ArrayList<Integer> maxIndList = new ArrayList<Integer>();

		for (int j = 0; j < 3; j++)
		{
			int maxVal = -1;
			int maxInd = -1;
			for (int i = 0; i < A.size(); i++)
			{
				if (maxVal < A.get(i))
				{
					maxVal = A.get(i);
					maxInd = i;
				}
			}
			if (maxInd != -1) {
				maxIndList.add(maxInd);
				A.set(maxInd, -1);
			}
		}
		return maxIndList;
    }
    
    
    public void fetchEvent() throws Exception {
        for (int j = 0; j < 3; ++j)
    	
        {
            //fetch the url, get JSON obj, create e[0],e2,e3
            String urlStr = "http://api.meetup.com/events.json?";
            urlStr += "zip=" + zipCode + "&";
            urlStr += "topic=" + cat[j] + "&";
            urlStr += "radius=" + radius + "&";
            urlStr += "before=" + dateConverter(date)[1] + "&";
            urlStr += "after=" + dateConverter(date)[0] + "&";
            urlStr += "key=" + "2346654b1f0544044654ee163c1d41";
            System.out.println(urlStr);

            try {
                JSONObject json = new JSONObject(readUrl(urlStr));

                JSONArray results = json.getJSONArray("results");
               
              //  System.out.print("results: " + results.length());
                ArrayList<Integer> rsvpcounts = new ArrayList<Integer>();
                for (int i = 0; i < results.length(); ++i) {
                	JSONObject obj = (JSONObject) results.get(i);
                	rsvpcounts.add(Integer.valueOf(obj.getString("rsvpcount")));
                }
                
                ArrayList<Integer> indexes = this.GetTop3Events(rsvpcounts);
               
                
                for (int i = 0; i < indexes.size(); ++i) {
                //	System.out.println("index: " + indexes.get(i).toString());
                    Event event = this.parseJSONToEvent(results, indexes.get(i), cat[j], 3-j);
                    e[j].add(event);
                    System.out.println(event.ToString());
                }

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }


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

    public static void main(String[] args) throws Exception {
    	String[] cat = {"Fitness", "diningout", "hiking"};
        Planner a = new Planner("94043", 100, "2012-07-07", cat);
        a.fetchEvent();
        a.plan();
    }
}
