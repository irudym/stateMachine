/**
 * Created by Igor Rudym on 07-Nov-17.
 * www.fennec.tech
 */
public class DieState extends State {
    public State handleEvent(Event event, GameObject object) {
        return null;
    }

    public State update(GameObject object) {
        if(object.isActiveAction()) return this;

        //return next state
        return new DeadState();
    }

    @Override
    public void enter(GameObject object) {
        object.die();
    }

    @Override
    public String toString() {
        return ">> DieState";
    }
}
