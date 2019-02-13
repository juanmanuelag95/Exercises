import java.io.*;
import java.util.Hashtable;
import java.util.Scanner;

class FolioOld extends Folio{

	@Override
	public void Generate() {
		if (this.folio != "") {
			this.folio = "";
		}
		this.GenerateFolioParts(1);
//		this.folio += "-";
//		this.GenerateFolioParts(8);
//		this.folio += "-";
//		this.GenerateFolioParts(7);
	}
	
}

class FolioNew extends Folio{

	@Override
	public void Generate() {
		System.out.println("Generate New");
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
		reader.close();
			
		switch(option) {
			case 1:
				boolean status = false;
				readFolios(hash);
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
				nFolio.Generate();
				break;
			default:
				System.out.println("Use valid option");
		}
	}
}