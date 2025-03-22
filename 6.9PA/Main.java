//create main class//
public class Main {

    //method for ft to meter/
    public static double footToMeter(double foot) {
        double meter;

        meter = 0.305 * foot;

        return meter;
    }
    //method for meter to foot//
    public static double meterToFoot(double meter) {
        double foot;

        foot = 3.279 * meter;

        return foot;
    }
    //main method
    public static void main(String[] args) {
    //convert feet to meters and print results for 1-10
        //start at 1
        double foot = 1;
            //create loop
            while (foot <= 10) {
            //invoke method
            double meter = footToMeter(foot);
            //print output
            System.out.println("Feet: "+ foot +"   Meter: " + meter);
            //iterate variable
            foot++;
    } 
    //convert meters to feet and print results for 20-65 by 5
        //start at 20
        double meter = 20;
            //create loop
            while (meter <= 65) {
            //invoke method
            double newFoot = meterToFoot(meter);
            //print output
            System.out.println("Meter: "+ meter +"   foot: " + newFoot);
            //iterate variable
            meter += 5;
        } 

}
}
