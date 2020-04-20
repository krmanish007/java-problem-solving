package datastructure.linear;

import java.util.HashMap;
import java.util.Map;

public class Parenthesis {
    private static Map<Character, Character> parenthesisBraces = new HashMap<>();

    public Parenthesis() {
        parenthesisBraces.put(')', '(');
        parenthesisBraces.put('}', '{');
        parenthesisBraces.put(']', '[');
    }

    public boolean isMatch(String input) {
        Stack<Character> stack = new Stack<>();
        for (Character character : input.toCharArray()) {
            if (parenthesisBraces.containsValue(character)) {
                stack.push(character);
            } else if (parenthesisBraces.containsKey(character)) {
                Character lastElement = stack.pop();
                if (lastElement != parenthesisBraces.get(character)) {
                    return false;
                }
            }
        }
        return stack.peek() == null;
    }

    public static void main(String[] args) {
        Parenthesis parenthesis = new Parenthesis();
        boolean match = parenthesis.isMatch("(Hello) [{abs} ] asas");
        System.out.println("match = " + match);

        match = parenthesis.isMatch("(Hello [{abs} ] asas");
        System.out.println("match = " + match);

        match = parenthesis.isMatch("Hello) [{abs} ] asas");
        System.out.println("match = " + match);

        match = parenthesis.isMatch("(Hello) [} [{abs} ] asas");
        System.out.println("match = " + match);

    }
}
