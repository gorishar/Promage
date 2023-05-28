
import java.util.*;

 class Activity {
     private String name;
     private double duration;
     private boolean work;
     private int start;

     public Activity(String inName, int inStart, boolean inWork, double inDuration){
        name = inName;
        start = inStart;
        duration = inDuration;
        work = inWork;
     }

     public Activity(String inName, int inStart, boolean inWork){
         name = inName;
         start = inStart;
         work = inWork;
     }

     public double getDuration(){
         return duration;
     }

     public boolean getWork(){
         return work;
     }

     public String getName(){
         return name;
     }

     public int getStart(){
         return start;
     }





}
