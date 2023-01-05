package atm;

public class Handler50 extends Handler {
    @Override
    public void process(int price) {
        Handler next = getNext();
        if (price % 50 > 0 && next == null) {
            System.out.println("ATM can't handle the whole sum that was entered");
            throw new IllegalArgumentException();
        }
        else {
            System.out.println(price / 50 + "* 50");
            if (next != null) {
                getNext().process(price % 50);
            }
        }
    }
}
