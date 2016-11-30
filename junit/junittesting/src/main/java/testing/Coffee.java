package testing;

public class Coffee {
	private final CoffeeType type;
	private final int beans;
	private final int milk;
	
	public Coffee(CoffeeType type, int beans, int milk) {
		this.type = type;
		this.beans = beans;
		this.milk = milk;
	}
	
	public CoffeeType getCoffeeType() {
		return type;
	}

	public int getBeans() {
		return beans;
	}
	
	public int getMilk() {
		return milk;
	}
	
	public String toString() {
		return "Coffee{" + "type=" + type + " beans=" + beans + " milk=" + milk + "}";
	}
}
