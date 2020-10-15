import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class SoloNoble {

	private Grille g;

	public SoloNoble(Grille gr){
		this.g = gr;
	}

	public boolean resoudreSoloNoble(int billes) {
		Boolean fin = false;
		if(billes == 0) {
			fin = true;
		}else {
			for(int i = 1; i < this.g.getHauteur()-1; i++) {
				for(int y = 1; y < this.g.getLargeur()-1; y++) {
					this.toString();
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
		System.out.println(s);
		return s;
	}

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
	}

}
