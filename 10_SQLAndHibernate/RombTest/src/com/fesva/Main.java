package com.fesva;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    static BufferedReader reader;
    //public static final int sz = 7;

    public static void main(String[] args) throws IOException {
        // Ваш код получающий параметры с консоли
        //---
        int height, width;
        System.out.println("Input height, please:");
        Scanner sc = new Scanner((System.in));
        height = sc.nextInt();

        System.out.println("Input width, please:");
        width = sc.nextInt(); // width=2leg+1

        Main.printDiamond(height, width);
    }

    private static void printDiamond(int height, int width) {
        //---
        //Код печатающий ромб через тг
        for (int row = 0; row < height; row++) {
            System.out.printf("row=%d ", row);
            int leg = (width-1)/2;
            System.out.printf("leg=%d ", leg);
            int back=leg;
            System.out.printf("back=%d ", back);

            back++;
        }
    }

    private static void Crestiki(int sz) {
        char[][] s = new char[sz][sz];
        for (int i = 0; i < sz; i++) {
            for (int j = 0; j < sz; j++) {
                s[i][j] = ' ';
            }

        }
        for (int i = 0, j = sz - 1; i < sz; i++, j--) {
            s[i][i] = 'x';
            s[i][j] = 'x';
        }
        for (int i = 0; i < sz; i++) {
            for (int j = 0; j < sz; j++) {
                System.out.print(s[j][i]);
            }
            System.out.println();
        }
    }
}
