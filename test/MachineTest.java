import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MachineTest {

    private Machine machine;

    @BeforeEach
    void setUp() {
        this.machine = new Machine();
    }

    @Test
    void setBrokenTest(){
        this.machine.setBroken();
        assertTrue(this.machine.isBroken());
    }

    @Test
    void repairTest(){
        this.machine.setBroken();
        this.machine.repair();
        assertFalse(this.machine.isBroken());
    }
}