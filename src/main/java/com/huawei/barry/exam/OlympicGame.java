/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2019-2019. All rights reserved.
 */

package com.huawei.barry.exam;

import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * 功能描述
 *
 * @author w00205937
 * @since 2019-09-24
 */
public class OlympicGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int qty = scanner.nextInt(); // 国家数量
        SortedSet<Country> set = new TreeSet();
        int i = 0;
        while (true) {
            if (i == qty) {
                break;
            }
            String name = scanner.next();
            int gold = scanner.nextInt();
            int silver = scanner.nextInt();
            int bronze = scanner.nextInt();
            Country country = new Country(name, gold, silver, bronze);
            set.add(country);
            i++;
        }
        for (Country country : set) {
            System.out.println(country.getName());
        }
    }
}

class Country implements Comparable {
    String name;

    int gold;

    int silver;

    int bronze;

    public Country(String name, int gold, int silver, int bronze) {
        this.name = name;
        this.gold = gold;
        this.silver = silver;
        this.bronze = bronze;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public int getSilver() {
        return silver;
    }

    public void setSilver(int silver) {
        this.silver = silver;
    }

    public int getBronze() {
        return bronze;
    }

    public void setBronze(int bronze) {
        this.bronze = bronze;
    }

    @Override
    public int compareTo(Object o) {
        Country target = (Country) o;
        if (compareField(target, "gold") != 0) {
            return compareField(target, "gold");
        } else if (compareField(target, "silver") != 0) {
            return compareField(target, "silver");
        } else if (compareField(target, "bronze") != 0) {
            return compareField(target, "bronze");
        } else {
            return compareName(target);
        }
    }

    private int compareName(Country target) {
        char[] targetChars = target.getName().toCharArray();
        char[] srcChars = getName().toCharArray();
        for (int i = 0; i < targetChars.length; i++) {
            // 相同的情况下，如果目标更长，则被比较对象更大
            if (i + 1 > srcChars.length) {
                return -1;
            }
            if (targetChars[i] > srcChars[i]) {
                return -1;
            }
            if (targetChars[i] < srcChars[i]) {
                return 1;
            }
        }
        return 0;
    }

    private int compareField(Country target, String field) {
        try {
            Class clazz = target.getClass();
            int targetValue = clazz.getDeclaredField(field).getInt(target); // 目标比较对象
            int thisValue = clazz.getDeclaredField(field).getInt(this); // 自身
            if (targetValue > thisValue) {
                return 1;
            } else if (targetValue < thisValue) {
                return -1;
            } else {
                return 0;
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        return -1;
    }
}
