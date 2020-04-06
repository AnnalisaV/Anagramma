package it.polito.tdp.anagramma.model;

import java.util.List;

public class TestRicerca {

	public static void main(String[] args) {
		Ricerca ric = new Ricerca() ;
		
		List<String> ana_dog = ric.anagrammi("dog") ;
		System.out.println(ana_dog) ;
		
		/*List<String> ana_prog = ric.anagrammi("programmazione") ;
		System.out.println(ana_prog) ;*/
		
		List<String> ana_vac = ric.anagrammi("vacanze") ;
		System.out.println(ana_vac) ;
		
	}

}
