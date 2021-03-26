import java.lang.Math;
import java.util.Scanner;

public class baseExpansion {

    //Method to convert the number to the base.
    public static int decToBase(int x, int base) {

        int num = 0;
        int total = 0;

        //Stores result of the division operation.
        int div = 0;
        //Stores result of the modulo operation.
        int r = 0;
        //Necessary to increment the exponent, for each place value.
        int i = 0;


		/*The algorithm goes through the following steps
		1. Get the modulo of x and the base.
		2. Multiply the modulo result with 10^i with i starting at 0 to control it's place value and add it to a total counter.
		3. The new x is x div base
		4. Continue until x is 0.
		*/
		
        while (x > 0) {
            num = x % base;
            total += num * (Math.pow(10, i));
            x = x / base;
            i++;
        }
        return total;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
		
		System.out.println("Type in a number to convert, and the base b to convert it to: ");
		
        int x = scan.nextInt();
        int b = scan.nextInt();

        System.out.println(x + " expressed in base " + b + " is: " + decToBase(x, b));
    }
}

