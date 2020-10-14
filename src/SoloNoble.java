
public class SoloNoble {
	
	private Grille g;
	
	public SoloNoble(String args) {
		if(args != null) {
			this.g = new Grille(args);
		}else {
			this.g = new Grille(null);
		}
		
	}
	
	public boolean resoudreSoloNoble(int billes) {
		Boolean fin = false;
		if(billes == 0) {
			fin = true;
		}else {
			for(int i = 0; i < this.g.getHauteur(); i++) {
				for(int y = 0; y < this.g.getLargeur(); y++) {
					if(g.getTab()[i][y-1] == "o" && g.getTab()[i][y-2] == ".") {
						this.g.changerVal(i,i,i,y,y-1,y-2);
						fin = this.resoudreSoloNoble(billes-1);
					}
					if(g.getTab()[i][y+1] == "o" && g.getTab()[i][y+2] == ".") {
						this.g.changerVal(i,i,i,y,y+1,y+2);
						fin = this.resoudreSoloNoble(billes-1);
					}
					if(g.getTab()[i-1][y] == "o" && g.getTab()[i-2][y] == ".") {
						this.g.changerVal(i,i-1,i-1,y,y,y);
						fin = this.resoudreSoloNoble(billes-1);
					}
					if(g.getTab()[i+1][y] == "o" && g.getTab()[i+2][y] == ".") {
						this.g.changerVal(i,i+1,i+2,y,y,y);
						fin = this.resoudreSoloNoble(billes-1);
					}
				}
			}
		}
		return fin;
	}
	
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
	
	public static void main(String[] args) {
		SoloNoble s = new SoloNoble(args[0]);
	}
	
}
