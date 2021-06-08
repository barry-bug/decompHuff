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
	
		    /*Méthode permettant de faire le codage de huffman à partir du noeud racine de l'arbre : en ajoutant 1 vers le noeud fils droit et 0 vers le noeud fils gauche  */
	    /*La méthode est récusrive car on l'utilisera sur chaque fils du noeud prix en paramétre jusqu'à atteindre l'extrémité. Ce sera cette succession de 1 et de 0 qui sera 
	     le code de huffman. Chaque caractère aura sa propre suite de bits.*/
	    private void Huffmancoding(Noeud myRoot) {
	    	//Traverse through tree adding 1s for right, 0s for left.
	        if (myRoot.getLeftnode() != null) {
	            codage.append(0);
	            Huffmancoding(myRoot.getLeftnode());
	            codage.deleteCharAt(codage.length() - 1);
	        }

	        if (myRoot.getCaract() != null) {
	            String str = String.valueOf(codage);
	            codingmap.put(myRoot.getCaract(), str);
	        }

	        if (myRoot.getRightnode() != null) {
	            codage.append(1);
	            Huffmancoding(myRoot.getRightnode());
	            codage.deleteCharAt(codage.length() - 1);
	        }

	    }
