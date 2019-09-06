package com.huawei.barry.exam;

import java.util.Scanner;

public class APlusB {

    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        String input=null;

        while (scanner.hasNextLine()) {
            try {
                input = scanner.nextLine();

                input=input.replaceAll(" {1,}",",");

                int a = Integer.parseInt(input.split(",")[0]);
                int b = Integer.parseInt(input.split(",")[1]);

                System.out.println( (a + b));

            } catch (Exception e) {

                System.out.println("invalid input ");
            }

        }
    }
}
