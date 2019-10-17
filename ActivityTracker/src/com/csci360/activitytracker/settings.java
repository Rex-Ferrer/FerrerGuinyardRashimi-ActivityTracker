package com.csci360.activitytracker;

//package edu.thunderBits.address.model;
import com.csci360.activitytracker.MainApp;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
/*holds info about settings*/
public class settings{
	private StringProperty time;
    private  StringProperty date;
    private  IntegerProperty age;
    private  IntegerProperty weight;
    private  IntegerProperty height;
	private  IntegerProperty stepgoal;
	private  StringProperty gender;
	
	public void setting() {
        this.time = new SimpleStringProperty(" ");
        this.date = new SimpleStringProperty(" ");
        
        // Some initial dummy data, just for convenient testing.
        this.age = new SimpleIntegerProperty(0);
        this.weight = new SimpleIntegerProperty(0);
        this.height = new SimpleIntegerProperty(0);
        this.stepgoal = new SimpleIntegerProperty(0);
        this.gender = new SimpleStringProperty(" ");
    }
	
	
	/**
	 * @return the gender
	 */
	public StringProperty genderProperty() {
		return gender;
	}
	
	 public void setGender(String gender) {
	        this.gender.set(gender);
	    }
	 public String getGender() {
		 return gender.get();
	 }

	/**
	 * @return the time
	 */
	public StringProperty timeProperty() {
		return time;
	}
	
	public void setTime(String time) {
	        this.time.set(time);
	    }
	 public String getTime() {
	        return time.get();
	    }

	/**
	 * @return the date
	 */
	public StringProperty dateProperty() {
		return date;
	}
	
	 public void setDate(String date) {
	        this.date.set(date);
	    }
	 public String getDate() {
	        return date.get();
	    }

	/**
	 * @return the age
	 */
	public IntegerProperty ageProperty() {
		return age;
	}
	 public void setAge(Integer age) {
	        this.age.set(age);
	    }
	 public Integer getAge() {
	        return age.get();
	    }

	/**
	 * @return the weight
	 */
	public IntegerProperty weightProperty() {
		return weight;
	}
	
	 public void setWeight(Integer weight) {
	        this.weight.set(weight);
	    }
	 public Integer getWeight() {
	        return weight.get();
	    }

	/**
	 * @return the height
	 */
	public IntegerProperty heightProperty() {
		return height;
	}
	 public void setHeight(Integer Height) {
	        this.height.set(Height);
	    }
	 public Integer getHeight() {
	        return height.get();
	    }

	/**
	 * @return the stepgoal
	 */
	public IntegerProperty stepGoalProperty() {
		return stepgoal;
	}
	 public void setstepGoal(Integer stepGoal) {
	        this.stepgoal.set(stepGoal);
	    }
	 public Integer getstepGoal() {
	        return stepgoal.get();
	    }
}