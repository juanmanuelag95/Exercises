import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Random;

public abstract class Folio {
	String folio;
	
	public abstract void Generate();
	
	Folio(){
		this.folio = "";
	}
	
	// function for generate parts of the folio
	// including the rules
	public void GenerateFolioParts(int n) {
		Random rand = new Random();	
		int oldDigit = 0;
		for (int i = 0; i < n; i++) {
			int digit = rand.nextInt(16);
			if (oldDigit >= 10  && digit >= 10) 
				this.folio += Integer.toHexString(rand.nextInt(10)).toUpperCase();
			else 
				this.folio += Integer.toHexString(digit).toUpperCase();
			oldDigit = digit;
		}
	}
	
	// write on the temp file, only correct folios
	public void writeFolio() {
        // The name of the file to open.
        String fileName = "temp.txt";

        try {
            // Assume default encoding.
            FileWriter fileWriter =
                new FileWriter(fileName, true);

            // Always wrap FileWriter in BufferedWriter.
            BufferedWriter bufferedWriter =
                new BufferedWriter(fileWriter);
	            bufferedWriter.newLine();
	            bufferedWriter.write(this.folio);
            bufferedWriter.close();
        }
        catch(IOException ex) {
            System.out.println(
                "Error writing to file '"
                + fileName + "'");
            // Or we could just do this:
            // ex.printStackTrace();
        }
	}
}