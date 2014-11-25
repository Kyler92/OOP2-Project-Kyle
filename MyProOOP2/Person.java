/**
 * @(#)Person.java
 *
 *
 * @author 
 * @version 1.00 2014/10/16
 */


public class Person {
	private String name;
	private int age;
	private char gender;

    public Person() {
    	this("noname",0,'M');
    }
    
    public Person(String name,int age, char gender){
    	setName(name);
    	setAge(age);
    	setGender(gender);
    }
    
    public String getName(){return name;}
    
    public int getAge(){return age;}
     
    public char getGender(){return gender;}
    
    public void setName(String name)
    {
    	this.name=name;	
    }
    
    public void setAge(int age)
    {
    	this.age=age;	
    }
    
    public void setGender(char gender)
    {
    	this.gender=gender;
    }
    
    public void setPerson(String name, int age, char gender){
    	setName(name);
    	setAge(age);
    	setGender(gender);
    }
    
    
    public String toString() {
			return getName() + " " +  getAge() + " " +
				   getGender();
	}
    
    
    
}