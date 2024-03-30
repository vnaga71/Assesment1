/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contest;

/**
 *
 * @author venka
 */
import java.util.Scanner;

public class WithoutUsingOperator {

    static int multiple15(int a) {
        int result = 0;
        for (int i = 0; i < 15; i++) {
            result += a;
        }
        return result;
    }

    static int multiple75(int b) {
        int result = 0;
        for (int i = 0; i < 7; i++) {
            result += b;
        }
        return result + (result / 2);
    }

    static int multiply15by16(int n) {
        int result = 0;
        for (int i = 0; i < 15; i++) {
            result += n;
        }
        return result / 16;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the Integer multiply with 15:");
        int a = s.nextInt();
        int result1 = multiple15(a);
        System.out.println("Multiplying " + a + " with 15 is :" + result1);

        System.out.println("Enter the Multiply even number of with 7.5:");
        int b = s.nextInt();
        int result2 = multiple75(b);
        System.out.println("Multiplying " + b + " with 7.5 is :" + result2);
        System.out.println("Enter the value of 'n' calculate of 15 * n/16:");
        int c = s.nextInt();

        int result3 = multiply15by16(c);
        System.out.println("Multiplying 15 *" + c + "/16 is :" + result3);
    }

}
