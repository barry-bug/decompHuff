package decompHuff;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import java.util.Map;
import java.util.TreeMap;


/*class d'affichage*/
public class Main {
	private static Map<Character, Integer> frequencesm;
	private static ArbreHuffman treem;
	private static Noeud nodem;
	private static Map<Character, String> codingmapm;
//	private static final String testString = ;

	


	/*main*/
	public static void main( String[] theArgs) throws IOException {
		//Test String
		
	//	String content = Files.readString(Paths.get(path));
		
		//String testString = readFile("", Charset.defaultCharset());

		/*on recupere le texte qu'on souhaite traiter sous forme de string (voir classe FiletoString)*/
		String texte= FiletoString.readFile("C:/Users/Utilisateur/Documents/IDU/S6/Proj631_Algorithmique/Huffman/textesimple.txt", StandardCharsets.UTF_8);
		
		/*le traitement commence*/
		
		/*on créé le map des frequences du texte (class FrequenceChar)*/
		FrequenceChar freqmap = new FrequenceChar(texte);
		
		/*On enregistre les fréquences dans la variable locale frequencesm en prenant en compte l'ordre des index*/
		frequencesm = new TreeMap<Character, Integer>();
		frequencesm = freqmap.getFrequences();
	    

	    
		/*Ensuite, on crée l'arbre de Huffman avec les fréquences du fichier txt*/
		treem = new ArbreHuffman(freqmap.getFeuilles());
	    
		/*initialisation du noeud racine*/
		nodem = treem.getracine();
	    
		/*Compression*/
	    Compresser comp = new Compresser(nodem);
	    codingmapm = comp.getCodingmap();
	    printTable(frequencesm, codingmapm);
	    
	    /*le codage du texte en string qu'on peut afficher*/
	    String huffCode = Coder(texte, codingmapm);
	    
	    /*Decodage*/
	    Decompresser dec = new Decompresser(huffCode, nodem);
	    String decoded = "Résultat de la décompression du code: " + dec.Huffmandecoding();
        System.out.println(decoded);
        
        

	}
	


	/*creation du coode et l'afficher*/
	private static String Coder(String texte, Map<Character, String> codage) {

        StringBuilder huffmanCode = new StringBuilder();
        int size = 0;

        for (int i = 0; i < texte.length(); i++) {
            huffmanCode.append(codage.get(texte.charAt(i)));
            size += codage.get(texte.charAt(i)).length();
        }

        System.out.println("Compression du texte en binaire: ");
        System.out.println(huffmanCode);
        System.out.println("Le nombre de bits sans le codage de huffman: " + texte.length() * 16);
        System.out.println("Le nombre de bits avec le codage de huffman: " + size);

        return huffmanCode.toString();
    }
	
	/* affiche du map des caractères avec leurs fréquences et leur codage.
	 */
	private static void printTable(Map<Character, Integer> freq, Map<Character, String> bitcode) {

        System.out.println("---------------------------------------------------------------------------------");
        System.out.println("\tchar \tfrequency \tcode");
        System.out.println("---------------------------------------------------------------------------------");

        for (Character key : freq.keySet()) {
            System.out.printf("\t%c \t%d               %s\n", key, freq.get(key), bitcode.get(key));
        }

    }
	


}



