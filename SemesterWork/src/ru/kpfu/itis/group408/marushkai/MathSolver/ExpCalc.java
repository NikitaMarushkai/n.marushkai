package ru.kpfu.itis.group408.marushkai.MathSolver;

public class ExpCalc implements Expression {

    public String calculateExp(String rightNum, String leftNum, String oper) throws ArithmeticException {
        double a = Double.valueOf(leftNum);
        double b = Double.valueOf(rightNum);

        if ((b == 0) && (oper.equals("/"))) {
            throw new ArithmeticException("Деление на нуль невозможно");
        }

        switch (oper.charAt(0)) {
            case '*':
                return String.valueOf(a * b);
            case '/':
                return String.valueOf((a / b));
            case '+':
                return String.valueOf(a + b);
            case '-':
                return String.valueOf(a - b);
            case '^':
                return String.valueOf(Math.pow(a, b));
        }
        return "";
    }
}
