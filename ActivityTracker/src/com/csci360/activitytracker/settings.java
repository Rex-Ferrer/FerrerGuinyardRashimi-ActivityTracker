package com.csci360.activitytracker;

//package edu.thunderBits.address.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

/*holds info about settings*/
public class settings {

  public String Hours;
  public String Minutes;
	private IntegerProperty age;
	private IntegerProperty weight;
	

	public void setting() {
		//this.Hours = new SimpleStringProperty(" ");
		//this.Minutes = new SimpleStringProperty(" ");

		this.age = new SimpleIntegerProperty(12);
		this.weight = new SimpleIntegerProperty(130);
		
	}

	
	/**
	 * @return the time
	 */
	/*
	 * public StringProperty HoursProperty() { return Hours; }
	 */

	public void setHours(String Hours) {
		this.Hours=Hours;
	}

	public String getHours() {
		return Hours;
	}

	/*
	 * public StringProperty minProperty() { return Minutes; }
	 */
	public void setMin(String min) {
		this.Minutes=min;
	}

	public String getMin() {
		return Minutes;
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

	
}