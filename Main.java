// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
import java.util.*;


public class Main {
    public static void main(String[] args) {

        //create a month for user

        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        day[] month;
        int m = calendar.get(Calendar.MONTH) + 1;
        if (m == 2 && calendar.get(Calendar.MONTH) / 4 == 0) {
            month = new day[27];
        } else if (m % 2 == 0) {
            month = new day[29];
        } else {
            month = new day[30];
        }

        day today = new day(date);

        ArrayList<String> todo = new ArrayList<String>();
        boolean x = true;
        while (x) {
            Scanner scan = new Scanner(System.in);  // Create a Scanner object
            System.out.println("Enter action you'd like performed from below:\n\nenter activity\ninspect activity\n\nadd to to-do list\nremove from to-do list\n\nget random activity\ndisplay schedule\n\nnone ");

            String action = scan.nextLine();  // Read user input
            if (action.equals("enter activity")) {
                boolean keepOnEntering = true;
                while (keepOnEntering) {

                    System.out.println("Enter name of activity");
                    String actName = scan.nextLine();  // Read user input

                    System.out.println("Enter start time ");
                    int startTime = scan.nextInt();

                    System.out.println("Enter duration(optional)");
                    double dur = scan.nextDouble();

                    System.out.println("Is it work related(true false)(optional)");
                    boolean w = scan.nextBoolean();

                    System.out.println(actName + " " + startTime + " " + dur + " " + w);
                    if (dur == 0 || !w) {
                        Activity act = new Activity(actName, startTime, w);
                        today.addActivity(act, startTime);
                        System.out.println("done");
                    } else {
                        Activity act = new Activity(actName, startTime, w, dur);
                        today.addActivity(act, startTime);
                        System.out.println("done");
                    }
                    // x = false;
                    System.out.println("would you like to add another activity?");
                    scan.nextLine();
                    String again = scan.nextLine();
                    if (again.equals("yes")) {
                        x = true;
                    } else {

                        break; // no longer needs to add an activeity!
                    }
                }


            } else if (action.equals("add to to-do list")) {

                System.out.println("What would you like to add to your list?");

                String bullet = scan.nextLine();

                todo.add(bullet);
                System.out.println(todo);

                x = false;
                System.out.println("would you like to perform another action?");
                String again = scan.nextLine();
                if (again.equals("yes")) {
                    x = true;
                }

            } else if (action.equals("remove from to-do list")) {

                System.out.println("What would you like to remove from your list?");

                String bullet = scan.nextLine();

                todo.remove(bullet);
                System.out.println(todo);

                x = false;
                System.out.println("would you like to perform another action?");
                String again = scan.nextLine();
                if (again.equals("yes")) {
                    x = true;
                }

            } else if (action.equals("get random activity")) {

                System.out.println(todo.get((int) (Math.random() * todo.size())));
                x = false;
                System.out.println("would you like to perform another action?");
                String again = scan.nextLine();
                if (again.equals("yes")) {
                    x = true;
                }
            } else if (action.equals("display schedule")) {
                System.out.println(" Time\t activity");
                for (int i = 0; i < day.dayTings.length; i++) {
                    if (day.dayTings[i] != null) {
                        System.out.println(i / 4 + "\t " + day.dayTings[i].getName());
                    }
                }
            }else if(action.equals("inspect activity")){

                System.out.println(" What time would you like to check if there is an activity?");
                int again = scan.nextInt();

                Activity thisAct = day.dayTings[(again/100) * 4];
                System.out.println("You have " + thisAct.getName() + " that will start at " + thisAct.getStart() + " and will take " + thisAct.getDuration() + " mins");

            }else if (action.equals("none")){
                x = false;
            }
        }

    }
}