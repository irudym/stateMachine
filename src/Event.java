/**
 * Created by Igor Rudym on 07-Nov-17.
 * www.fennec.tech
 */
public class Event {
    public int type;

    public Event(int type) {
        this.type = type;
    }

    public final static int EVENT_TAP = 100;
    public final static int EVENT_OUT_EDGE = 200;
}
