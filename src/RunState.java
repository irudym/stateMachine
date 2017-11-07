/**
 * Created by Igor Rudym on 07-Nov-17.
 * www.fennec.tech
 */
public class RunState extends State {
    public State handleEvent(Event event, GameObject object) {
        if(event.type == Event.EVENT_TAP) {
            return new DieState();
        }

        if(event.type == Event.EVENT_OUT_EDGE) {
            return new TurnState();
        }
        return null;
    }
    public State update(GameObject object) {
        return this;
    }

    @Override
    public void enter(GameObject object) {
        object.run();
    }

    @Override
    public String toString() {
        return ">> RunState";
    }
}
