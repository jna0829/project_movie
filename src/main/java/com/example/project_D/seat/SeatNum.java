package com.example.project_D.seat;

public class SeatNum {

    public static void main(String[] args) {
        for (char a='A'; a<='D'; a++) {
            for (int b=1; b<=20 ; b++) {
                System.out.printf("('%c%d', '%c-%d', 'S5'),%n", a, b, a, b);
            }
        }
    }

}