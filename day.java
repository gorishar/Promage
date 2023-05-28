
import java.util.*;

public class day {

    public static Activity [] dayTings = new Activity[96];
    private Date date;
    public day (Date inDate){
        date = inDate;
    }

    public boolean addActivity (Activity act, int time) {
        if (dayTings[time/100 * 4] == null) {
            dayTings[time/100 * 4] = act;
            return true;
        } else {
            return false;
        }
    }

}

