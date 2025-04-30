package util;

public class Util {

	public static boolean isDouble(String data) {
		try {
			Double.parseDouble(data);		
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public static boolean isDouble2(String data1, String data2) {
		try {
			Double.parseDouble(data1);
			Double.parseDouble(data2);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public static boolean isNumber(String data) {
		try {
			Integer.parseInt(data);
			return true;
		}
		catch(Exception e) {
			return false;
		}
	}
	
	public static boolean isNumber2(String data) {
		return data.matches("\\d+");
	}
	
	public static boolean isType(String data) {
		try {
			if(data.matches("Latte")|data.matches("Mocha")|data.matches("Americano")|data.matches("Cappuccino")) {
				return true;
			}
			else {
				return false;
			}
		} catch (Exception e) {
			return false;
		}
	}
	
	public static boolean isSize(String data) {
		try {
			if(data.matches("S")|data.matches("M")|data.matches("L")) {
				return true;
			}
			else {
				return false;
			}
		} catch (Exception e) {
			return false;
		}
	}
	
	public static boolean isSugar(String data) {
		try {
			if(data.matches("yes")|data.matches("no")) {
				return true;
			}
			else {
				return false;
			}
		} catch (Exception e) {
			return false;
		}
	}
	
}
