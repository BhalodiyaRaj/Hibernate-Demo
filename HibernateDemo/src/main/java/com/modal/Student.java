package com.modal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Student_Info")
public class Student {
	@Id
	@Column(name = "Std_Id")
	private int id;
	@Column(name = "Std_Name")
	private String name;
	@Column(name = "Std_City")
	private String city;
	
	// embed other class. 
	private Certificate c;
	
	
	public Student(int id, String name, String city, Certificate c) {
		super();
		this.id = id;
		this.name = name;
		this.city = city;
		this.c = c;
	}

	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public Certificate getC() {
		return c;
	}
	public void setC(Certificate c) {
		this.c = c;
	}
	
	
	
	
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Student(int id, String name, String city) {
		super();
		this.id = id;
		this.name = name;
		this.city = city;
	}
	
	@Override
	public String toString() {
		
		return this.id+" "+this.name+" "+this.city;
	}
}
