package practice.leetcode.algorithm;

import java.util.Stack;

/**
 * 682. Baseball Game
 */
public class BaseballGame {
    /**
     * Cal points int.
     *
     * @param ops the ops
     * @return the int
     */
    public int calPoints(String[] ops) {
        Stack<Integer> stack = new Stack<>();
        int result = 0;
        int temp = 0;
        for (int i = 0; i < ops.length; i++) {
            switch (ops[i]) {
                case "D":
                    temp = stack.peek() * 2;
                    result += temp;
                    stack.push(temp);
                    break;
                case "C":
                    temp = stack.peek();
                    result -= temp;
                    stack.pop();
                    break;
                case "+":
                    temp = stack.elementAt(stack.size() - 1) + stack.elementAt(stack.size() - 2);
                    result += temp;
                    stack.push(temp);
                    break;
                default:
                    temp = Integer.valueOf(ops[i]);
                    result += temp;
                    stack.push(temp);
            }
        }

        return result;
    }
}
