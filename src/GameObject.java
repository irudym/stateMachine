/**
 * Created by Igor Rudym on 07-Nov-17.
 * www.fennec.tech
 */
public abstract class GameObject {
    private int charge;
    private boolean deleteMark;
    public String name;

    public GameObject(String name) {
        deleteMark = false;
        this.name = name;
    }

    public void run() {
        System.out.println("Game object [" + name + "] start running");
    }

    public void turn() {
        System.out.println("Game object [" + name + "] start turning");
    }

    public void die() {
        System.out.println("Game object [" + name + "] is dieing");
    }

    public boolean isActiveAction() {
        if(charge > 0) return true;
        return false;
    }

    public void recharge(int charge) {
        this.charge = charge;
    }

    public void update() {
        System.out.println("===> Update["+name+"]: " + getInfo());
        charge--;
        if (charge < 0) charge = 0;
    }
    public abstract void handleEvent(Event event);

    public abstract String getInfo();

    public void markToDelete() {
        deleteMark = true;
    }

    public boolean shouldBeDeleted() {
        return deleteMark;
    }
}
