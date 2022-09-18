package model;

public class Video extends Thing{

	public Video(String id, String name, String styte, String size, String property, float price, String duration,
			float amount) {
		super(id, name, styte, size, property, price, duration, amount);
		// TODO Auto-generated constructor stub
	}
	
	public String getDescription() {
		return "Video{" +
                "id=" + this.getId() +
                ", name=" + this.getName() +
                ", styte=" + this.getStyte() +
                ", size=" + this.getSize() +
                ", property=" + this.getProperty() +
                ", price=" + this.getPrice() +
                ", duration=" + this.getDuration() +
                ", amount=" + this.getAmount() +
                '}';
	}
	
}
