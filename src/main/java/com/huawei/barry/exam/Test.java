/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2019-2019. All rights reserved.
 */

package com.huawei.barry.exam;

/**
 * 功能描述
 *
 * @author w00205937
 * @since 2019-09-24
 */
class Base {
    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    private int num = 1;

    public Base() {
        print();
        num = 2;
    }

    public void print() {
        System.out.println("Base.num=" + num);

    }
}

class Sub extends Base {

    int num = 3;

    public Sub() {
        print();
        num = 4;
    }

    @Override
    public void print() {
        System.out.println("Sub.num=" + num);
    }
}

public class Test {
    public static void main(String[] args) {
        Base b = new Sub();
        System.out.println(b.getNum());
    }
}