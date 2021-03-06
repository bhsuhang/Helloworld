
package com.huawei.barry.exam;

import java.math.BigDecimal;
import java.util.Scanner;

public class APlusB {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int qty = Integer.valueOf(scanner.nextLine());
        int i = 1;
        while (scanner.hasNextLine()) {
            if (i > qty) {
                break;
            }
            String line = scanner.nextLine();
            String[] numbers = line.split(" ");
            System.out.println("Case " + (i) + ":");
            System.out.print(numbers[0] + " + " + numbers[1] + " = ");
            System.out.println(processAPlusB(numbers[0], numbers[1]));
            if (i < qty) {
                System.out.println();
            }
            i++;
        }
    }

    private static BigDecimal processAPlusB(String a, String b) {
        return new BigDecimal(a).add(new BigDecimal(b));
    }
}
