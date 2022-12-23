import org.testng.annotations.Test;
import static org.junit.Assert.assertTrue;

public class TestTea {
    @Test
    public void Test1() {
        Tea t = new Tea();
        assertTrue(t.getState() instanceof FillLeavesWithWater);
        t.nextState();
        assertTrue(t.getState() instanceof Prepared);
        t.nextState();
        assertTrue(t.getState() instanceof DrinkTea);
    }
    @Test
    public void Test2() {
        Tea t = new Tea();
        t.setState(new Prepared());
        t.prevState();
        assertTrue(t.getState() instanceof FillLeavesWithWater);
    }
}
