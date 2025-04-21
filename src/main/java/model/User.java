package model;

public class User {

	private String userName;
	private String gender;
	private Integer age;
	private Double height;
	private Double weight;
	private Double bmiValue;
	private String result;
	
	public User(String userName, String gender, String age, String height, String weight) {
		this.userName = userName;
		this.gender = gender;
		this.age = Integer.parseInt(age);
		this.height = Double.parseDouble(height); 
		this.weight = Double.parseDouble(weight);
		
		this.bmiValue = this.weight / Math.pow(this.height/100.0, 2);
		
		setResult();
	}

	public String getUserName() {
		return userName;
	}

	public String getGender() {
		return gender;
	}

	public Integer getAge() {
		return age;
	}

	public Double getHeight() {
		return height;
	}

	public Double getWeight() {
		return weight;
	}

	public Double getBmiValue() {
		return bmiValue;
	}
	
	private void setResult() {
		double min=0; double max=0;
		switch (gender){
		    case "male":
		    	min=17.4;
		    	max=23.3;
		    	break;
		    case "female":
		    	min=17.1;
		    	max=22.7;
		}
		String reuslt = bmiValue < min?"過瘦": bmiValue >max?"過胖":"正常";
		this.result = reuslt;
	}

	public String getResult() {
		return result;
	}

	@Override
	public String toString() {
		return "User="+getUserName()+"Gender"+getGender()+"Age"+getAge()+
			   "Height="+getHeight()+"Weight="+getWeight()+"BMI="+getBmiValue();
	}
}
