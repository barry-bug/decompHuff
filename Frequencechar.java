
public class FrequenceChar {
	private String text;  /*input*/
	private Map<Character, Integer> frequences;/* les clés sont les caractères et les valeurs en integer sont les fréquences des caractères.*/
	private List<Noeud> feuilles;  /* Les feuilles sont des listes de noeud: ils correspondent aux extrémités de l'arbre*/
	
	public FrequenceChar(String input) {
		text = input;
		frequences
