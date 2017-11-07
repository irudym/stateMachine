/**
 * Created by Igor Rudym on 07-Nov-17.
 * www.fennec.tech
 */
public class Bug extends GameObject {
    private StackFSM brain;
    private int x,y;
    private int dx,dy;
    private int speed;

    public Bug(String name) {
        super(name);
        System.out.println("Create a BUG with name: " + name);
        x = 0;
        y = 0;
        dx = 1;
        dy = 1;
        speed = 0;

        brain = new StackFSM(this);
        brain.pushState(new RunState());
    }

    @Override
    public void update() {
        super.update();
        //update State Machine
        brain.update();

        if (speed != 0) {
            x += dx*speed;
            y += dy*speed;
        }
    }

    public void handleEvent(Event event) {
        System.out.println("Bug [" + name + "] got event: " + event.type);
        brain.handleEvent(event);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public void run() {
        super.run();
        speed = 1;
    }

    @Override
    public void turn() {
        super.turn();
        speed = 0;
        recharge(5);

        double angle = 90*3.1427/180;
        dx = (int)((double)dx*Math.cos(angle) - (double)dy*Math.sin(angle));
        dy = (int)((double)dx*Math.sin(angle) + (double)dy*Math.cos(angle));

    }

    @Override
    public void die() {
        super.die();
        recharge(5);
        speed = 0;
    }

    @Override
    public String getInfo() {
        return new String("BUG["+name+"]:: Position: ("+x+", " + y +
                ")  || Direction: ("+dx+", " + dy + ")  || Speed: " + speed + "  || Action: " + isActiveAction() +
                "  || State: " + brain.getCurrentState().toString());
    }
}
