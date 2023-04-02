package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
public class Message {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO) 
	private Long id;
	
	/*
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	private Long id;
	*/

	private String text;
	
	public Message() {}
	public Message(String text) {
		this.text = text;
	}
	
	@Override
	public String toString() {
		return "Message [id=" + id + ", text=" + text + "]";
	}	
	
}
