package annotations.ca;

public class Student {
		
		private String name;
		private int age;
		@setdata(agevalue ="age shouls be greater")
		public  void setAges(int age) {
			if (age >= 18) 
				this.age = age;
			else
				age = 0;
		
	}

}
