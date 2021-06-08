package decompHuff;


import java.util.List;

public class ArbreHuffman {

	private List<Noeud> noeuds; /*Liste de noeuds créé*/
	
	/*L'arbre est un ensemble de neouds*/
	/*constructeur*/
	public ArbreHuffman(List<Noeud> nodes) {
		noeuds = nodes;
		createTree();
	}
	
	/*Méthode permettant de créer l'arbre */
	private void createTree() {
		int a;
		int b;
		Noeud nodefusion; /*Noeud qui fusionne les deux petits noeuds*/
		
		while(noeuds.size() > 1) {
			a = min();
			Noeud noeud1 = noeuds.get(a);
			noeuds.remove(a);
			
			b = min();
			Noeud noeud2 = noeuds.get(b);
			noeuds.remove(b);
			
			nodefusion = new Noeud(null, noeud1.getFreq() + noeud2.getFreq()); /*Huffman*/
			nodefusion.setLeftnode(noeud1);
			nodefusion.setRightnode(noeud2);
			noeuds.add(nodefusion); /*Les 2 noeuds sont supprimés de la fusion et sont remplacés par le noeud fusion*/
		}
	}
	
	/*Création de la méthode qui permet de trouver le noeud qui a la plus petite fréquence.*/
	private int min() {
		int next;
		int min = noeuds.get(0).getFreq();
		int index = 0;
		
		for (int i = 0; i < noeuds.size() - 1; i++) {
			next = noeuds.get(i + 1).getFreq();
			if (min >= next) {
				min = next;
				index = i + 1;
			}
		}
		return index;
	}

}
