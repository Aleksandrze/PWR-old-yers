package com.HomeLab.TowarSklepa;

public class TowarMetal extends Towar{

	public TowarMetal(String name, String type, double cost, int amount) {
		super(name, type, cost, amount);
	}
	
	
	public String toString() {
		return name;
	}

	public boolean costTowar(int ile) {
		double costT =0;
		 if(ile <= amount) {
			costT = cost * ile; 
			amount=amount-ile;
		
		 }else {
			 System.out.println("Przepraszam u nas nie ma tylo towaru");
			 return false;
					
		 }		
		 System.out.println(costT);
		return true;
	}
	public double costing(int ile) {
		double costT =0;
		costT = cost * ile; 
		return costT;
	}
}
