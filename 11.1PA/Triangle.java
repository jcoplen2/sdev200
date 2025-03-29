import java.util.Scanner;

public class Triangle extends GeometricObject {
    
    ///set data fields
    double side1 = 1;
    double side2 = 1;
    double side3 = 1;
    
    ///constructors
    public Triangle(){

    }

    public Triangle(double side1, double side2, double side3){
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    ///accessor methods
    public double getSide1(){
        return side1;
    }

    public double getSide2(){
        return side2;
    }

    public double getSide3(){
        return side3;
    }

    ///over ride abstract methods from parent class
    public double getArea() {
        double s = (side1 + side2 + side3) / 2;
        return Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
    }

    public double getPerimeter(){
        return side1 + side2 + side3;
    }

    ///convert to string
    public getString() {
        return "Triangle: side1 = " + side1 + " side2 = " + side2 +
        " side3 = " + side3;
    }

    
    public static void main(String[] args) {
        //get user input
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter the length for side 1: ");
        double side1 = input.nextDouble();

        System.out.print("Enter the length for side 2: ");
        double side2 = input.nextDouble();

        System.out.print("Enter the length for side 3: ");
        double side3 = input.nextDouble();

        input.nextLine();

        System.out.print("Enter the color of the triangle: ");
        String color = input.nextLine();

        System.out.print("Is the triangle filled? true or false: ");
        boolean filled = input.nextBoolean();

        //create object
        Triangle triangle = new Triangle(side1, side2, side3);
        triangle.setColor(color);
        triangle.setFilled(filled);
        //print statments
        System.out.println("Area: " + triangle.getArea());
        System.out.println("Perimeter: " + triangle.getPerimeter());
        System.out.println("Color: " + triangle.getColor());
        System.out.println("Filled: " + filled);
        

    }
    
}
