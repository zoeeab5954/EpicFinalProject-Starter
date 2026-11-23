public class Item {
	private String name;
	private String description;
	private int quantity;
	
	public Item(String name, String description, int quantity) {
		this.name = name;
		this.description = description;
		this.quantity = quantity;
	}
	
	public String getName() {
		return name;
	}
	
	public String getDescription() {
		return description;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public void addQuantity(int amount) {
		this.quantity += amount;
	}
}
