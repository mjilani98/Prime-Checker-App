package com.example.hw2q6;

public class IsPrime {

    private int number;

    public void setNumber(int n)
    {
        this.number = n;
    }

    public boolean getIsPrime()
    {
        if (number <= 1) {
            return false; // Numbers less than or equal to 1 are not prime
        }

        for (int x = 2; x * x <= number; x++) { // Check up to the square root of the number
            if (number % x == 0)
            {
                return false; // Found a divisor, not a prime
            }
        }
        return true; // If no divisors found, it's prime
    }
}
