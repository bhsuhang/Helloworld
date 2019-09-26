package com.huawei.barry.file;

import java.io.FileReader;
import java.io.IOException;

public class Demo1FileReader {


    public static void main(String[] args) {

        try {
            FileReader fileReader = new FileReader("d:\\readme.txt");
            int i=0;
            while( (i= fileReader.read())!=-1){

                System.out.println(i+":"+(char)i+ ", Hex:"+ Integer.toHexString(i));
            };




        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
