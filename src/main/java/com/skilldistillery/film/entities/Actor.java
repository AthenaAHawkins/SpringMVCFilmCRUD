package com.skilldistillery.film.entities;

public class Actor {

	private int id;
	private String lastName;
	private String firstName;

	
	
	public Actor() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Override
	public String toString() {
		return "Actor [id=" + id + ", lastName=" + lastName + ", firstName=" + firstName + "]";
	}

}
