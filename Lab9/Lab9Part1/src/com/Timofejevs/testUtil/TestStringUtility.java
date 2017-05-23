package com.Timofejevs.testUtil;


import com.Timofejevs.util.StringUtility;


public class TestStringUtility {
	

	public static void main(String[] args) {
		int value = StringUtility.getSumOfAcsiiValues("Deniss");
		int value2 = StringUtility.getProductOfAsciiValues("Deniss");
		
		
		System.out.println("The value from first method is "+value);
		System.out.println("The value from second method is "+value2);
	}

}
