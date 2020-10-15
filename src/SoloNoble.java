
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * La classe SoloNoble.
 * 
 * @author Clement GRANDGIRARD
 */
public class SoloNoble {

	/** La grille de soloNoble */
	private Grille g;
	
	/** Liste resultat des etapes de la solution */
	private ArrayList<String> resultat = new ArrayList<String>();

	
	/**
	 * Constructeur SoloNoble
	 *
	 * @param Grille gr, nouvelle grille
	 */
	public SoloNoble(Grille gr){
		this.g = gr;
	}

	
	/**
	 * Methode resoudre SoloNoble
	 *
	 * @param int billes, le nombre de billes restantes
	 * @return boolean fin 
	 */
	public boolean resoudreSoloNoble(int billes) {
		Boolean fin = false;
		
		if(billes == 1) {
			fin = true;
		}else {
			for(int i = 0; i < this.g.getHauteur(); i++) {
				for(int y = 0; y < this.g.getLargeur(); y++) {
					String res = this.toString();
					try{
						if(g.testerDeplacement(i,i,i,y,y-1,y-2) && !fin) {
							this.g.changerVal(i,i,i,y,y-1,y-2);
							fin = this.resoudreSoloNoble(billes-1);
							if(!fin) {
								this.g.retourArriere(i,i,i,y,y-1,y-2);
							}else {
								resultat.add(res);
								return fin;
							}
						}
					}catch(Exception e){}
					try{
						if(g.testerDeplacement(i,i,i,y,y+1,y+2) && !fin) {
							this.g.changerVal(i,i,i,y,y+1,y+2);
							fin = this.resoudreSoloNoble(billes-1);
							if(!fin) {
								this.g.retourArriere(i,i,i,y,y+1,y+2);
							}else {
								resultat.add(res);
								return fin;
							}
						}
					}catch(Exception e){}
					try{
						if(g.testerDeplacement(i,i-1,i-2,y,y,y) && !fin) {
							this.g.changerVal(i,i-1,i-2,y,y,y);
							fin = this.resoudreSoloNoble(billes-1);
							if(!fin) {
								this.g.retourArriere(i,i-1,i-2,y,y,y);
							}else {
								resultat.add(res);
								return fin;
							}
						}
					}catch(Exception e){}
					try{
						if(g.testerDeplacement(i,i+1,i+2,y,y,y) && !fin) {
							this.g.changerVal(i,i+1,i+2,y,y,y);
							fin = this.resoudreSoloNoble(billes-1);
							if(!fin) {
								this.g.retourArriere(i,i+1,i+2,y,y,y);
							}else {
								resultat.add(res);
								return fin;
							}
						}
					}catch(Exception e){}

				}
			}
		}
		return fin;
	}
	

	/**
	 * Methode afficher Resultat
	 */
	public void afficherResultat() {
		for(int i = this.resultat.size()-1; i >= 0; i--) {
			System.out.println(this.resultat.get(i));
		}
	}
	
	
	/**
	 * Methode ToString
	 * 
	 * @return String s, le tablier actuel
	 */
	public String toString() {
		String s = "";
		for(int i = 0; i < this.g.getHauteur(); i++) {
			for(int y = 0; y < this.g.getLargeur(); y++) {
				s += g.getTab()[i][y];
			}
			s+="\n";
		}
		return s;
	}

	
	/**
	 * La methode main
	 *
	 * @param args les arguments
	 */
	public static void main(String[] args) throws IOException {
		File f;
		
		if(args.length == 0) {
			f = new File("src/tablier1.txt"); 
		}else {
			String tablier = "src/" + args[0] + ".txt";
			f = new File(tablier); 
		}
		
		Grille g = new Grille(f);
		     
		SoloNoble s = new SoloNoble(g);
		
		s.resoudreSoloNoble(g.getNbBilles());
		s.afficherResultat();
	}

}
