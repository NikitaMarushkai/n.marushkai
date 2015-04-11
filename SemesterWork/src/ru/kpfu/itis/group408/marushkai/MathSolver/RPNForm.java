package ru.kpfu.itis.group408.marushkai.MathSolver;

import java.io.*;
import java.util.Iterator;
import java.util.Stack;
import java.util.StringTokenizer;


public class RPNForm {

    private String exp;
    private String rezult;
    private Stack<String> RPNForm;
    private Factory factor = new Factory();
    private Expression oper = factor.getExp("operators");
    private Expression calculator = factor.getExp("calculator");
    private static int thisLine = -1;


    public RPNForm(String exp) {
        if (exp.charAt(0) == '-') {
            exp = 0 + exp;
        }
        this.exp = exp;
        while (this.exp.contains("(-")) {
            this.exp = this.exp.replace("(-", "(0-");
        }
        rezult = "";
    }


    private void findRPNForm() throws Exception {
        StringTokenizer tokenizer = new StringTokenizer(exp, oper.getOPERATORS() + "()%",
                true);
        Stack<String> stackRPN = new Stack<>();
        Stack<String> stackOper = new Stack<>();
        stackOper.clear();
        stackRPN.clear();
        while (tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken();
            if (token.contains("{") || token.contains("}") || token.contains("[") || token.contains("]")) {
                throw new Exception("Неправильный формат скобок");
            }
            if (oper.isLetter(token)) {
                throw new Exception("Ввод не должен содержать букв");
            }
            if (oper.isNumber(token) || oper.isInner(token)) {
                stackRPN.add(token);
            }
            if (oper.isOperator(token)) {
                while ((!stackOper.isEmpty())
                        && (oper.isOperator(stackOper.peek()))
                        && (oper.getAccessLevel(token) <= oper.getAccessLevel(stackOper
                        .peek()))) {
                    stackRPN.add(stackOper.pop());
                }
                stackOper.add(token);

            }
            if (oper.isOpenBraket(token)) {
                stackOper.add(token);
            }
            if (oper.isClosedBraket(token)) {
                while ((!stackOper.peek().equals("("))) {
                    stackRPN.add(stackOper.pop());
                }
                stackOper.pop();
            }
        }
        while (!stackOper.isEmpty()) {
            stackRPN.add(stackOper.pop());
        }
        System.out.println("Результат: ");
        print(stackRPN);
        RPNForm = new Stack<>();
        while (!stackRPN.isEmpty()) {
            RPNForm.add(stackRPN.pop());
        }
    }


    private void solveRPN() {
        Stack<String> stackOper = new Stack<>();
        Stack<String> stackNum = new Stack<>();
        int count = 0;
        thisLine++;

        System.out.println("");
        System.out.println(RPNForm);
        while (!RPNForm.isEmpty()) {
            String token = RPNForm.pop();
            if (oper.isOperator(token)) {
                stackOper.add(token);
            }
            if (oper.isNumber(token)) {
                count++;
                stackNum.add(token);
            }
            if (oper.isInner(token)) {
                try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("inner.txt")))) {
                    int i = 0;
                    String line = "";
                    while (i < this.thisLine) {
                        line = reader.readLine();
                        i++;
                    }
                    stackNum.add(line);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if ((count == 2) && !stackOper.isEmpty()) {
                count = 0;
                String rezult = calculator.calculateExp(stackNum.pop(), stackNum.pop(),
                        stackOper.pop());
                stackNum.add(rezult);
            }
            while ((stackNum.size() >= 2) && (!stackOper.isEmpty())) {
                String rezult = calculator.calculateExp(stackNum.pop(), stackNum.pop(),
                        stackOper.pop());
                stackNum.add(rezult);

            }
        }
        System.out.println(stackNum);
        rezult = stackNum.pop();
        try (PrintWriter writer = new PrintWriter(new FileWriter("inner.txt", true))) {
            writer.write(rezult);
            writer.println();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getSolve() throws Exception {
        try {
            findRPNForm();
        } catch (Exception e) {
            throw e;
        }
        solveRPN();
        return rezult;
    }

    private void print(Stack<?> stack) {
        Iterator<?> it = stack.iterator();
        while (it.hasNext()) {
            System.out.print(it.next());
        }
    }
}
