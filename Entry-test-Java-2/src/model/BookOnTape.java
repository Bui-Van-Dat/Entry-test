package model;

public class BookOnTape extends Thing {
	private String author;

	public BookOnTape(String id, String name, String styte, String size, String property, float price, String duration,
			float amount, String author) {
		super(id, name, styte, size, property, price, duration, amount);
		this.author = author;
		// TODO Auto-generated constructor stub
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
	
	public String getDescription() {
		return "BOT{" +
                "id=" + this.getId() +
                ", name=" + this.getName() +
                ", styte=" + this.getStyte() +
                ", size=" + this.getSize() +
                ", property=" + this.getProperty() +
                ", price=" + this.getPrice() +
                ", duration=" + this.getDuration() +
                ", amount=" + this.getAmount() +
                ", author=" + this.getAuthor() +
                '}';
	}
}
