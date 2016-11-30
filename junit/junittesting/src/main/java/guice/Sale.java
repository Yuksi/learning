package guice;

public class Sale {

	private String product;
	private String store;
	private int number;
	private int pricePerItem;
	
	public Sale(String product, String store, int number, int pricePerItem) {
		this.product = product;
		this.store = store;
		this.number = number;
		this.pricePerItem = pricePerItem;
	}
	
	public int getValue() {
		return number*pricePerItem;
	}
	
	public void setNumber(int number) {
		this.number = number;
	}
	
	public void setPricePerItem(int pricePerItem) {
		this.pricePerItem = pricePerItem;
	}
	
	public void setProduct(String product) {
		this.product = product;
	}
	
	public void setStore(String store) {
		this.store = store;
	}
	
	public int getNumber() {
		return number;
	}
	
	public int getPricePerItem() {
		return pricePerItem;
	}

	public String getProduct() {
		return product;
	}
	
	public String getStore() {
		return store;
	}
}
