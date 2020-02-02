import java.util.Scanner;

public class BMICalculator {

    private int unitType;
    private float height;
    private float weight;
    private String BmiCategory;
    private float Bmi;

    Scanner scan = new Scanner(System.in);

    public void readUserData(){
        readUnitType();
        readMeasurementData(this.unitType);
    }
    // Create a menu to allow for imperial or metric input
    private void readUnitType(){
        System.out.println("Welcome to the BMI calculator.");
        System.out.println("Please select a unit type:");
        System.out.println("(Press 1 for Imperial, 2 for Metric...)");
        this.unitType = scan.nextInt();
    }
    // if user enters 1, go to imperial data, if 2 read metric, otherwise
    // continue to ask for input until either 1 or 2 is entered
    private void readMeasurementData(int ut){
        if (ut == 1){
            readImperialData();
        }
        else if (ut == 2){
            readMetricData();
        }
        else {
            readUserData();
        }
    }
    // read data and call set functions
    private void readMetricData(){
        System.out.println("You selected Metric.");
        System.out.println("Please enter your weight (in kg):");
        setWeight();
        System.out.println("Please enter your height (in cm):");
        setHeight();
    }

    private void readImperialData(){
        System.out.println("You selected Imperial.");
        System.out.println("Please enter your weight (in lbs):");
        setWeight();
        System.out.println("Please enter your height (in inches):");
        setHeight();
    }
    // calculate the bmi with appropriate formula for imperial or metric
    public void calculateBmi(){
        if(unitType == 1){
            this.Bmi = (703*getWeight())/(getHeight()*getHeight());
        } else if (unitType == 2){
            this.Bmi = (getWeight())/((getHeight()/100)*(getHeight()/100));
        }
        calculateBmiCategory();
    }
    // calculate users bmi category
    private void calculateBmiCategory(){
        if (getBmi() < 18.5){
            BmiCategory = "Underweight";
        } else if ((getBmi() >= 18.5) && (Bmi <= 24.9)){
            BmiCategory = "Normal weight";
        } else if ((getBmi() >= 25) && (Bmi <= 29.9)){
            BmiCategory = "Overweight";
        } else if (getBmi() > 30){
            BmiCategory = "Obese";
        }
    }

    public void displayBmi(){
        System.out.println("Your BMI is: " + getBmi() + " which makes you: " + getBmiCategory());
    }

    public float getWeight(){
        return this.weight;
    }
    // take users weight as a float, if number is negative program exits
    private void setWeight(){
        this.weight = scan.nextFloat();
        if (this.weight < 0) {
            System.out.println("Error: Negative weight!");
            System.exit(0);
        }
    }

    public float getHeight(){
        return this.height;
    }
    // take users height as a float, if number is negative program exits
    private void setHeight(){
        this.height = scan.nextFloat();
        if (this.height < 0){
            System.out.println("Error: Negative height!");
            System.exit(0);
        }
    }

    public float getBmi(){
        return this.Bmi;
    }

    public String getBmiCategory(){
        return this.BmiCategory;
    }
}
