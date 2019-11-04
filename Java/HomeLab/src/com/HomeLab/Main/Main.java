package com.HomeLab.Main;

import com.HomeLab.PracownikiSklepa.PracaSklepa;
import com.HomeLab.PracownikiSklepa.Rabotnik;
import com.HomeLab.PracownikiSklepa.Urzednik;
import com.HomeLab.TowarSklepa.Sklep;
import com.HomeLab.TowarSklepa.TowarDewlany;
import com.HomeLab.TowarSklepa.TowarMetal;

public class Main {

	public static void main(String args[]) {

		PracaSklepa firma = new PracaSklepa();

		System.out.println();
		firma.dodaj(new Rabotnik("Karl", "Amad", 100, 1, 50, 40));
		firma.dodaj(new Urzednik("Ilia", "Polon",95, 84, 10));
		firma.dodaj(new Rabotnik("Test", "Test", 45, 1.5, 15, 158));
		firma.dodaj(new Rabotnik("Test", "Amad", 5, 4, 55, 55));
		firma.listaPlac();

		System.out.println();

		firma.sumaWyplatRobotnikow();
		firma.sumaWyplatUrzednikow();
		System.out.println();

	//-----------------------------------------------
		
	Sklep towar =new Sklep();
	towar.zamowNaSklad(new TowarDewlany("Dor", "Drewa", 14, 300));
	towar.zamowNaSklad(new TowarDewlany("Table", "Drewa", 25, 184));
	towar.zamowNaSklad(new TowarDewlany("Bad", "Drewa", 32, 60));
	towar.zamowNaSklad(new TowarMetal("Bucket", "Metal", 45, 78));
	towar.zamowNaSklad(new TowarMetal("Nails", "Metal", 4.5, 1420));
	towar.zamowNaSklad(new TowarMetal("Tile", "Metal", 74.2, 140000));
	towar.listaTowar();
	
	towar.usunTowar("Table");
	System.out.println("  ");
	towar.listaTowar();
	System.out.println(" ");
	towar.listaTowaruPoTypu();
	System.out.println("");
	towar.KupToear("Bad",30);
	
	towar.listaTowar();
	
	}
}