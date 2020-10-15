import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * La classe Grille.
 * 
 * @author Clement GRANDGIRARD
 */
public class Grille {

	/** Tableau de String tab */
	public String[][] tab; 
	
	/** Nombre de billes nbBilles*/
	public int nbBilles;
	
	
	/**
	 * Constructeur Grille
	 *
	 * @param File f, ficher a lire
	 * @throws IOException
	 */
	public Grille(File f) throws IOException {
		FileReader fr = new FileReader(f);  
		BufferedReader br = new BufferedReader(fr); 
		
		int hauteur = 0;
        while (br.readLine() != null){
        	hauteur++;
        }
        
		int largeur = (((int) f.length())/hauteur)-1;
		
        String[][] tablier = new String[hauteur][largeur];
        
		String c = "";
		int i = 0;  
		
		fr = new FileReader(f);
		br = new BufferedReader(fr);
		
		while((c = br.readLine()) != null) { 
			for(int y = 0; y < largeur; y++) {
				tablier[i][y] = String.valueOf(c.charAt(y));	
				if(c.charAt(y) == 'o') {
					this.nbBilles++;
				}
			}         
			i++;
		}
		
		br.close();
		
		this.tab = tablier;
	}
	
	
	/**
	 * Methode tester Deplacement
	 *
	 * @param int i, y
	 * @return boolean resultat
	 */
	public boolean testerDeplacement(int i1, int i2, int i3, int y1, int y2, int y3) {
		Boolean resultat = false;
		if(this.tab[i1][y1].equals("o") && this.tab[i2][y2].equals("o") && this.tab[i3][y3].equals(".")) {
			resultat = true;
		}
		return resultat;
	}
	
	
	/**
	 * Methode changer valeur
	 *
	 * @param int i, y
	 */
	public void changerVal(int i1, int i2, int i3, int y1, int y2, int y3) {
		this.tab[i1][y1] = ".";
		this.tab[i2][y2] = ".";
		this.tab[i3][y3] = "o";
	}
	
	
	/**
	 * Methode retour Arriere
	 *
	 * @param int i, y
	 */
	public void retourArriere(int i1, int i2, int i3, int y1, int y2, int y3) {
		this.tab[i1][y1] = "o";
		this.tab[i2][y2] = "o";
		this.tab[i3][y3] = ".";
	}
	
	
	/**
	 * Methode get Hauteur
	 *
	 * @return int hauteur du tableau
	 */
	public int getHauteur() {
		return this.tab.length;
	}
	
	
	/**
	 * Methode get largeur
	 *
	 * @return int largeur du tableau
	 */
	public int getLargeur() {
		return this.tab[0].length;
	}
	
	
	/**
	 * Methode get Nombre de billes
	 *
	 * @return int nbBilles, nombres de billes
	 */
	public int getNbBilles() {
		return this.nbBilles;
	}
	
	
	/**
	 * Methode get Tablier
	 *
	 * @return String[][] tab, tablier actuelle
	 */
	public String[][] getTab(){
		return this.tab;
	}
	
	
	
}
