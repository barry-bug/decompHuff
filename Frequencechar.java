package decompHuff;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;


public class FrequenceChar {
	private String text; /*input*/
	private Map<Character, Integer> frequences;/* les clés sont les caractères et les valeurs en integer sont les fréquences des caractères.*/
	private List<Noeud> feuilles;  /* Les feuilles sont des listes de noeud: ils correspondent aux extrémités de l'arbre*/
	
	/*Constructeur et initialisation */
	public FrequenceChar(String input) {
		text = input;
		frequences = new TreeMap<Character, Integer>();
		Frequencecaract();
		feuilles = new ArrayList<>();
		Deffeuilles(); 
	}
	
		/* On crée un table de caractères du texte donné en comptant pour chacun d'entre eux sa fréquence d'apparition */
	private void Frequencecaract() {
		char[] table = text.toCharArray();
		for (char car : table) {
			if(frequences.containsKey(car)) {
				frequences.put(car, frequences.get(car) + 1);
			} else {
				frequences.put(car, 1);
			}
		}
	}
	
	/*Définir les noeuds feuilles parmi les noeuds */
	private void Deffeuilles() {
		for(Character c : frequences.keySet()) {
			feuilles.add(new Noeud(c, frequences.get(c)));
		}
	}
	
	
		/*Getter et setter*/

