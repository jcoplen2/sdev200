import java.util.Scanner;

public class Main {

    int decNum;
    String binStr;

    //constructor
    public Main(String binStr){
        this.binStr = binStr;
    }

    //method for converting to int and catching exception
    public void bin2Dec() throws BinaryFormatException {
        try{
            decNum = Integer.parseInt(binStr, 2);
        }catch(NumberFormatException e){
            throw new BinaryFormatException("Not a binary number");
        }
    }

    public static void main(String[] args){

        //get user input
        Scanner input = new Scanner(System.in);

        System.out.println("Please enter a binary number: ");
        String binStr = input.nextLine();

        try{
        //create object
        Main obj = new Main(binStr);
        obj.bin2Dec();
        
        //print output
        System.out.println("The decimal value is: " + obj.decNum);
        } catch(BinaryFormatException e) {
            System.out.println("Not a binary number.");
        }
    
}
// custome exception class
class BinaryFormatException extends Exception{
    public BinaryFormatException(String s){
        super(s);
    }
}
}
