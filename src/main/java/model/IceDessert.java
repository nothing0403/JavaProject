package model;

import java.util.Arrays;

public class IceDessert {

	private int total;
	private String mainDish;
	private String[] toppings;
	
	public IceDessert(String mainDish,String[] toppings) {
		this.mainDish = mainDish;
		this.toppings = toppings;
		setTotal();
	}

	public String getMainDish() {
		return mainDish;
	}

	public String[] getToppings() {
		return toppings;
	}

	private void setTotal() {
		total = (toppings.length)*10 + (mainDish.equals("刨冰")?50:40);
	}
	
	@Override
	public String toString() {
		return "主餐: "+mainDish+" 加料項目: "+Arrays.toString(toppings)+" 總金額為: "+total;
	}
}
