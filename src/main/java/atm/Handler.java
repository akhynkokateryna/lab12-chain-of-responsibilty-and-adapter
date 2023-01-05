package atm;

import lombok.Getter;
import lombok.Setter;

@Setter@Getter
public abstract class Handler {
    public Handler next;
    public abstract void process(int price);
}
