/**
 * The class 'Cipher' provides options for user to select encryption, decryption or exit.
 * In addition, this class provides logics to encrypt and decrypt the contents of the file.
 * This class also provides a feature to read and write the text file.
 * 
 * For encryption, the program asks user to enter keyphrase to begin with. 
 * Keyphrase allows user to add space. Once the keyphrase is input, Cipher text is shown starting with keyphrase.
 * Once User enters the file name, it displays decrypted contents as well as writes the text file named'EncryptNewFile.txt'.
 * 
 * For decryption, user is also asked to enter keyphrase.
 * Once user enter the file name to be decypted, the program display the contents as well as write the file named'DecryptNewFile'.
 *  * 
 */

import java.io.*;
import java.util.*;

     public class Cipher 
     {
        private FileWriter encryptedNew; //stores fileWriter for writing encrypted message on to new file
 		private FileReader fileReadE; // stores FileReader for reading file for encryption given by user
		private FileWriter writeDecryptNew; // stores FileWriter for writing decrypted message on to new file
		private FileReader fileReadD; // stores FileReader for reading file for decryption given by user
		private String message_e=""; // stores message for encryption from file
		private String message_d=""; // stores message for decrypt from file
		private String encryptText=""; //stores final encrypted text
		private String DecryptText="";//stores final decrypted text
		private Scanner sc; //stores scanner for user input
		private char[] keys; //stores array of chars to individually parse through keyphrase
		private String Keyword=""; //stores keyword
		private String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";//stores alphabet for substitution cipher
		
		public Cipher() //Constructor. 
		{
			selectOption();// A method is called to select options
		}
		
		/**
		 * User can select an option (encrypt, decrypt, exit)
		 * with if~else , the method executes the option user selects.
		 */
		public void selectOption() 
		{
			{
				sc=new Scanner(System.in);
				System.out.println("[1].Encryption, [2].Decryption, [3].Exit");
				char response = sc.nextLine().charAt(0); //store only the first character of user input
							
				if( response=='1')//user wants to encrypt
					{
						System.out.println("Encryption Selected. \n");
						cipherList(); //it prints cipher text after asking for keyphrase
						readFile(); //it asks user for file and reads the message
						encryption(message_e); //it encrypts the contents
					}
				else if(response=='2') //user wants to decrypt
					{
						System.out.println("Decryption Selected. \n");					
						cipherList();
						readencryptedFile(); // it reads encrypted file
						decryption(message_d); //it encrypts the contents of the file
					}
				
				else if (response=='3')//user wants to exit
					{
						System.out.println("Exit program. \n");
						System.exit(0);//exits console
					}
				else
					{
						System.out.println("Invalid option.\n"); // user selects out of options.
						System.exit(0);
					}
			 }
		}
		
		/**
		 * this method provides the logic to encrypt a plaintext
		 * the range of uppercase letters is 65-90 in ASCII
		 * for letter, this method is casting to interger to compare to the number of ASCII.
		 * the code checks if the letter is in alphabet or not and decide whether it should kept in same place or substitued.
		 */
		public void encryption(String message_e)
		{
			message_e = message_e.toUpperCase(); // the contents converts to upper cases.
			for(int i=0; i < message_e.length(); i++)// parses through message
			{
				if((int)message_e.charAt(i) < 65 || (int)message_e.charAt(i) > 90) // check if the letter is not in alphabet
					{
					    this.encryptText+= message_e.charAt(i); // it the condition is met, don't convert and keep it in same place
					    
					} 
				else
					{
						int x = 0;
						for (int j=0;j<alphabet.length();j++) 
						{
							if(message_e.charAt(i)==alphabet.charAt(j))
								{
									encryptText+=Keyword.charAt(x);//adds substituted letter
								    break;
								}
							else
								{
									x++; 
								}
						}
					}
			}
		
			System.out.println("Encrypted Text: " + encryptText);
			this.encryptText= encryptText;
			generateEncryptedNewFile(); //generates file with encrypted message
		}
		
		/**
		 * This method provides a feature to decrypt ciphertext
		 * The range for uppercase letters is 65-90 in ASCII
		 * for letter, this method is casting to interger to compare to the number of ASCII.
		 * the code checks if the letter is in alphabet or not and decide whether it should kept in same place or reverse substitued letter
		 */
		public void decryption(String message_d)
		{
			
			message_d = message_d.toUpperCase(); // the contents converts to upper cases.
			
			String DecryptText="";
			 
			for(int i = 0; i < message_d.length(); i++) //loop through contents of the file.
			{
				if((int)message_d.charAt(i) < 65 || (int)message_d.charAt(i) > 90) //check if the letter is not in alphabet,
					{
					    DecryptText+= message_d.charAt(i); // if the condition is met, don't convert and keep in same place
					    
					} 
				else // if the letter is alphabet
				{
					int count=0; // initialize the variable for searching for the letter
					for (int j=0;j<alphabet.length();j++)
					{
						if(message_d.charAt(i)==Keyword.charAt(j)) // if the letter of keyphrase is identical to the one of the file
							{
								DecryptText+=alphabet.charAt(count);//reverses substituted letter
							    break; 
							}
						else
							{
								count++; // increase for the next letter
							}
					}
				}
			}
			
			System.out.println("Decrypted text:    "+ DecryptText.toLowerCase());
			this.DecryptText = DecryptText;
			generateDecryptNewFile(); //generates file for decrypted message
		}
		
		/**
		 * this method appends keyphrase with alphabet
		 * it also check if the keyphrase is valid and only contains Alphabet letters/space.
		 */
		public void cipherList()
			{
			   	String key = "";	    
				System.out.print("Enter Keyphrase:  ");
				key = sc.nextLine(); 
				keys=key.toCharArray(); //converts keyphrase to array of individual chars
				String Key2 = "";
				
				
				for (int i =0;i<keys.length;i++) {//Checks if the keyphrase is valid and only contains Alphabet letters/spaces
					if((keys[i] >='a' && keys[i]<='z') || (keys[i]>='A' && keys[i]<='Z') || keys[i]==' ')
						{
							if(keys[i] != ' ') // Allows space in the letter
								{
									Key2 += keys[i];//keeps space if it in the encrypted message
								}
						}
							else {System.out.println("The keyphrase is not valid, you must enter English alphabetical letters, or a space.");
							cipherList();//goes through method again until user enters correct keyphrase
					    }
				}
				key = Key2.toUpperCase(); // convert to uppercase letter
				
				
				for (int i = 0; i < key.length(); i++)
				{

					int x = i;
					for (int j = 0; j < key.length(); j++)
					{
						if (x == j)
							{
								continue; // keeps going through loop if letters are the same
							}
						else if 
						
						(key.charAt(i) == key.charAt(j)); // assign new letter if the letter are not the same.
						
					}
				}
				
				String phrase = ""; // initialize the variable
				for (int i =0; i<key.length();i++) //Generate alphabet with keyphrase;
						{
							phrase+=key.charAt(i);
						}
				for (int i=65;i<91;i++) // if the letter is alphabet 
						{
							phrase+=(char)(i); // add the letter 
						}
				
				for (int i=0;i<phrase.length();i++)
				{
					boolean found = false;
					for(int j=0;j<Keyword.length();j++)
						{
							if(phrase.charAt(i)==Keyword.charAt(j))
								{
									found=true;
									break;
								}
						}
					if (found ==false)
						{
							Keyword+=phrase.charAt(i);
						}
				}
				System.out.println("Cipher text: "+Keyword); //To verify cipher text combined with key phrase
			}
			
		/**
		 * this method provides a feature to read plaintext from the file.
		 * it asks the user for the file to decrypt until they provide a valid file
		 */ 
		
		public void readFile()
		{	
			boolean ask= true;
			while(ask) //keeps asking user for file name until they give a valid one
			{
				sc= new Scanner(System.in);
				
				System.out.println("Type the file name without the extension('.txt')   ");
				
				String filename=sc.nextLine().concat(".txt"); // concatenate extension for the text file
				
				
				File file= new File(filename); // file object is generated and the file is passed as an argument for constructor
				if(file.exists()) 
					{
					try // use try~ catch block for exception.
						{
								fileReadE = new FileReader(filename);
							    sc= new Scanner (fileReadE);
							    while(sc.hasNextLine()) // keep adding the letter until it has no more line.
								    {
								    	message_e=message_e.concat(sc.nextLine() + "\n");
								    }
							    ask=false; // it will stop while-loop.
								break;
						}
					catch (FileNotFoundException e)// if path provided did not exist
						{
							e.printStackTrace();
						}
						this.message_e = message_e;
					}
				else 
					{
						System.out.println("That file does not exist. Try again.");
						
					}
			}
		}
		
		/**
		 * This method provides a feature to create a new file for encryption.
		 * the new text file is generated at the same path
		 */
		public void generateEncryptedNewFile()
		{
			try // use try~ catch block for exception.
				{
				encryptedNew = new FileWriter("EncryptNewFile.txt");
				encryptedNew.write("E\n" + encryptText);// writes encrypted message to a new file named "EncryptNewFile.txt", with an 'E' to indicate it has been encrypted.
				encryptedNew.close();
				System.out.println("The Encrypted file has been generated.");
				} 
			catch (IOException e) 
				{
					System.out.println("There was an error. Try again. ");
					e.printStackTrace();
				}
		}
		
		/**
		 * This method provides a feature to read cipher text encrypted
		 * 
		 */
		public void readencryptedFile() 
		{
		boolean ask= true;
			while(ask) {
			sc= new Scanner(System.in);
			System.out.println("Type the file name without the extension('.txt')   ");
			String filename=sc.nextLine().concat(".txt");
			
				File file = new File(filename);
				if(file.exists()) {
				try {
					fileReadD = new FileReader(filename);
					sc= new Scanner (fileReadD);
					if(sc.nextLine().equals("E")) //checks if the file can be decrypted by searching for 'E' indicator
					{
					    while(sc.hasNextLine())
				        {
				    	message_d=message_d.concat(sc.nextLine() + "\n");
				    	
				        }
				        ask = false;
					}
					else
					{
					    System.out.println("This file cannot be decrypted.");

					}
				} catch (FileNotFoundException e) {//catch exception if file does not exist
				
					e.printStackTrace();
				}
				
				
				this.message_d=message_d;
				}
				else 
				{
				System.out.println("That file does not exist. Try again.");
					
				}
			
			}
		}
		
		/**
		 * Thi method provides a feature to create a new file with decrypted text
		 * It generates a file at the same path.
		 */
		public void generateDecryptNewFile()
		{
			try // use try~ catch block for exception.
				{
					writeDecryptNew = new FileWriter("DecryptNewFile.txt");
					writeDecryptNew.write(DecryptText);//generates a new file named "decryptnewfile.txt"
					writeDecryptNew.close(); // close file stream
					
					System.out.println("The Decrypted file has been generated.");
				}
			catch (IOException e)
				{	
				System.out.println("There was an error. Try again. ");
					e.printStackTrace();
				}
		}
     }