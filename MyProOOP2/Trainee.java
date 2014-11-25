import java.io.*;

public class Trainee extends Person implements Serializable{
	private int weight;
	private int height;
	
	 public Trainee() {
    	this(0,0);
    }
    
    public Trainee(int weight, int height){
    	setWeight(weight);
    	setHeight(height);
    
    }
    
    public int getWeight(){return weight;}
    
    public int getHeight(){return height;}
    
    public void setWeight(int weight)
    {
    	this.weight=weight;	
    }
    
    public void setHeight(int height)
    {
    	this.height=height;	
    }
    
    public String toString() {
			return getName() + " " +  getAge() + " " +
				   getGender() + " " + getWeight() + " " + getHeight();
	}
}