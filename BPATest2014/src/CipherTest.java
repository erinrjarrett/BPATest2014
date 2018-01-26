import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CipherTest
{
	/**
	 * This is the main method that will read and write the files and
	 * it will also call the cipher class to convert the cipher.
	 */
	public static void main(String[] args) throws IOException
	{
		class Cipher
		{
			/**
			 * This method takes the ciphertext character and the key character and converts
			 * it to plain text.
			 * @param key a character of the key
			 * @param code a character of ciphertext
			 * @return <br />the plain text character
			 */
			public char convert(char key, char code)
			{
				return sub(key, code);
			}
			
			private char sub(char a, char b)
			{
				// calc a-b
				int ia = a, ib = b;
				if (ia <= ib)
					ia += 26;
				return (char) ('A' - 1 + (ia - ib));
			}
		}
		
		String fin = "";
		String fout = "";
		Cipher c = new Cipher();
		if (args.length < 2)
		{
			System.out.println("Usage Error: Not enough Arguments.");
			System.exit(0);
		}
		else
		{
			fin = args[0];
			fout = args[1];
		}
		try
		{
			BufferedReader br = new BufferedReader(new FileReader(fin));
			FileWriter fp = new FileWriter(fout);
			char convert;
			while (true)
			{
				String code = br.readLine(), key = br.readLine();
				if (code != null)
				{
					System.out.print(code + "/" + key + " = ");
					fp.write(code + "/" + key + " = ");
				}
				if (key == null)
					break;
				while (key.length() < code.length())
					key = key + key; // extra long
				for (int i = 0; i < code.length(); i++)
				{
					convert = c.convert(code.charAt(i), key.charAt(i));
					System.out.print(convert);
					fp.write(convert);
				}
				System.out.println("");
				fp.write("\n");
			}
			fp.close();
			br.close();
		}
		catch (FileNotFoundException e)
		{
			System.out.println(fin + " file not found");
		}
	}
	
}