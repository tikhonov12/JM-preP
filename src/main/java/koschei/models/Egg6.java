package koschei.models;

import org.springframework.beans.factory.annotation.Autowired;

public class Egg6 {

    private Needle7 needle7;
    @Autowired
    public Egg6(Needle7 needle7) {
        this.needle7=needle7;
    }

    @Override
    public String toString() {
        return ", в яйце иголка " + needle7.toString();
    }
}
