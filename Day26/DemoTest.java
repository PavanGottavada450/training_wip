package Day26;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(MyTestListener.class)
public class DemoTest {

    @Test
    public void testPass() {
        System.out.println("This test will pass");
    }

    @Test
    public void testFail() {
        System.out.println("This test will fail");
        assert false;
    }
}
