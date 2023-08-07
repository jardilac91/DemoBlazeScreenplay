package demoblaze.utils;

public class ConvertAmountToInt {

    public static int convertAmountToInt(String amount){
        return Integer.parseInt(
                amount.replace("$","").
                        replace("*includes tax", "").
                        replace(" ", ""));
    }
}
