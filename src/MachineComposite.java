import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;


public class MachineComposite extends MachineComponent implements Observer {

    private List<MachineComponent> components = new ArrayList<>();
    private int brokenComponents = 0;

    public void addComponent(MachineComponent mc) {
        components.add(mc);
        mc.addObserver(this);
        if (mc.isBroken()) {
            brokenComponents += 1;
            if (!broken && brokenComponents == 1) {
                notifyChanges();
            }
        }
    }
    public boolean isBroken () {
        return broken || brokenComponents > 0;
    }

    public void setBroken () {
        boolean wasBroken = isBroken();
        broken = true;
        if (!wasBroken) {
            notifyChanges();
        }
    }
    public void repair () {
        boolean wasBroken = isBroken();
        broken = false;
        if (!wasBroken) {
            notifyChanges();
        }
    }
    public void update (Observable obs, Object arg){
        MachineComponent mc = (MachineComponent) obs;
        if (mc.isBroken()) {
            brokenComponent();
        } else {
            repairedComponent(mc);
        }
    }
    private void brokenComponent () {
        boolean wasBroken = isBroken();
        brokenComponents += 1;
        if (!wasBroken) {
            notifyChanges();
        }
    }
    private void repairedComponent (MachineComponent mc){
        brokenComponents -= 1;
        if (!isBroken()) {
            notifyChanges();
        }
    }

    private void notifyChanges () {
        setChanged();
        notifyObservers();
    }
}
