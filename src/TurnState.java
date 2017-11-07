/**
 * Created by Igor Rudym on 07-Nov-17.
 * www.fennec.tech
 */
public class TurnState extends State {

    public State handleEvent(Event event, GameObject object) {
        if (event.type == Event.EVENT_TAP) return new DieState();
        return null;
    }
    public State update(GameObject object) {
        //check if object action is done, and return null otherwise return pointer to class
        if(object.isActiveAction()) return this;
        return null;
    }

    @Override
    public void enter(GameObject object) {
        object.turn();
    }

    @Override
    public String toString() {
        return ">> TurnState";
    }
}
