package com.huawei.barry.file;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class DemoImage {

    public static void main(String[] args) {
        try {
            FileInputStream in=new FileInputStream("C:\\Users\\w00205937\\Pictures\\宝马i8.jpg");
            int data=0;
            while((data=in.read())!=-1){

                System.out.println(data+"," +Integer.toBinaryString(data));

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
