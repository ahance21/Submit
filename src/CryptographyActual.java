
import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;
public class CryptographyActual
{
public static void main(String[] filename) throws IOException
{
Scanner user = new Scanner(System.in);
System.out.println("Would you like to encrypt, decrypt, or crack a file: ");
String input = user.nextLine();
System.out.println("What is the name of the file: ");
Scanner fileNameScan = new Scanner(System.in);
String fileName = fileNameScan.nextLine();
File file = new File(fileName);
Scanner fileRead = new Scanner(file);
Scanner corp = new Scanner(System.in);
if (input.equals("encrypt")) {
System.out.println("What method would you like to use (c for ceaser, p for permutation): ");
String answercorp = corp.nextLine();
if(answercorp.equals("p"))
{
char[] lowerEncrypt = lowerRandom();
char[] upperEncrypt = UpperRandom();
while (fileRead.hasNextLine()) {
String line = fileRead.nextLine();
System.out.println(line);
for (int i = 0; i < line.length(); i++)
{
int a = (int) line.charAt(i);
int encryptedVal;
if(a >=65 && a <=90)
{
encryptedVal = upperEncrypt[a - 65];
}
else
{
encryptedVal = lowerEncrypt[a - 97];
}
System.out.print((char)encryptedVal);
}
}
}
else if(answercorp.equals("c"))
{
System.out.println("How many places should the alphabet shift by: ");
int eord = user.nextInt();
while (fileRead.hasNextLine()) {
String line = fileRead.nextLine();
System.out.println(line);
for (int i = 0; i < line.length(); i++) {
int a = (int) line.charAt(i);
int encryptedVal = a - eord;
if (encryptedVal < 65 && (a >= 65 && a <= 90)) {
a += 26;
} else if (encryptedVal < 97 && (a >= 97 && a <= 122)) {
a += 26;
}
{
}
char encrypt1 = (char) ((char) a - eord);
System.out.println(encrypt1);
}
}
}
} else if (input.equals("decrypt")) {
System.out.println("Which method would you like to use? (c for caesar or p for permutative: ");
String answercorp = corp.nextLine();
if(answercorp.equals("p"))
{
System.out.println("Please enter an alphabet (permutated) to use for decryption: ");
String decryptalpha = corp.nextLine();
char arrdalpha[] = new char[26];
for(int i = 0; i < 26; i++)
{
arrdalpha[i] = decryptalpha.charAt(i);
}
while (fileRead.hasNextLine()) {
String line = fileRead.nextLine();
System.out.println(line);
char[] arrline = new char[line.length()];
for(int i = 0; i < line.length(); i++)
{
int linechar = line.charAt(i);
for( int k = 0; k < arrdalpha.length; k++)
{
if(linechar == arrdalpha[k])
{
int foundAt = k;
char decodedChar = (char) (foundAt+97);
System.out.print(""+decodedChar);
}
}
}
}
}
else if(answercorp.equals("c"))
{
System.out.println("How many places should the alphabet shift by: ");
int eord = user.nextInt();
while (fileRead.hasNextLine()) {
String line = fileRead.nextLine();
System.out.println(line);
for (int i = 0; i < line.length(); i++) {
int a = (int) line.charAt(i);
int decryptedVal = a + eord;
if (decryptedVal > 90 && (a >= 65 && a <= 90)) {
a -= 26;
} else if (decryptedVal > 122 && (a >= 97 && a <= 122)) {
a -= 26;
}
char encrypt1 = (char) ((char) a + eord);
System.out.println(encrypt1);
}
}
}
else if (input.equals("crack")) {
for (int i = 1; i <= 25; i++) {
Scanner fileReadCrack = new Scanner(file);
while (fileReadCrack.hasNextLine()) {
String line = fileReadCrack.nextLine();
System.out.println(line);
for (int j = 0; j < line.length(); j++) {
int a = (int) line.charAt(j);
int crackVal = a + i;
if (crackVal < 65 && (a >= 65 && a <= 90)) {
a += 26;
} else if (crackVal < 97 && (a >= 97 && a <= 122)) {
a += 26;
}
char encrypt1 = (char) ((char) a + i);
System.out.println(encrypt1);
}
}
System.out.println("Does the code look right: ");
String crack = user.nextLine();
if (crack.equals("yes"))
System.exit(0);
}
}
}
}
public static char[] UpperRandom()
{
char[] encrypted = new char[26];
int[] usedNumbers = new int[26];
Random rand = new Random();
int successCount = 0;
while(successCount <26)
{
// Obtain a number between [0 - 49].
int n = rand.nextInt(26);
if(usedNumbers[n] == 0 )
{
int randonChar = 65 + n;
usedNumbers[n] = 1;
encrypted[successCount] = (char)randonChar;
successCount++;
}
else
continue;
}
System.out.println("Encrypted" + new String(encrypted));
return encrypted;
}
public static char[] lowerRandom()
{
char[] encrypted = new char[26];
int[] usedNumbers = new int[26];
Random rand = new Random();
int successCount = 0;
while(successCount <26)
{
// Obtain a number between [0 - 49].
int n = rand.nextInt(26);
if(usedNumbers[n] == 0 )
{
int randonChar = 97 + n;
usedNumbers[n] = 1;
encrypted[successCount] = (char)randonChar;
successCount++;
}
else
continue;
}
System.out.println("Encrypted" + new String(encrypted));
return encrypted;
}
}
