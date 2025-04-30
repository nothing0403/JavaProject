package model;

import java.util.Map;

public class CoffeeForm {

	private String kind;
	private Double milk;
	private Double coffee;
	private String text;
	
	
	public CoffeeForm(String milk, String coffee) {
		this.milk = Double.parseDouble(milk);
		this.coffee = Double.parseDouble(coffee);
		setText();
	}

	public String getKind() {
		return kind;
	}

	public Double getMilk() {
		return milk;
	}

	public Double getCoffee() {
		return coffee;
	}

	public String getText() {
		return text;
	}

	private void setText() {
		if(milk>=3*coffee) {
			kind = "濃郁的拿鐵";
			text = "牛奶的比例遠高於咖啡，味道偏向牛奶。";
		}
		else if(milk>=1.5*coffee) {
			kind = "平衡的拿鐵咖啡";
			text = "牛奶與咖啡的比例較為平衡，風味溫和。";
		}
		else if(milk == coffee) {
			kind = "標準卡布奇諾";
			text = "牛奶與咖啡的比例恰到好處，典型的卡布奇諾。";
		}
		else if(coffee>=3*milk) {
			kind = "濃縮咖啡";
			text = "咖啡的比例遠高於牛奶，口感濃烈，偏向純咖啡。";
		}
		else {
			kind = "普通咖啡";
			text = "牛奶與咖啡的比例較為普通，適合日常飲用。";
		}
	}
}
