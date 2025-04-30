package model;

import java.util.*;
import java.util.function.BiPredicate;

public class Phone{
	
	private int mins;
	private int GB;
	
	private static final List<PhoneRule> rules = new ArrayList<>();

	public Phone(int mins, int GB) {
		this.mins = mins;
		this.GB = GB;
	}
    
	static class PhoneRule {
		
		private String type;
		private int price;
		private BiPredicate<Integer, Integer> condition;
		
		public PhoneRule(String type, int price, BiPredicate<Integer, Integer> condition) {
			this.type = type;
			this.price = price;
			this.condition = condition;
		}		
		
		public Boolean matches(int mins, int GB) {
			return condition.test(mins,GB);
		}
		
		public String getResult() {
			return type + ":$" + price;
		}
	}
	
	static {
		rules.add(new PhoneRule("商用型",1499 , (mins, GB)-> mins>1000 || GB>50));
		rules.add(new PhoneRule("一般用戶型",660 , (mins, GB)-> mins>500 || GB>10));
		rules.add(new PhoneRule("長輩節省型",200 , (mins, GB)-> mins<200 && GB<1));
	}
	
	public String getCoffeeType() {
		return rules.stream()
				    .filter(rule -> rule.matches(mins, GB))
				    .findFirst()
				    //.map(CoffeeRule::getResult)
				    .map(rule -> rule.getResult())
				    .orElse("沒有合適的電話方案");
	}

	public int getMins() {
		return mins;
	}

	public int getGB() {
		return GB;
	}
	
}
