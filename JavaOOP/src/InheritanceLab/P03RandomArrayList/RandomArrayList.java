package InheritanceLab.P03RandomArrayList;

import java.util.ArrayList;
import java.util.Random;

public class RandomArrayList<T> extends ArrayList<T> {

    private final Random random;

    public RandomArrayList(){
        super();
        this.random=new Random();
    }
    public T getRandomElement(){
        int index = random.nextInt(super.size());
        T result = super.get(index);
        super.remove(index);

        return result;
    }
}
