package util;

import java.util.Map;

public class CoffeeOrderMain {
    public static void main(String[] args) {
    	Map<String, Map<String, Integer>> priceTable = Map.of
    			("latte", Map.of("S", 50,"M", 70,"L", 90),			                                              
    			 "mocha", Map.of("S", 45,"M", 55,"L", 65),		                                              
    			 "americano", Map.of("S", 40,"M", 45,"L", 60),
    		     "cappuccino", Map.of("S", 55,"M", 80,"L", 100));
    	
    	System.out.println(priceTable);
    }
}
