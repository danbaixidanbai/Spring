package bean;

public class Person {
	private String name;
	private String city;
	private Car car;
	private String info;
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
	public Car getCar() {
		return car;
	}
	public void setCar(Car car) {
		this.car = car;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public String toString() {
		return "Person [name=" + name + ", city=" + city + ", car=" + car + ", info=" + info + "]";
	}
	
}
