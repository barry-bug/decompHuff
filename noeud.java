package decompHuff;



public class Noeud {

	private int freq;
	private Character caract;
	private Noeud leftnode;
	private Noeud rightnode;
	
	/*Constructeur du noeud*/
	public Noeud(Character caract, int freq) {
		this.caract = caract;
		this.freq = freq;
	
}
