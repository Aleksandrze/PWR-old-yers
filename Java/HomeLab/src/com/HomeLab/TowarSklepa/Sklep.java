package com.HomeLab.TowarSklepa;

import java.util.ArrayList;

public class Sklep {

	public final static int SIZE = 10;
	private ArrayList<Towar> list;

	public Sklep() {
		list = new ArrayList<Towar>();
	}

	public boolean zamowNaSklad(Towar towar) {
		if (list.isEmpty()) {
			list.add(towar);
			return true;
		} else {
			for (Towar t : list) {
				if (t.equals(towar)) {
					return false;
				}
			}
		}
		list.add(towar);
		return true;

	}

	public void usunTowar(String name) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getName().equals(name)) {
				list.remove(list.get(i));
			}
		}
		System.out.println("Towar |"+name +"| byl ubranu  z skladu");
	}

	public void listaTowar() {
		int lp = 1;
		if (this.list != null) {
			System.out.println("Lista towaru:");
			System.out.println("lp\tname\ttyp\tcost\tamout");
			System.out.println("---------------------------------------------");
			for (Towar t : this.list) {
				System.out.println(lp + "\t" + t.getName() + "\t" + t.getType() + "\t" + t.getCost() + "\t" +(int)t.getAmount());
				
				lp++;
			}
		}
	}

	public void listaTowaruPoTypu() {
		int lp=1;
		if(true) {
			System.out.println("Lista towaru z Drzewa:");
			System.out.println("lp\tname\tcost\tamout");
		for(int i = 0; i<list.size();i++) {
			if(list.get(i) instanceof TowarDewlany) {				
				System.out.println(lp + "\t" + list.get(i).getName() + "\t"+ list.get(i).getCost()+"\t"+ (int)list.get(i).getAmount() );
		lp++;
			}
		}
		}
		System.out.println("Lista towaru z Metalu:");
		System.out.println("lp\tname\tcost\tamout");
		for(int i = 0; i<list.size();i++) {
			if(list.get(i) instanceof TowarMetal) {
				System.out.println(lp + "\t" + list.get(i).getName() + "\t"+ list.get(i).getCost()+"\t"+ (int)list.get(i).getAmount() );
			lp++;
			}
	}
}
	
//--------------------------------------------------	
	public void KupToear(String name,int ile) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getName().equals(name)) {
				if(list.get(i).costTowar(ile)) {
					System.out.println("Dzienki za zakup z panstwa " +list.get(i).costing(ile));
				 }else {
					 System.out.println("Przepraszam u nas nie ma tylo towaru");
			}
		}}
	}
	
}
