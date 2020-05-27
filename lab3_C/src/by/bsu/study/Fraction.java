package by.bsu.study;

import org.jetbrains.annotations.NotNull;

public class Fraction {
    private int numerator;
    private int denominator;

    Fraction(){
        numerator = 1;
        denominator = 1;
    }
    Fraction(int num, int denom){
        numerator = num;
        denominator = denom;
        if (denom < 0) {
            denominator *= -1;
            numerator *= -1;
        }
        reduce();
    }

    public int getNumerator(){
        return numerator;
    }
    public int getDenominator(){
        return denominator;
    }
    public void setDenominator(int denom) {
        denominator = denom;
        if (denom < 0){
            denominator *= -1;
            numerator *= -1;
        }
        reduce();
    }
    public void setNumerator(int num) {
        numerator = num;
        reduce();
    }

    public void reduce(){
        for (int i = min(numerator, denominator); i > 0; i--) {
            if(numerator % i == 0 && denominator % i == 0){
                numerator /= i;
                denominator /= i;
                i = min(numerator, denominator);
            }
        }
    }
    public Fraction multiplyBy(@NotNull Fraction fract){
        return new Fraction(numerator*fract.numerator, denominator*fract.denominator);
    }
    public Fraction divideBy(@NotNull Fraction fract){
        return new Fraction(numerator*fract.denominator, denominator*fract.numerator);
    }
    public Fraction plus(@NotNull Fraction fract){
        return new Fraction(numerator*fract.denominator + fract.numerator*denominator
                , denominator*fract.denominator);
    }
    public Fraction minus(@NotNull Fraction fract){
        return new Fraction(numerator*fract.denominator - fract.numerator*denominator
                , denominator*fract.denominator);
    }
    public boolean isGreater(@NotNull Fraction fract){
        return (numerator*fract.denominator > fract.numerator*denominator);
    }
    public boolean isLess(@NotNull Fraction fract){
        return (numerator*fract.denominator > fract.numerator*denominator);
    }
    public boolean isEquals(@NotNull Fraction fract) {
        if (numerator != 0) {
            return (numerator == fract.numerator && denominator == fract.denominator);
        }
        return numerator == fract.numerator;
    }

    public static int min(int x, int y){
        if(x < 0){
            x *= -1;
        }
        if(y < 0){
            y *= -1;
        }
        return (x < y) ? x : y;
    }
}
