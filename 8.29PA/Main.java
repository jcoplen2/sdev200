import java.util.Scanner;

public class Main {
    
    public static boolean equals(int[][] m1, int[][] m2) {
        //compare each item in the two arrays
        for(int i = 0; i < m1.length; i++) {
            for (int j =0; j < m1[i].length; j++) {
                if (m1[i][j] != m2[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        //create m1
        int [][] m1 = new int[3][3];

        //get input for m1
        System.out.println("Enter " + m1.length + " rows and " + m1[0].length + " columns for m1: ");
        
        for (int row = 0; row < m1.length; row++){
            for (int column = 0; column < m1[row].length; column++) {
                m1[row][column] = input.nextInt();
            }
        }
        //create m2
        int [][] m2 = new int[3][3];

        //get input for m2
        System.out.println("Enter " + m2.length + " rows and " + m2[0].length + " columns for m2: ");

        for (int row = 0; row < m2.length; row++){
            for (int column = 0; column < m2[row].length; column++) {
                m2[row][column] = input.nextInt();
            }
        }
        //check if they are equal and print 
        if (equals(m1,m2)) {
            System.out.println("The arrays are identical.");
        }
        else {
            System.out.println("The arrays are not identical.");
        }
        input.close();
}
}
