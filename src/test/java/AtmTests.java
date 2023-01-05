import atm.Handler;
import atm.Handler20;
import atm.Handler5;
import atm.Handler50;
import org.junit.jupiter.api.Test;

public class AtmTests {
    @Test
    public void test1(){
        Handler handler5 = new Handler5();
        Handler handler20 = new Handler20();
        Handler handler50 = new Handler50();

        handler50.setNext(handler20);
        handler20.setNext(handler5);

        handler50.process(125);
    }
}
