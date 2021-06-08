package decompHuff;

public class Decompresser {
    /*paramétres*/

	 private String coded;
	    private Noeud racine;
	    
	    /*Constructeur de "Decompresser. Les paramétres sont le texte déjà codé et le noeud racine de l'arbre.*/
	    public Decompresser(String encoded, Noeud racinenode) {
	        coded = encoded;
	        racine = racinenode;
	    }
	    
	    /* Méthode qui permet de décoder un message déjà codé. Pour décoder, on fait plutot l'inverse de ce qu'on a fait dans compresser: On essaye de retrouver le caractère correspondant
	     au code. On s'inspire de l'arbre et la position des 1 et 0 en se référant au code binaire. Tout en sachant que chaque caractère a un unique code, on parcourt donc l'arbre 
	     en profondeur à l'aide du code binaire. */
	    public String Huffmandecoding() {
