/**This is an instantiable Person class.
 @author Kyle Mulvihill
 @version 1.0 */ 

import java.io.*;

public class Person implements Serializable{
	
	//attributes
	private String name;
	private double age;
	private char gender;

	/** no argument constructor method
	 @param name the name of the person
	 @param age the age of the person
	 @param gender the gender of the person*/
    public Person() {
    	this("noname",0,'M');
    }
    
    /** three argument constructor method
	 @param name the name of the person
	 @param age the age of the person
	 @param gender the gender of the person*/
    public Person(String name,double age, char gender){
    	setName(name);
    	setAge(age);
    	setGender(gender);
    }
    
    /** acessor method to return the person name
	 *@return the name of the person */
    public String getName(){return name;}
    
    /** acessor method to return the person age
	 *@return the age of the person */
    public double getAge(){return age;}
    
     /** acessor method to return the person gender
	 *@return the gender of the person */
    public char getGender(){return gender;}
    
    /** mutator method to set the person name
	 *@param name the name of the person */
    public void setName(String name)
    {
    	this.name=name;	
    }
    
    /** mutator method to set the person age
	 *@param age the age of the person */
    public void setAge(double age)
    {
    	this.age=age;	
    }
    
    /** mutator method to set the person gender
	 *@param gender the gender of the person */
    public void setGender(char gender)
    {
    	this.gender=gender;
    }
    
    /** mutator method to set the person name, age and gender
	*@param name, age and gender of the person */
    public void setPerson(String name, double age, char gender){
    	setName(name);
    	setAge(age);
    	setGender(gender);
    }
    
    /** toString method to return the person details
	 *@return the name, age and gender of the person as a string */
    public String toString() {
			return getName() + " " +  getAge() + " " +
				   getGender();
	}
    
    
    
}