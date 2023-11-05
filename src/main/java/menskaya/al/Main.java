package menskaya.al;

public class Main {
    public static void main(String[] args) {
        arithmeticOperators();
        logicalOperators();
        overFlow();
    }
    public static void arithmeticOperators() {
        int a = 126;
        int b = 75;
        double c = 1.75;
        System.out.println("AdditionInt, " + (a + b));
        System.out.println("AdditionDouble, " + (a + c));
        System.out.println("Subtraction, " + (a - b));
        System.out.println("Multiplication, " + (a * b));
        //* +
        System.out.println("Division, " + (a / b));
        System.out.println("Modulus Int, " + (b % a));
        System.out.println("Modulus Double, " +(a % c));
        System.out.println("Increase, " + (a++));
        System.out.println("Decrease, " + (b--));
    }
    public static void logicalOperators() {
        int d = 10;
        int e = 20;
        System.out.println("Equal to, " + (d == e));
        System.out.println("Not equal to, " + (d != e));
        System.out.println("Greater than, " + (d > e));
        System.out.println("Less than, " + (d < e));
        System.out.println("Greater than or equal to, " + (d >= e));
        System.out.println("Less than or equal to, " + (d <= e));

        boolean f = true;
        boolean g = false;
        System.out.println("Logical AND, " + (f&&g));
        System.out.println("Logical OR, " + (f||g) );
        System.out.println("Logical NOT, " + !(f && g));

        int x = 10;
        System.out.println("Logical AND+OR " + (x > 1 && x < 5 || x == 10));
        System.out.println("Logical AND+OR " + ((x == 10 || x > 1) && x < 5));
    };
    public static void overFlow() {
        byte e = Byte.MIN_VALUE;
        byte resultByte = (byte) (e - 1);
        //System.out.println("Multiplication, " + resultByte);
        System.out.println("Overflow: (" + e + " - 1) = "+resultByte);
        int j = 5;
        int k = Integer.MAX_VALUE;
        byte resultByteInt = (byte) (j + k);
        System.out.println("Multiplication_1, " + resultByteInt);
        }
}