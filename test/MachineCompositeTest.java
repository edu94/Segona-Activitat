import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MachineCompositeTest {

    private MachineComposite composite;

    @BeforeEach
    void setUp() {
        this.composite = new MachineComposite();
    }

    @Test
    void addRepairMachineTest(){
        Machine machine = new Machine();
        machine.setBroken();
        this.composite.addComponent(machine);
        assertTrue(this.composite.isBroken());
        machine.repair();
        assertFalse(this.composite.isBroken());
    }

    @Test
    void addNewBrokenMachineTest(){
        Machine machine = new Machine();
        machine.setBroken();
        this.composite.addComponent(machine);
        assertTrue(this.composite.isBroken());
    }

}