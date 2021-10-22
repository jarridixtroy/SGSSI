import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

public class codificator2 extends codificator {

	private static final String FICHERO = "C:\\Users\\xabia\\Downloads/SGSSI-21.CB.04.txt";
	private static String mejorHash = "00000000000000000000000000000000";
	private static int num0s = 0;

	private static boolean esMejor(String hash) {
		System.out.println("estoy ejecutandome");
		System.out.println("el hash es:" + hash);
		int y = 0;
		for (int i = 0; i < hash.length()-1; i++) {
			if (hash.substring(0, i).equals(mejorHash.substring(0, i))) {
				y++;
			}
		}
		System.out.println(y);
		if (y > num0s) {
			num0s = y;
			return true;
		} else
			return false;

	}

	private static String getRandomHexString(int numchars) {
		Random r = new Random();
		StringBuffer sb = new StringBuffer();
		while (sb.length() < numchars) {
			sb.append(Integer.toHexString(r.nextInt()));
		}

		return sb.toString().substring(0, numchars);
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		try {
			System.out.println("for the txt :");
			File file = new File(FICHERO);
			String s1 = readtxt(file);
			System.out.println(s1);

			File file2 = new File("C:\\Users\\xabia\\Downloads/nuevoArchivo.txt");
			if (!file2.exists()) {
				file2.createNewFile();
			}
			String s2 = toHexString(getSHA(s1));
			String s3 = "0";
			int i = 0;
			long finish = System.currentTimeMillis() + 60000; // end time
			while (System.currentTimeMillis() < finish) {
				s3 = toHexString(getSHA(s1 + getRandomHexString(i)));
				if (esMejor(s3)) {
					s2 = s3;
				}
				i++;
			}

			System.out.println("\n" + "This is the input into the new file:");
			System.out.println(s1 + "\n" + getRandomHexString(8) + " " + "29" + s2);
			FileWriter fw = new FileWriter(file2);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(s1 + "\n" + getRandomHexString(8) + " " + "29" + s2);
			bw.close();

		}
		// For specifying wrong message digest algorithms
		catch (NoSuchAlgorithmException e) {
			System.out.println("Exception thrown for incorrect algorithm: " + e);
		}

	}

}
