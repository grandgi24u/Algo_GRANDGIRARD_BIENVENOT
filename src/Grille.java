import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Grille {

	public String[][] tab;
	
	public Grille(String args) throws IOException {
		if(args == null) {
			 File f=new File("src/tablier1.txt");     //Creation of File Descriptor for input file
		     FileReader fr=new FileReader(f);   //Creation of File Reader object
		     BufferedReader br=new BufferedReader(fr);  //Creation of BufferedReader object
		     int c = 0;   
		     int i = 0;
		     while((c = br.read()) != -1) {
		            char character = (char) c;          //converting integer to char
		            System.out.println(character);
		     }
		     br.close();
		}
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
