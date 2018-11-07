package bean;

public class Car {
	public String toString() {
		return "Car [brand=" + brand + ", price=" + price + ", typePerimeter=" + typePerimeter + "]";
	}
	private String brand;
	private double price;
	private String typePerimeter;
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getTypePerimeter() {
		return typePerimeter;
	}
	public void setTypePerimeter(String typePerimeter) {
		this.typePerimeter = typePerimeter;
	}
}
