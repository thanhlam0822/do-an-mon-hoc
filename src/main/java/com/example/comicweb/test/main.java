package com.example.comicweb.test;

import java.util.Scanner;

public class main {
    void kangaroo(int x1,int v1,int x2, int v2) {
        int    kang1 = x1+v1;
        int    kang2 = x2 +v2;
       for(int i =0 ; i <= 10000; i++) {
            if(kang1 < kang2) {
                kang1+=v1;
                if(kang1 >= kang2) {
                    System.out.println("YES");
                    break;
                }
                else {
                    kang2+=v2;
                }
                if (kang1 < kang2) {
                    System.out.println("NO");
                    break;
                }
            }



       }

    }
    public static void main(String[] args) {
        main main = new main();
        Scanner scanner = new Scanner(System.in);
        int x1 = scanner.nextInt();
        int v1 = scanner.nextInt();
        int x2 = scanner.nextInt();
        int v2 = scanner.nextInt();

        main.kangaroo(x1,v1,x2,v2);
    }

    }

