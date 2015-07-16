/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package makemyday;

/**
 *
 * @author fchen
 */
public class Route {
    String direction ="";
    String duration="";
    
    public Route(String direction, String duration){
        this.direction = direction;
        this.duration = duration;
    }
    
    Route(){}
    
    public String getDirection(){
        return direction;
    }
    
    public String getDuration(){
        return duration;
    }
    
    public void setDirection(String direction){
        this.direction = direction;
        
    }
    
    public void setDuration(String duration){
        this.duration = duration;
    }
    
    @Override
    public String toString(){
        return "direction: "+direction+", duration: "+duration;
    }
}
