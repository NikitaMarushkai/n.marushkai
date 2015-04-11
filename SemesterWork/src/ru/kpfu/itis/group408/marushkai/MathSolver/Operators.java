package ru.kpfu.itis.group408.marushkai.MathSolver;

public class Operators implements Expression {

    private final String OPERATORS = "+/*-^";

    @Override
    public String calculateExp(String right, String left, String oper) {
        return null;
    }

    public boolean isNumber(String s) {
        try {
            Double.parseDouble(s);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public int getAccessLevel(String c) {
        if (c.equals("^")) {
            return 3;
        }
        if (c.equals("*") || c.equals("/")) {
            return 2;
        }
        if (c.equals("+") || c.equals("-")) {
            return 1;
        }
        return 1;
    }

    public boolean isLetter(String c) {
        if (!isClosedBraket(c) && !isNumber(c) && !isOpenBraket(c) && !isOperator(c) && !isInner(c))
            return true;
        else return false;
    }

    public boolean isOperator(String c) {
        return OPERATORS.contains(c);
    }

    public boolean isOpenBraket(String c) {
        return c.equals("(");
    }

    public boolean isClosedBraket(String c) {
        return c.equals(")");
    }

    public boolean isInner(String c) {
        return c.equals("%");
    }

    public String getOPERATORS() {
        return OPERATORS;
    }
}
