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
	        Noeud rootnode = racine;
	        StringBuilder text = new StringBuilder();
	        boolean trouvecaract = false;
	        /*On parcourt jusqu'à trouver un caractère*/
	        for (int i = 0; i < coded.length(); i++) {
	            if (trouvecaract) {
	            	rootnode = racine;
	                trouvecaract = false;
	            }

	            /*On ajoute dans le texte si un caractère est trouvé*/
	            if (coded.charAt(i) == '0') {
	                if (rootnode.getLeftnode().getCaract() == null) {
	                	rootnode = rootnode.getLeftnode(); 
	                } else {
	                    text.append(rootnode.getLeftnode().getCaract());
	                    trouvecaract = true;
	                }
	            } else {
	                if (rootnode.getRightnode().getCaract() == null) {
	                	rootnode = rootnode.getRightnode();
	                } else {
	                    text.append(rootnode.getRightnode().getCaract());
	                    trouvecaract = true;
	                }
	            }
	        }

	        return text.toString();
	    }
	    
		    
	    /*Getter et Setters*/
	    

		public String getCoded() {
			return coded;
		}

		public void setCoded(String coded) {
			this.coded = coded;
		}

		public Noeud getRacine() {
			return racine;
		}

		public void setRacine(Noeud racine) {
			this.racine = racine;
		}
	    
	   
	   
