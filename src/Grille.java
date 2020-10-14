
public class Grille {

	public String[][] tab;
	
	public Grille(String args) {
		
	}
	
	public void creerGrille() {
		
	}
	
	public void changerVal(int i1, int i2, int i3, int y1, int y2, int y3) {
		this.tab[i1][y1] = ".";
		this.tab[i2][y2] = ".";
		this.tab[i3][y3] = "o";
	}
	
	public int getHauteur() {
		return this.tab.length;
	}
	
	public int getLargeur() {
		return this.tab[0].length;
	}
	
	public String[][] getTab(){
		return this.tab;
	}
}
