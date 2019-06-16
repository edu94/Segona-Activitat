import java.util.Observable;

public abstract class MachineComponent extends Observable {

    protected boolean broken = false;


    public void setBroken() {
        boolean wasBroken = broken;
        broken = true;
        if(!wasBroken){
            notifyChanges();
        }
    }

    public void repair() {
        boolean wasBroken = broken;
        broken = true;
        if(wasBroken){
            notifyChanges();
        }
    }

    private void notifyChanges() {
        setChanged();
        notifyObservers();
    }

    public abstract boolean isBroken();
}
