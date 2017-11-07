import java.util.Stack;

/**
 * Created by Igor Rudym on 07-Nov-17.
 * www.fennec.tech
 */
public class StackFSM {
    private Stack stateMachine;
    private GameObject object;

    StackFSM(GameObject object) {
        stateMachine = new Stack();
        this.object = object;
    }

    public void update() {
        State state = getCurrentState();
        if(state!=null) {
            State nextState = state.update(object);
            if(nextState == null) {
                //remove the state from the stack
                popState();
                //activate prev state
                State newState = getCurrentState();
                if(newState!=null) newState.enter(object);
            } else
            if (nextState!=state) {
                //remove current state
                popState();

                //activate next state
                pushState(nextState);
            }
        }
    }

    public void handleEvent(Event event) {
        State state = getCurrentState();
        if (state!=null) {
            State newState = state.handleEvent(event, object);
            if (newState != null) {
                //popState();
                pushState(newState);
            }
        }
    }

    public State popState() {
        return (State)stateMachine.pop();
    }

    public void pushState(State state) {
        if(getCurrentState() != state) {
            stateMachine.push(state);
            state.enter(object);
        }
    }

    public State getCurrentState() {
        return stateMachine.empty() ? null : (State)stateMachine.peek();
    }
}
