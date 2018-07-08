package Utils;

import java.util.Random;

public class PokerUtils implements IUtils{

    private Random rand;

    public PokerUtils(){
        initilize();
    }

    public void initilize(){
        rand = new Random();
    }

    @Override
    public int randomInt() {
        return rand.nextInt();
    }

    @Override
    public int randomInt(int limit) {
        return rand.nextInt(limit);
    }
}
