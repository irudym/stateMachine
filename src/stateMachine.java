/**
 * Created by Igor Rudym on 07-Nov-17.
 * www.fennec.tech
 */
public class stateMachine {
    public static void main(String[] args) {
        System.out.println("State Machine");

        Bug bug1 = new Bug("green-bug");

        int count = 0;
        while(true) {
            bug1.update();

            //check if the bug is dead
            if(bug1.shouldBeDeleted()) {
                bug1 = new Bug("red-bug");
            }

            //check if the bug is out the screen
            if (bug1.getX() > 30 || bug1.getY() > 30) bug1.handleEvent(new Event(Event.EVENT_OUT_EDGE));


            count++;

            if(count == 50) {
                System.out.println(count + "::Simulate click on the bug");
                bug1.handleEvent(new Event(Event.EVENT_TAP));
            }
            if (count > 60) break;
        }

        System.out.println("Simulation is done");
    }
}
