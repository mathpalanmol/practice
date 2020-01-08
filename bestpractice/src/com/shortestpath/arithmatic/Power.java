package com.shortestpath.arithmatic;

public class Power {

    static float power(float x, int y) {
        float temp;
        if (y == 0)
            return 1;
        temp = power(x, y / 2);
        if (y % 2 == 0)
            return temp * temp;
        else {
            if (y > 0) {
                System.out.println("temp: " + temp + " x: " + x);
                return x * temp * temp;
            } else {

                System.out.println("temp: " + temp + " x: " + x);

                return (temp * temp) / x;
            }
        }
    }

    public static void main(String[] args) {
        // float result = power(2,3); // 2^3
        float result = power(2, -4); // 2^-4 or 1/2^4
        System.out.println("result: " + result);
    }

}
