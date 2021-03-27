import java.lang.Math;
import java.util.Scanner;
/*
Version 1.0
by Ayun Daywhea
An example of the Fast Exponentiation algorithm from Discrete Math II 2.18.
This algorithm is working, but doesn't have any exception handling built-in yet.
*/

public class fastExpo {

    public static double fastPow(int b, int exponent)
    {
        //Declaring variables result is the final result of all this.
        double result = 1;
        //This starts the array at the end so the method works it way up.
        int j = 1;
        //Counters to make debugging the algorithm easier.
        int binExpo = 0;
        int expandedExpo = 0;
        //Converts the exponent to a binary array
        int binArray[] = decToBinary(exponent);

		//The exponent the integer will be raised to is the bit's value * (2 ^ the place of the bit)
		//The place for the bit starts from the end of the array and works backwards
		//Example: 1001 is 9 with the first 1 being in the 3rd place and the last one being in the 0's place.
        for(int i = 0; i < binArray.length; i++)
        {
            binExpo = (int)Math.pow(2,i);
            expandedExpo = binArray[binArray.length - j] * binExpo;
            result = result * Math.pow(b,expandedExpo);
            j++;
        }
        return result;
    }

    public static int[] decToBinary(int x) {
        //The whole point of this is to return the array of binary values.
        //loop through and use the conversion algorithm
        //Step 1 x mod 2
        //multiply that number by 10 to the i
        //use x div 2 to create the new x
        //continue until x is 0.

		/*Finds the max number of digits needed for the binary array
		Math.ceil returns a double but we have it typecast to an integer for the arrayLength variable.
		*/
        double logbx = Math.log(x) / Math.log(2);
        int arrayLength = (int) Math.ceil(logbx);

        //Creates a binary array with enough digits for x
        int binArray[] = new int[arrayLength];

        //i starts at 1 because the array is going to start at the end and move values foward.
        //j is going to be the container value for the modulo operation.
        int i = 1;
        int j = 0;

        //This follows the basic algorithm for base b exponentiation.
        //The value j is appended to the END of the array instead of the beginning.
        //J doesn't need to be multiplied by anything since binary just uses 0s and 1s anyway.
        //The new x is half of the old x and this continues until the loop reaches 0.
        while (x > 0) {
            j = x % 2;
            binArray[(arrayLength - i)] = j;
            x = x / 2;
            i++;
        }

        return binArray;
    }

    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);

        System.out.println("Type in a base integer, and an exponent to raise it to: ");
        int b = userInput.nextInt();
        int x = userInput.nextInt();
        System.out.println(fastPow(b,x));
    }
}