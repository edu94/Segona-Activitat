import java.util.Observable;

public abstract class MachineComponent extends Observable {

    protected boolean broken = false;

    public void setBroken(){
        this.broken = true;
    }

    public void repair(){
        this.broken = false;
    }

    public abstract boolean isBroken();
}