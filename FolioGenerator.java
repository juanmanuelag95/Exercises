import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.Scanner;

class FolioOld extends Folio{

	@Override
	public void Generate() {
		if (this.folio != "") {
			this.folio = "";
		}
		this.GenerateFolioParts(9);
		this.folio += "-";
		this.GenerateFolioParts(8);
		this.folio += "-";
		this.GenerateFolioParts(7);
	}
	
}

class FolioNew extends Folio{

	@Override
	public void Generate() {
//		System.out.println("Generate New");
		if (this.folio.length() != 3) {
			this.folio = "";
		}
		this.GenerateFolioParts(9);
		this.folio += "-";
		this.GenerateFolioParts(8);
		this.folio += "-";
		this.GenerateFolioParts(7);
	}
	
}

public class FolioGenerator {
	public static void readFolios(Hashtable<String, Integer> h) {
		// The name of the file to open.
        String fileName = "temp.txt";

        // This will reference one line at a time
        String line = null;

        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader = 
                new FileReader(fileName);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = 
                new BufferedReader(fileReader);

            while((line = bufferedReader.readLine()) != null) {
//                System.out.println(line);
                h.put(line, 1);
            }   
            
            // Always close files.
            bufferedReader.close();         
        }
        catch(FileNotFoundException ex) {
            System.out.println(
                "Unable to open file '" + 
                fileName + "'");    
//            ex.printStackTrace();
        }
        catch(IOException ex) {
            System.out.println(
                "Error reading file '" 
                + fileName + "'");                  
            // Or we could just do this: 
            // ex.printStackTrace();
        }
	}
	

	
	public static void main(String args[]) {
		Scanner reader = new Scanner(System.in);
		System.out.println("Which version Old(1) or New(2)?");
		Hashtable<String, Integer> hash = new Hashtable<String, Integer>();
		int option = reader.nextInt();
//		reader.close();
		boolean status = false;
		String ISO = "";
		ArrayList<String> statesISOFormat = new ArrayList<String>();
		statesISOFormat.addAll(Arrays.asList("AGU","BCN","BCS","CAM","CHP","CHH","CMX",
											 "COA","COL","DUR","GUA","GRO","HID","JAL",
											 "MEX","MIC","MOR","NAY","NLE","OAX","PUE",
											 "QUE","ROO","SLP","SIN","SON","TAB","TAM",
											 "TLA","VER","YUC","ZAC"));
//		System.out.print(statesISOFormat);
		readFolios(hash);
		
		switch(option) {
			case 1:
				FolioOld oFolio = new FolioOld();
				do {
					oFolio.Generate();
					status = hash.containsKey(oFolio.folio);
				} while (status != false);
				oFolio.writeFolio();
				System.out.println("Folio: " + oFolio.folio);
				break;
			case 2:
				FolioNew nFolio = new FolioNew();
				do {
					do {
						System.out.println("Give your State ISO: ");
						ISO = (reader.next()); 
						if(!statesISOFormat.contains(ISO)) {
							System.out.println("Incorrect ISO");
						}
					} while (!statesISOFormat.contains(ISO));
					nFolio.folio += ISO;
			    	nFolio.Generate();
					status = hash.containsKey(nFolio.folio);
				} while (status != false);
				nFolio.writeFolio();
				break;
			default:
				System.out.println("Use valid option");
		}
	}
}