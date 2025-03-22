import java.util.Scanner;

public class Main {

    //return true if the card number is valid
    public static boolean isValid(long numnber) {
        //add results from step four
        int sum = sumOfDoubleEvenPlace(numnber) + sumOfOddPlace(numnber);
        //is valid if divisible by 10
        return (sum % 10 == 0);
    }
    
    //get the result from step 2
    public static int sumOfDoubleEvenPlace(long number) {
        //initialize variable
        int sum = 0;
        //convert number to string for indexing
        String numberStr = Long.toString(number);

        //create loop that will start from second to last digit
        for (int i = numberStr.length() - 2; i >= 0; i -= 2) {
            //get the digit that was indexed and multiply by 2
            int digit = Character.getNumericValue(numberStr.charAt(i)) * 2;
            
            //add up all of the single digit numbers
            sum += getDigit(digit);
        }
        return sum; 

    }

    //return this number if it is a single digit or return the sum of two digits
    public static int getDigit(int number) {
        if (number < 10){
            return number;}
        else 
            {return (number / 10 + number % 10);
         }
    }

    //return sum of odd-place digits in number
    public static int sumOfOddPlace(long number) {
        //initialize variable
        int sum = 0;
        //convert to string for indexing
        String numberStr = Long.toString(number);

        //create loop to get digits
        for(int i = numberStr.length() - 1; i >= 0; i -= 2) {
            //add digits
            sum += Character.getNumericValue(numberStr.charAt(i));
        }
        return sum;
    }

    //return true if the number d is a prefix for number
    public static boolean prefixMatched(long number, int d) {
        //extract the first getSize(d) digits from number and check if they match d
        return getPrefix(number, getSize(d)) == d; 
    }

    //return the number of digits in d
    public static int getSize(long d) {
        //convert d to string and return length
        return Long.toString(d).length();
        }
    
    /**return the first k number of digits from number. 
     * if the number of digits in number is less than k,
     * return number
     */
    public static long getPrefix(long number, int k) {
        //convert to string for indexing
        String numberStr = Long.toString(number);
        //if k is longer than number's length return number
        if (numberStr.length() < k){
            return number;
        }
        //extract the first k digits and convert substring back to a number
        return Long.parseLong(numberStr.substring(0, k));
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        //get user input
        System.out.print("Enter credit card number: ");
        long number = input.nextLong();

        //print results
        if (isValid(number)) {
            System.out.println(number + " is a valid number.");
        }
        else {
            System.out.println(number + " is not a valid number.");
        }
        
        input.close();
        }
        
        
    }

