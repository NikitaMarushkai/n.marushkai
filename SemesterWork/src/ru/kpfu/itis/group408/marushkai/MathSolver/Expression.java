package ru.kpfu.itis.group408.marushkai.MathSolver;


public interface Expression {
    String calculateExp(String right, String left, String oper);

    default boolean isNumber(String s) {
        return false;
    }

    default int getAccessLevel(String s) {
        return 0;
    }

    default boolean isOperator(String s) {
        return false;
    }

    default boolean isOpenBraket(String s) {
        return false;
    }

    default boolean isClosedBraket(String s) {
        return false;
    }

    default boolean isInner(String s) {
        return false;
    }

    default boolean isLetter(String s) {
        return false;
    }

    default String getOPERATORS() {
        return null;
    }
}
