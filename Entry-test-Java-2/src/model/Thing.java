package model;

abstract class Thing {
	
	
	private String id;
	private String name;
	private String styte;
	private String size;
	private String property;
	private float price;
	private String duration;
	private float amount;
	
	public Thing(String id, String name, String styte, String size, String property, float price, String duration, float amount) {
		super();
		this.id = id;
		this.name = name;
		this.styte = styte;
		this.size = size;
		this.property = property;
		this.price = price;
		this.duration = duration;
		this.amount = amount;
	}


	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStyte() {
		return styte;
	}
	public void setStyte(String styte) {
		this.styte = styte;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getProperty() {
		return property;
	}
	public void setProperty(String property) {
		this.property = property;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public float getAmount() {
		return amount;
	}
	public void setamount(float amount) {
		this.amount = amount;
	}


	abstract String getDescription();
}
