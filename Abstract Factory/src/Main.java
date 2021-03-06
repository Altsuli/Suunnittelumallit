import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

import vaatteet.*;

/**
 * 
 */

/**
 * @author ali_r
 *
 */
public class Main {
	
	
	public static void main(String[] args) {
		
		//bonus
		Properties p = new Properties();
		
		try {
			p.load(new FileInputStream("src/tehdas.properties"));
		}catch (IOException exception) {
            System.out.println("virhe properties lukemiseen");
            exception.printStackTrace();
            return;
        }
		
		String tehdas = p.getProperty("tehdas").toString();
		System.out.println(tehdas + " tehdas valittu");
		
		Set<Vaate> v = new HashSet();
		AbstractFactory VT = Tuottaja.haeTehdas(tehdas);
		
		v.add(VT.haeVaate("Housut"));
		v.add(VT.haeVaate("Keng�t"));
		v.add(VT.haeVaate("Lippis"));
		v.add(VT.haeVaate("Paita"));
		
		for(Vaate Vaate: v) {
			Vaate.pue();
		}
		
		Iterator<Vaate> iteraattori = v.iterator();
		System.out.println("Jasperilla on ");
		while(iteraattori.hasNext()) {
			Vaate Vaate = iteraattori.next();
			
			if(!iteraattori.hasNext()) {
			System.out.println(Vaate.toString() + " p��ll�.");
			}else {
				System.out.println(Vaate.toString() + " ja ");
			}
		}
		
		
	}

}
