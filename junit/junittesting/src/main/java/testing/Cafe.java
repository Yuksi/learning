package testing;

public class Cafe {
	private int beansInStock = 0;
	private int milkInStock = 0;
	
	public int getBeansInStock() {
		return beansInStock;
	}
	
	public int getMilkInStock() {
		return milkInStock;
	}
	
	public Coffee brew(CoffeeType type) {
		return brew(type, 1);
	}
	
	public Coffee brew(CoffeeType type, int quantity) {
		requirePositive(quantity);
		
		int requiredBeans = type.getRequiredBeans() * quantity;
		int requiredMilk = type.getRequiredMilk() * quantity;
		if (requiredBeans>beansInStock||requiredMilk>milkInStock) {
			throw new IllegalStateException("Insuffisient milk or bean");
		}
		
		beansInStock -= requiredBeans;
		milkInStock -= requiredMilk;
		return new Coffee(type, requiredBeans, requiredMilk);
	}
	
	public void restockBeans(int weightInGrams) {
		requirePositive(weightInGrams);
		beansInStock += weightInGrams;
	}
	
	public void restockMilk(int weightInGrams) {
		requirePositive(weightInGrams);
		milkInStock += weightInGrams;
	}
	
	public void requirePositive(int value) {
		if (value<1) {
			throw new IllegalArgumentException();
		}
	}

}
