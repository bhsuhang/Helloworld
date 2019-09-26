
package com.huawei.barry.exam;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;
import java.util.Scanner;

//求孪生素数
public class PrimeNumber {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        List<Integer> todos = new ArrayList<>();

        BitSet bitSet = new BitSet();

        while (scanner.hasNextInt()) {
            // todos.add(scanner.nextInt());
            System.out.println(findTwinPrimeNumber(scanner.nextInt()));
        }

//        todos.forEach(x -> {
//            System.out.println(findTwinPrimeNumber(x));
//        });


    }

    private static int findTwinPrimeNumber(int scope) {

        int count = 0;
        List<Integer> primes = getPrimeNumber3(scope);

        primes.forEach(x -> System.out.print(x + " "));

        List<Integer> twinlist = new ArrayList();

        for (int i = 1; i < primes.size(); i++) {
            if (primes.get(i - 1).equals(primes.get(i) - 2)) {
                twinlist.add(primes.get(i - 1));
                twinlist.add(primes.get(i));
            }
        }

        //System.out.println();
        //twinlist.forEach(x -> System.out.print(x+" "));

        return twinlist.size() / 2;
    }

    @NotNull
    private static List<Integer> getPrimeNumber(int firstScope) {
        List<Integer> primes = new ArrayList<>();

        //2是第一个素数
        primes.add(2);

        //先找到素数
        for (int i = 3; i <= firstScope; i++) {
            boolean isPrimeNumber = true;
            for (int j = 2; j < i; j++) {
                //除了1和自身，找到能被整除的就不是素数
                if (i % j == 0) {
                    isPrimeNumber = false;
                    break;
                }
            }

            if (isPrimeNumber) {
                primes.add(i);

            }
        }
        return primes;
    }

    //采用筛选法
    private static List<Integer> getPrimeNumber2(int scope) {
        List<Integer> primes = new ArrayList<>();
        boolean[] flag = new boolean[scope + 1];

        //初始化，假定都是素数
        for (int i = 0; i < flag.length; i++) {
            flag[i] = true;
        }
        //明确的0,1,2 处理掉
        flag[0] = false;
        flag[1] = false;
        flag[2] = true;

        for (int i = 2; i < scope; i++) {
            for (int j = 3; j < flag.length; j++) {

                if (flag[j] && !(i == j) && j % i == 0) {
                    flag[j] = false; //如果能被i整除，就划掉
                }
            }

        }

        for (int i = 0; i < flag.length; i++) {
            if (flag[i]) {
                primes.add(i);
            }
        }

        return primes;
    }

    //采用筛选法，先找到素数
    private static List<Integer> getPrimeNumber3(int scope) {
        List<Integer> primes = new ArrayList<>();
        boolean[] flag = new boolean[scope + 1];

        //初始化，假定都是素数
        for (int i = 0; i < flag.length; i++) {
            flag[i] = true;
        }
        //明确的0,1 处理掉
        flag[0] = false;
        flag[1] = false;

        for (int i = 2; i <= new Double(Math.sqrt(scope)).intValue(); i++) {
            //只要是前面找到数字的倍数，都不是素数
            for (int j = i * 2; j <= scope; j += i) {
                if (flag[i]) {
                    flag[j] = false;
                }
            }
        }

        //把找到的素数放入列表中返回。
        for (int i = 0; i < flag.length; i++) {
            if (flag[i]) {
                primes.add(i);
            }
        }
        return primes;
    }




}
