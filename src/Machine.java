public class Machine extends MachineComponent {

    private boolean broken = false;

    public void setBroken() {
        boolean wasBroken = broken;
        broken = true;
        if (!wasBroken) {
            notifyChanges();
        }
    }

    public void repair() {
        boolean wasBroken = broken;
        broken = false;
        if (wasBroken) {
            notifyChanges();
        }
    }

    public boolean isBroken() {
        return broken;
    }

    private void notifyChanges() {
        setChanged();
        notifyObservers();
    }
}