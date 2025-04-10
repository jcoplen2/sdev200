import java.io.*;
import java.util.*;

public class Grouping {
    //check to ensure user entered filename
    public static void main(String[] args) {
        if(args.length != 1) {
            System.out.println("Grouping <filename>");
            return;
        }

        //initialize variables
        String fileName = args[0];
        Stack<Character> stack = new Stack<>();

        //open file
        try(BufferedReader reader = new BufferedReader(new FileReader(fileName))){
            //read one character at a time
            int ch;
            while ((ch = reader.read()) != -1) {
                char c = (char) ch;
                //add to opening to stack
                if (c == '(' || c == '{' || c == '['){
                    stack.push(c);
                }//handle premature/unmatched closings
                else if (c == ')' || c == '}' || c == ']'){
                    if (stack.isEmpty()) {
                        System.out.println("Closing without opening " + c);
                        return;
                    }
                    char top = stack.pop();
                    if (!isMatchingPair(top, c)) {
                        System.out.println("Mismatched " + top + "and " + c);
                        return;
                    }
                }
            }
            //once file is read
            if (!stack.isEmpty()) {
                System.out.println("Unmatched opening symbols remaining");
            } else {
                System.out.println("Correct grouping pairs");
            }
        } //catch exceptions
        catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
        //logic for matching pairs
        private static boolean isMatchingPair(char open, char close) {
            return (open == '(' && close == ')') ||
                   (open == '{' && close == '}') ||
                   (open == '[' && close == ']');
        }
        }



