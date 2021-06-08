package decompHuff;

import java.util.HashMap;
import java.util.Map;

public class Compresser {
	
	  private Noeud racine;
	    private StringBuilder codage;
	    private Map<Character, String> codingmap;

	    /*Constrcuteur*/
	    public Compresser(Noeud noeudracine) {
	        racine = noeudracine;
	        codage = new StringBuilder();
	        codingmap = new HashMap<>();
	        Huffmancoding(racine);
	    }
