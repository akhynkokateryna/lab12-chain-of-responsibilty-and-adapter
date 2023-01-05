package atm;

public class Handler20 extends Handler {
    @Override
    public void process(int price) {
        Handler next = getNext();
        if (price % 20 > 0 && next == null) {
            System.out.println("ATM can't handle the whole sum that was entered");
            throw new IllegalArgumentException();
        }
        else {
            System.out.println(price / 20 + "* 20");
            if (next != null) {
                getNext().process(price % 20);
            }
        }
    }
}
