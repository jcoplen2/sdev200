
public class Main {
    public static void main(String[] args) {

        //create default instance
        RegularPolygon polygon1 = new RegularPolygon();
        System.out.println("polygon 1 - perimeter: " + polygon1.getPerimeter() + "area: " + polygon1.getArea());

        //create with side and length
        RegularPolygon polygon2 = new RegularPolygon(6, 4);
        System.out.println("polygon 2 - perimeter: " + polygon2.getPerimeter() + "area: " + polygon2.getArea());

        //create with all variables
        RegularPolygon polygon3 = new RegularPolygon(10, 4, 5.6, 7.8);
        System.out.println("polygon 3 - perimeter: " + polygon3.getPerimeter() + "area: " + polygon3.getArea());

    }
    static class RegularPolygon {
        //set default variables
        private int n = 3;
        private double side = 1;
        private double x = 0;
        private double y = 0;

        //no arg constructor
        RegularPolygon() {  
        }

        //construtor with specific side and length
        RegularPolygon(int n, double side) {
            this.n = n;
            this.side = side;
        }

        //constructor with all variables
        RegularPolygon(int n, double side, double x, double y){
            this.n = n;
            this.side = side;
            this.x = x;
            this.y = y;
        }

        //methods to get and set variables
        public int getN() {
            return n;
        }

        public void setN(int n) {
            this.n = n;
        }

        public double getSide() {
            return side;
        }

        public void setSide(double side) {
            this.side = side;
        }

        public double getX() {
            return x;
        }

        public void setX(double x) {
            this.x = x;
        }

        public double getY() {
            return y;
        }

        public void setY(double y) {
            this.y = y;
        }

        //perimeter method
        public double getPerimeter() {
            return side * n;
            
        }

        //area method
        public double getArea() {
            return (n * (side * side)) / (4 * Math.tan(Math.PI / n));
            
        }
      }
}
