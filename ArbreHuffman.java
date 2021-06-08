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
	
