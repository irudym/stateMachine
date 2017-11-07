/**
 * Created by Igor Rudym on 07-Nov-17.
 * www.fennec.tech
 */
public class DeadState extends State {
    public State handleEvent(Event event, GameObject object) {
        return null;
    }

    public State update(GameObject object) {
        return this;
    }

    public void enter(GameObject object) {
        object.markToDelete();
    }

    public String toString() {
        return ">> DeadState";
    }
}
