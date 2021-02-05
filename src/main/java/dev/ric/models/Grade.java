package dev.ric.models;

public class Grade {

	private int id;
	private String type;
	private int value;

	public Grade() {
		super();
	}

	public Grade(int id, String type, int value) {
		super();
		this.id = id;
		this.type = type;
		this.value = value;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "Grade [id=" + id + ", type=" + type + ", value=" + value + "]";
	}

}
