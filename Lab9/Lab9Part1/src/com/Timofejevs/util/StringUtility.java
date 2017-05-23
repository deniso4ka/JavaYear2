package com.Timofejevs.util;

import java.util.Vector;

public class StringUtility {
	
	
	
	public static int getSumOfAcsiiValues(String s){
		
		int value =0;
		int tempValue=0;
		
		Vector<Integer> vec =new Vector<Integer>();
		
		 for (int i = 0; i < s.length(); i++){
	            char c = s.charAt(i);
	            tempValue = (int)c; 
	            vec.addElement(tempValue);
		 }
		 
		 System.out.print(s+" = ");
		 for(int x=0; x<vec.size(); x++){
			
			 System.out.print(vec.elementAt(x)+" + ");
			 value=value+vec.elementAt(x);
		 }
		 System.out.println(" = "+value);
		return value;
	}

	public static int getProductOfAsciiValues(String s){
		
		int value2 =0;
		int tempValue2=0;
		int temp=0;
		Vector<Integer> vec2 =new Vector<Integer>();
		
		 for (int i = 0; i < s.length(); i++){
	            char c = s.charAt(i);
	            tempValue2 = (int)c; 
	            vec2.addElement(tempValue2);
		 }
		 
		 value2=vec2.elementAt(0); //to avoid multiplication (*0)we manualy give 0 element value 
		 System.out.print(s+" = ");
		 for(int x=1; x<vec2.size(); x++){
			
			
			 temp=vec2.elementAt(x);
			 System.out.print(temp+" * ");
			
			 value2=value2*temp;
		 }
		
		System.out.println(" = "+value2);
		
		return value2;
	}
	
	
	
}
