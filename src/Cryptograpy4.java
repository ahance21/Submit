
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Cryptograpy4 {

	public static void main(String[] args) throws IOException
	{
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Would you like to encrypt, decrypt, or crack a file?" );
		String encrypted = keyboard.nextLine();
		int shiftAmount = 0;
		String fileName = "";
		String encrypt = "false";
		if(encrypted.equalsIgnoreCase("encrypt"))
		{
			encrypt = "true";
			Scanner scan = new Scanner(System.in);
			System.out.print("How many places should it be shifted? ");
			shiftAmount = scan.nextInt();
			System.out.print("Enter a file name for encrypting: ");
			fileName = scan.nextLine();
		}
		else if(encrypted.equalsIgnoreCase("crack"))
		{
			encrypt = "crack";
			Scanner scan = new Scanner(System.in);
			System.out.print("Enter a file to crack ");
			fileName = scan.nextLine();
		}
		else
		{
			Scanner scan = new Scanner(System.in);
			System.out.print("How many places should it be shifted?");
			shiftAmount = scan.nextInt();
			System.out.print("Enter a file name to decrypt: ");
			fileName = scan.nextLine();
		}
			caesar_cipher(fileName,encrypt,shiftAmount);
	}

	 
public static String encrypt(String txt, int i)
{
	String endcode = "";
	
	for (int j=0; j<txt.length(); j++)
	{
		if(Character.isUpperCase(txt.charAt(j)) && !Character.isWhitespace(txt.charAt(j)))
		{
			char ch = (char) (((int)txt.charAt(j) + i - 65) % 26 + 65);
			endcode = endcode + ch;
		}
		else if (!Character.isWhitespace(txt.charAt(j)))
		{
			char ch = (char)(((int)txt.charAt(j) + i - 97) % 26 + 97);
			endcode = endcode + ch;
		}
		else {
			endcode = endcode + "";
		}
	}
	return endcode;
}



public static String caesar_cipher(String fileName, String encrypt, int shiftAmount) throws IOException
{
	   Scanner inputFile = new Scanner(new File (fileName + ".txt"));
	   String line = "";
	   while(inputFile.hasNext())
	   {
		   line = inputFile.nextLine();
	   }
	   
	   if (encrypt.equalsIgnoreCase("true"))
	   {
		   PrintWriter outputFile = new PrintWriter(fileName + "_ENC.txt");
		   outputFile.println( encrypt(line, shiftAmount));
		   outputFile.close();
		   System.out.print("Result written to " + fileName + "_ENC.txt");
				   
	   }
	   else if(encrypt.equalsIgnoreCase("false"))
	   {
		   
		   shiftAmount = 26 - shiftAmount;
		   PrintWriter outputFile = new PrintWriter(fileName + "_DEC.txt");
		   outputFile.println(encrypt(line, shiftAmount));
		   outputFile.close();
		   System.out.print("Result Written to " + fileName + "_DEC.txt");
	   }
	   else if(encrypt.equalsIgnoreCase("crack"))
	   {
		   for (int k = 1; k < 25; k++)
		   {
			   shiftAmount = 26 - k;
			   System.out.print(encrypt(line,shiftAmount));
			   Scanner scan = new Scanner(System.in);
			   System.out.println("Does the code look right?");
			   String answer = scan.nextLine();
			   if(answer.equalsIgnoreCase("yes"))
			   {
				   break;
			   }
			   
		   }
		   PrintWriter outputFile = new PrintWriter(fileName + "_DEC" + ".txt");
		   System.out.print("The result is written to " + fileName + "_DEC" + ".txt");
	   }
	   inputFile.close();
	   return "";
	   
	 
	 
}
}
