package it.polito.tdp.anagramma.model;


import java.util.ArrayList;
import java.util.List;

public class Ricerca {
	
	private List<String> soluzione; 
	
/**
 * Genera tutti gli anagrammi della parola specificata in ingresso
 * @param string parola da anagrammare
 * @return  elenco di tutti gli anagrammi della parola data 
 */
	public List<String> anagrammi(String parola) {
		
		this.soluzione= new ArrayList<>(); 
		
		parola= parola.toUpperCase(); // per estetica 
		//creazione dell'insieme disponibili
		List<Character> disponibili= new ArrayList<>(); 
		for (int i=0; i<parola.length(); i++) {
			disponibili.add(parola.charAt(i)); 
		}
		
		//avviamento ricorsione
		cerca("", 0, disponibili); 
		return this.soluzione; //costruita pezzo a pezzo
	}
	
	/**
	 * Procedura ricorsiva per il calcolo dlel'anagramma 
	 * @param parziale parte iniziale dell'anagramma costruito finora
	 * @param levello livello della ricorsione = parziale.length()
	 * @param disponibili insieme delle lettere non ancora utilizzate 
	 */
	private void cerca(String parziale, int livello, List<Character> disponibili) {
		// si puo' evitare di passare il livello perche' in qst caso e' la lunghezza della stringa parziale 
		// scelgo un List e non Set perche' potrei avere lettere uguali da dover utilizzare (il Set non mi permette duplicati)

		//CASO TERMINALE
		if (disponibili.size()==0) /*anche if (livello=parola.length()) */ {
			//allora la String parziale e' un'anagramma possibile 
			
			//if (parziale sta nel dizionario)
			// posso anche controllare di non duplicare le parole (if parziale non e' gia' nella soluzione) ma in realta' basta creare anziche' una List un Set
			this.soluzione.add(parziale); 
			// altrimenti la butto perche' non e' una parola sensata (pero' e' stata calcolata! Tempo 'perso') Altra possibilita' e' consultare il dictionary mentre faccio la parola ex non esiste parola che inizi con DG quindi non la genero nemmeno, fermo
			}
		
		//CASO NORMALE
		// provo ad aggiungere alla soluzione parziale tutti i caratteri presenti tra i disponibili 
		for (Character c : disponibili) {
			String tentativo= parziale+c; // non parziale += c perche' String e' immutabile una volta che e' stata definita
			                        // il vantaggio e' non dover fare backtracking perche' implicito qui avendo creato una nuova String tentativo
			
			//if (nel dizionario esistono parole ch einiziano con 'tentativo'){
			List<Character> rimanenti= new ArrayList<>(disponibili); 
			 rimanenti.remove(c); // gli tolgo il carattere appena usato così questa lista la passo per ricorsione al livello successivo
			                     // infatti non posso modificare la lista su cui sto iterando
			
			cerca(tentativo,livello+1,rimanenti); 
			//}
			//se non esistono mi fermo nella ricorsione, evito calcolo inutile
		}
	
	}
	
	
	// Domande che mi devo porre : 
	/* 
	 * Dato di partenza : parola da anagrammare di lunghezza N 
	 * Cos'e' la soluzione parziale? una parte dell'anagramma gia' costruito (i primi caratteri)
	 * Livello : numero di lettere di cui e' composta la soluzione parziale 
	 * Soluzione totale : soluzione a lunghezza N -> allora sono nel caso terminale 
	 * Caso terminale : salvare la soluzione trovata per poterla fornire
	 * Generazione nuove soluzioni : provare ad aggiungere una lettera scegliendola fra quelle che non sono 
	 * ancora state utilizzate nella soluzione parziale 
	 */
}