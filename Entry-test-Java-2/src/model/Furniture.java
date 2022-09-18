package model;

public class Furniture extends Thing{
	private String color;

	public Furniture(String id, String name, String styte, String size, String property, float price, String duration,
			float amount, String color) {
		super(id, name, styte, size, property, price, duration, amount);
		// TODO Auto-generated constructor stub
		this.color = color;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public String getDescription() {
		return "Furniture{" +
                "id=" + this.getId() +
                ", name=" + this.getName() +
                ", styte=" + this.getStyte() +
                ", size=" + this.getSize() +
                ", property=" + this.getProperty() +
                ", price=" + this.getPrice() +
                ", duration=" + this.getDuration() +
                ", amount=" + this.getAmount() +
                ", color=" + this.getColor() +
                '}';
	}
	
}
