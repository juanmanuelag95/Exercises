import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.Scanner;

// class for old type of folio
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

//class for new type of folio
class FolioNew extends Folio{

	@Override
	public void Generate() {
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
	
	//function for read and store all folios on the temp file
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
                h.put(line, 1);
            }   
            
            // Always close files.
            bufferedReader.close();         
        }
        catch(FileNotFoundException ex) {
            System.out.println(
                "Unable to open file '" + 
                fileName + "'");    
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
		boolean status = false;
		String ISO = "";
		ArrayList<String> statesISOFormat = new ArrayList<String>();
		// list of available ISO
		statesISOFormat.addAll(Arrays.asList("AGU","BCN","BCS","CAM","CHP","CHH","CMX",
											 "COA","COL","DUR","GUA","GRO","HID","JAL",
											 "MEX","MIC","MOR","NAY","NLE","OAX","PUE",
											 "QUE","ROO","SLP","SIN","SON","TAB","TAM",
											 "TLA","VER","YUC","ZAC"));
		// read all folios from the existing file
		readFolios(hash);
		switch(option) {
			case 1:
				FolioOld oFolio = new FolioOld();
				// check if folio all ready exist if don't
				// write on the temp file
				do {
					oFolio.Generate();
					status = hash.containsKey(oFolio.folio);
				} while (status != false);
				oFolio.writeFolio();
				System.out.println("Folio: " + oFolio.folio);
				break;
			case 2:
				FolioNew nFolio = new FolioNew();
				// check if folio all ready exist if don't
				// write on the temp file
				do {
					do {
						// check if the given ISO is on the list 
						// and ask for a correct one
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