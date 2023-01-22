import java.util.Scanner;
public class Keyboard {

    //make a method that take in the promt message for Scanner and an error message for the try catch block
    public static double CheckMethod(String promtMes, String errorMes) {
        //make an int varaible, string and boolean
        Scanner in = new Scanner(System.in);
        double num = 0;
        String strInt;
        boolean valid = false;
        //start the while loop
        while(valid == false) {
            //make the string be the input for the scanner
            System.out.print(promtMes);
            strInt = in.nextLine();
            //if the string can be converted to an int the end the while loop
            try {
                num = Double.parseDouble(strInt);
                    valid = true;
                //if not print out error message
            } catch (Exception e) {
                System.out.println(errorMes);
            }
        }
        //then print out the num value
        return num;
    }
}
