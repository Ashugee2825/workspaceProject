package inbuiltannotations;

import java.util.ArrayList;

public class Demo {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		@SuppressWarnings("unused")
		int a = 10;
		Demo1 d2 = new Demo2();
		d2.sample();
		d2.greet();
		System.out.println("Hello");
		
		new Integer(10);
		
		
		@SuppressWarnings({"rawtypes","unused"})
		ArrayList al = new ArrayList<>();


	}

}
