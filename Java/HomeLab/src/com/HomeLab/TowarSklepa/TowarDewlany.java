package com.HomeLab.TowarSklepa;

public class TowarDewlany extends Towar {

	public TowarDewlany(String name, String type, double cost, int amount) {
		super(name, type, cost, amount);
	}

	@Override
	public String toString() {
		return name;
	}
	
	public boolean costTowar(int ile) {		
		 if(ile <= amount) {
			amount=amount-ile;
		 }else {
			 System.out.println("Przepraszam u nas nie ma tylo tego towaru");
			 return false;
		 }		
		return true;
	}

	public double costing(int ile) {
		double costT =0;
		costT = cost * ile; 
		return costT;
	}
	
	

}
