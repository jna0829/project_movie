package com.example.project_D.seat;

public class SeatNum {

    public static void main(String[] args) {
        for (char a='A'; a<='L'; a++) {
            for (int b=1; b<=20 ; b++) {
                System.out.printf("('1-1-S1-%c%d', '%c%d', '1-1-S1'),%n", a, b, a, b);
            }
        }
    }

}