public class Circle extends GeometricObject implements Comparable<Circle> {
    private double radius;
  
    public Circle() {
    }
  
    public Circle(double radius) {
      this.radius = radius;
    }
  
    //get radius
    public double getRadius() {
      return radius;
    }
  
    //set radius
    public void setRadius(double radius) {
      this.radius = radius;
    }
  
    @Override //get area
    public double getArea() {
      return radius * radius * Math.PI;
    }
  
    //get diameter
    public double getDiameter() {
      return 2 * radius;
    }
  
    @Override //get perimeter
    public double getPerimeter() {
      return 2 * radius * Math.PI;
    }
  
    //print circle
    public void printCircle() {
      System.out.println("The circle is created " + getDateCreated() +
        " and the radius is " + radius);
    }
  
    @Override //return string
    public String toString() {
      return super.toString() + " radius: " + radius;
    }
  

    @Override // Override compareTo 
    public int compareTo(Circle o) {
        return Double.compare(this.getRadius(), o.getRadius());
    }

    @Override //Override equals
    public boolean equals(Object obj) {
        if (this == obj) return true;
        
        Circle other = (Circle) obj;
        return radius == other.radius;

    }
    //main method to ensure code runs as it should
    public static void main(String[] args) {
        Circle c1 = new Circle(10);
        Circle c2 = new Circle(15);

        boolean result = c1.equals(c2);

        System.out.println("Are the circles equal? " + result);
    }
}

