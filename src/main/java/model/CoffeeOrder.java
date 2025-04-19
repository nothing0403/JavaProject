package model;

import java.util.Map;

public class CoffeeOrder {

	private String type;
	private String size;
	private String ice;
	private int price;
	
	private static final Map<String, Map<String, Integer>> priceTable = Map.of(
			"greentea", Map.of("S", 30,"M", 50,"L", 50),
            "blacktea", Map.of("S", 45,"M", 55,"L", 65),
            "milktea", Map.of("S", 40,"M", 45,"L", 60));
	
	private static final Map<String, String> sizeTable = Map.of("S","小","M","中","L","大");
	private static final Map<String, String> sugarTable = Map.of("yes","有糖","no","無糖");
	
	public CoffeeOrder(String type, String size, String ice) {
		this.type = type;
		this.size = size;
		this.ice = ice;
		this.price = priceTable.get(type.toLowerCase()).get(size);
	}

	public String getInfo() {
		String sizeText = sizeTable.get(size);
		String sugarText = sugarTable.get(ice);
		return String.format("您點了一杯%s杯%s咖啡(%s)價格:%d元",sizeText,type,sugarText,price);
	}

	public String getType() {
		return type;
	}

	public String getSize() {
		return size;
	}

	public String getIce() {
		return ice;
	}

	public int getPrice() {
		return price;
	}
	
	
}
