package com.myshop.entity;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="customer_details")
public class Customer {
@Id
@Column(name="custId")
private int id;
private String name; // the corresponding
// column name will be name in the table
// customer_details
private String emailId;  // the corresponding
// column name will be email_id

public Customer() {
	super();
	// TODO Auto-generated constructor stub
}
public Customer(int id, String name, String emailId) {
	super();
	this.id = id;
	this.name = name;
	this.emailId = emailId;
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
public String getEmailId() {
	return emailId;
}
public void setEmailId(String emailId) {
	this.emailId = emailId;
}


@Override
public int hashCode() {
	return Objects.hash(emailId, id, name);
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Customer other = (Customer) obj;
	return Objects.equals(emailId, other.emailId) && id == other.id && Objects.equals(name, other.name);
}
@Override
public String toString() {
	return "Customer [id=" + id + ", name=" + name + ", emailId=" + emailId + "]";
}




}
