package com.friends.help.forms;

public class Test {
	
	public boolean isGoodString(String str){
		if(str!=null){
			if("".equals(str))
				return false;
		}else return false;
		
		if(str.length()<=2)
		return false;
		
		String temp = new String(str);
		int count=0;
		while(temp.length()>1 && temp.indexOf('A')>-1){
			if(temp.indexOf('A')>-1){
				count++;
				temp = temp.substring(temp.indexOf('A'));
			}
			if(count>3)return false;
		}

		
		if(str.substring(1).contains(str.substring(0, 1)))
			return false;
		
		for(int i=0;i<str.length();i++){
			char c1 = str.charAt(i);
			char c2;
			if(str.length()>i+1)
				c2 = str.charAt(i+1);
			else c2=' ';
			System.out.println(""+c1+c2);
			if(c1>='0' && c1<='9'){
				if(c2>='0' && c2<='9'){
			
				if(!"Ux".equals(str.substring(i-2, i))){
					System.out.println(str.substring(i-2, i));
					return false;
				}i=i+2;
			}else return false;
			}
		}
			
		
		return true;
	}

	
	
	
	public static void main(String[] args) {
		String s = "0123456789";
		System.out.println(s.substring(0, 2));
		Test t = new Test();
		System.out.println(t.isGoodString("Ux00Hello"));
	}

}
