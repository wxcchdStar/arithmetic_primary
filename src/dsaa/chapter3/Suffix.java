package dsaa.chapter3;

import java.util.Stack;

/**
 * Created by ChenHd on 2015/5/18.
 */
public class Suffix {

    public static void main(String[] args) {
//        String suffixStr = "6 5 2 3 + 8 * + 3 + *";
//        System.out.println(compute(suffixStr));

//        String expression = "12 + 7 * 5 - 9 * ( 2 - 6 )";
//        System.out.println(compute(infixToSuffix(expression)));

        infixToSuffix("A + B * ( C - D ) / E + F / H");
    }

    public enum Options {
        PLUS(0, "+"),
        SUB(0, "-"),
        MUL(1, "*"),
        DIV(1, "/"),
        LBRA(2, "("),
        RBRA(2, ")");

        public int priority;
        public String value;

        Options(int priority, String value) {
            this.priority = priority;
            this.value = value;
        }

        @Override
        public String toString() {
            return value;
        }

    }

    public static Options getOptions(String value) {
        if ("+".equals(value)) {
            return Options.PLUS;
        } else if ("-".equals(value)) {
            return Options.SUB;
        } else if ("*".equals(value)) {
            return Options.MUL;
        } else if ("/".equals(value)) {
            return Options.DIV;
        } else if ("(".equals(value)) {
            return Options.LBRA;
        } else {
            return Options.RBRA;
        }
    }

    public static String infixToSuffix(String expression) {
        Stack<Options> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        String[] items = expression.split(" ");
        for (String item : items) {
            if ("+".equals(item) || "-".equals(item)) {
                if (!stack.isEmpty()) {
                    if (stack.peek().priority >= Options.PLUS.priority) {
                        while (!stack.isEmpty()) {
                            if ("(".equals(stack.peek().value)) break;
                            sb.append(stack.pop().value);
                            sb.append(" ");
                        }
                    }
                }
                stack.push(getOptions(item));
            } else if ("*".equals(item) || "/".equals(item)) {
                if (!stack.isEmpty()) {
                    if (stack.peek().priority >= Options.MUL.priority) {
                        while (!stack.isEmpty()) {
                            if ("(".equals(stack.peek().value)) break;
                            sb.append(stack.pop().value);
                            sb.append(" ");
                        }
                    }
                }
                stack.push(getOptions(item));
            } else if ("(".equals(item)) {
                stack.push(Options.LBRA);
            } else if (")".equals(item)) {
                while (!stack.isEmpty()) {
                    Options removed = stack.pop();
                    if (!"(".equals(removed.value)) {
                        sb.append(removed.value);
                        sb.append(" ");
                    }
                }
            } else {
                sb.append(item);
                sb.append(" ");
            }
        }

        while (!stack.isEmpty()) {
            sb.append(stack.pop().value);
            sb.append(" ");
        }
        System.out.println(sb.toString());

        return sb.toString();
    }

    public static int compute(String suffixStr) {
        String[] items = suffixStr.split(" ");
        Stack<Integer> stack = new Stack<>();
        for (String item : items) {
            try {
                int i = Integer.parseInt(item);
                stack.push(i);
            } catch (Exception e) {
                int n1 = stack.pop();
                int n2 = stack.pop();
                if ("+".equals(item)) {
                    stack.push(n2 + n1);
                } else if ("-".equals(item)) {
                    stack.push(n2 - n1);
                } else if ("*".equals(item)) {
                    stack.push(n2 * n1);
                } else if ("/".equals(item)) {
                    stack.push(n2 / n1);
                }
            }
        }
        return stack.pop();
    }
}
