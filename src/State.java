/**
 * Created by Igor Rudym on 07-Nov-17.
 * www.fennec.tech
 */
public abstract class State {
    public abstract State handleEvent(Event event, GameObject object);

    /**
     *
     * @param object - object which the state controls
     * @return     null - in case no more action
     *              pointer to current state - in case state is in a process
     *              pointer to next state - in case object needs to perform next state after current
     */
    public abstract State update(GameObject object);

    public abstract void enter(GameObject object);

    public abstract String toString();
}
