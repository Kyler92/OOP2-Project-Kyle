import java.io.*;

public class Trainee extends Person implements Serializable{
	private double weight;
	private double height;
	
	//no argument constructor
	 public Trainee() {
    	this(0,0);
    }
    
    // two argument constructor
    public Trainee(double weight, double height){
    	setWeight(weight);
    	setHeight(height);
    }
    
    //accessor
    public double getWeight(){return weight;}
    
    //accessor
    public double getHeight(){return height;}
    
    //mutator
    public void setWeight(double weight)
    {
    	this.weight=weight;	
    }
    
    //mutator
    public void setHeight(double height)
    {
    	this.height=height;	
    }
    
    //toString method to write trainee details to the screen
    public String toString() {
    	
			return  "Name: " + getName() + "\nAge: " + getAge()+"\nGender: " + getGender() + "\nWeight: " + getWeight() + "\nHeight: " + getHeight();
	}
}