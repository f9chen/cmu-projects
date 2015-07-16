/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package makemyday;

import java.util.Date;

/**
 *
 * @author fchen
 */
public class Event {

    String eventName;
    Date startTime;
    Date endTime;
    String startTimeStr;
    String endTimeStr;
    String address;
    int RSVPNum;
    String cat;
    int catWeight;
    String eventUrl;
    String photoUrl;

    public Event(String eventName,
            Date startTime,
            Date endTime,
            String address,
            int RSVPNum,
            String cat,
            int catWeight) {
        this.eventName = eventName;
        this.startTime = startTime;
        this.endTime = endTime;
        this.address = address;
        this.RSVPNum = RSVPNum;
        this.cat = cat;
        this.catWeight = catWeight;
    }
    
    public Event(){}
    
    public String ToString() {
    	String x = "";
    	x += eventName + " ";
    	x += address + " ";
    	x += startTimeStr + " ";
    	x += endTimeStr + " ";
    	x += Integer.toString(RSVPNum) + " ";
    	x += cat + " ";
    	x += Integer.toString(catWeight) + " ";
    	x += eventUrl + " ";
    	x += photoUrl + " ";
    	return x;
    }
    
    public void setEventUrl(String url) {
    	this.eventUrl = url;
    }
    
    public void setPhotoUrl(String url) {
    	this.photoUrl = url;
    }
    
    public void setCategory(String cat) {
    	this.cat = cat;
    }
    
    public void setCatWeight(int catWeight) {
    	this.catWeight = catWeight;
    }
    
    public void setEventName(String eventName){
        this.eventName = eventName;
    }
    
    public void setStartTime(Date startTime){
        this.startTime = startTime;
    }
    
    public void setEndTime(Date endTime){
        this.endTime = endTime;
    }
    
    public void setAddress(String address){
        this.address = address;
    }
    
    public void setRSVPNum(int RSVPNum){
        this.RSVPNum = RSVPNum;
    }
    
     public String getCategory() {
    	return cat;
    }
    
    public int getCatWeight() {
    	return catWeight;
    }
    
    public String getEventName(){
        return eventName;
    }
    
    public Date getStartTime(){
        return startTime;
    }
    
    public Date getEndTime(){
       return endTime;
    }
    
    public String getAddress(){
        return address;
    }
    
    public int getRSVPNum(){
        return RSVPNum;
    }
    
    public String getEventUrl(){
        return eventUrl;
    }
    
    public String getPhotoUrl(){
        return photoUrl;
    }
    
    public String getStartTimeStr(){
        return startTimeStr;
    }
    
    public String getEndTimeStr(){
        return endTimeStr;
    }
}
