package demoblaze.utils;

import java.util.Random;

public class SelectRandomProduct {

    private static Random random = new Random();

    public static Integer selectRandomProduct(int products){
        return random.nextInt(products-1)+1;
    }
}