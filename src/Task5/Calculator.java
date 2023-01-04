package Task5;

import com.sun.source.tree.SwitchTree;

import java.util.Scanner;

public class Calculator extends Exception {
    double x;
    double y;

    public Calculator() {};

    public Calculator(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    double Add(double x, double y){
      return x + y;
    }

    double Sub(double x, double y){
        return x - y;
    }

    double Mul(double x, double y){
        return x * y;
    }

    double Div(double x, double y) throws Exception {
        if(y == 0) throw new Exception("Не можна ділити на нуль.");
        return  x / y;
    }

    public static <string> void main(String[] args) throws Exception{
        Calculator calc = new Calculator();
        Scanner input = new Scanner(System.in);
        double firstNumber = 0;
        double secondNumber = 0;
        String operator = "";

        try {
            System.out.print("Введіть перше число: ");
            firstNumber = input.nextDouble();

            System.out.print("Введіть друге число: ");
            secondNumber = input.nextDouble();
        } catch (Exception ex) {
            System.out.println("Ви ввели не числове значення");
        }
            input = new Scanner(System.in);

        try {
            System.out.print("Введіть операцію ('/', '*', '+' або '-'): ");
            operator = input.nextLine();
            if(!operator.equals("/") && !operator.equals("*") && !operator.equals("+") && !operator.equals("-"))
                throw new Exception("Ви ввели некоректну операцію");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        switch (operator){
            case "/":
                try {
                    System.out.println(calc.Div(firstNumber,secondNumber));
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
                break;
            case "*":
                System.out.println(calc.Mul(firstNumber,secondNumber));
                break;
            case "-":
                System.out.println(calc.Sub(firstNumber,secondNumber));
                break;
            case "+":
                System.out.println(calc.Add(firstNumber,secondNumber));
                break;
            default:
                break;
        }
    }
}

