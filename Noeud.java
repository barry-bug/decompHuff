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
	
	/*Getter et setter*/
	

	public int getFreq() {
		return freq;
	}

	public void setFreq(int freq) {
		this.freq = freq;
	}

	public Character getCaract() {
		return caract;
	}

	public void setCaract(Character caract) {
		this.caract = caract;
	}

	public Noeud getLeftnode() {
		return leftnode;
	}

	public void setLeftnode(Noeud leftnode) {
		this.leftnode = leftnode;
	}

	public Noeud getRightnode() {
		return rightnode;
	}

	public void setRightnode(Noeud rightnode) {
		this.rightnode = rightnode;
	}
	
	
	
}
