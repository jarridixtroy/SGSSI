
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger; 
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest; 
import java.security.NoSuchAlgorithmException;


public class codificator {
	
	public static String readtxt(File txt) throws IOException{
		BufferedReader br = new BufferedReader(new FileReader(txt));
		  
		  String st="hola";
		  String mensaje="";
		  
		while ((st = br.readLine()) != null) {
				mensaje=mensaje+st;
			  }
		return mensaje;
	} 

	 public static byte[] getSHA(String input) throws NoSuchAlgorithmException
	    { 
	        // Static getInstance method is called with hashing SHA 
	        MessageDigest md = MessageDigest.getInstance("SHA-256"); 
	  
	        // digest() method called 
	        // to calculate message digest of an input 
	        // and return array of byte
	        return md.digest(input.getBytes(StandardCharsets.UTF_8)); 
	    }
	 public static String toHexString(byte[] hash)
	    {
	        // Convert byte array into signum representation 
	        BigInteger number = new BigInteger(1, hash); 
	  
	        // Convert message digest into hex value 
	        StringBuilder hexString = new StringBuilder(number.toString(16)); 
	  
	        // Pad with leading zeros
	        while (hexString.length() < 32) 
	        { 
	            hexString.insert(0, '0'); 
	        } 
	  
	        return hexString.toString(); 
	    }
	// Driver code 
	    public static void main(String args[]) throws IOException
	    { 
	        try 
	        {
	            System.out.println("for the txt :"); 
	            File file = new File("C:\\Users\\xabia\\Downloads/SGSSI-21.CB.01.txt");  
	            String s1= readtxt(file);
	            System.out.println(s1);
	            String s2= new String("hola");
	            Integer i =0;
	            
	            while (true){
	            	s1=s1.concat(i.toString());
	            	s2= toHexString(getSHA(s1));
	            	System.out.println(i);
	            	if(s2.substring(1,1)=="0") {
	            		break;
	            	}
	            	i++;
	            }
	            
	            
	            System.out.println("\n"+"Hash code:");
	            System.out.println(s2); 
	  
	            
	        }
	        // For specifying wrong message digest algorithms 
	        catch (NoSuchAlgorithmException e) { 
	            System.out.println("Exception thrown for incorrect algorithm: " + e); 
	        } 
	    } 
}
