package com.simplilearn.screen;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.simplilearn.filehandler.FileHandler;

public class MainClass {
	
	public static Screen screen;
	
	
	public static void main(String[] args) {
		
		//===========Let's get the Screen properties=============================
		screen = new Screen("Virtual Key Project:: LockedMe.com ", "To navigate the application, Kindly use the integer mapped to each menu");
		screen.writeLine('=', 100);
		System.out.println();
		screen.displayMessage(screen.title.toUpperCase());
		screen.writeLine('=', 100);
		System.out.println();
		//scanner.next();
		
		screen.displayMessage("Developer\'s Name: DAVID OLAIDE TOBRISE");
		screen.displayMessage("Designation: FSD Master\'s Student");
		System.out.println(screen.instruction);
		//screen.displayMenuLinks();

		
		int i = 0;
		boolean flag = true;
		String fileName = "";
		String fileContent = "";
		String path = "";
		Scanner scanner =  new Scanner(System.in);
		while(flag) {
			screen.displayMenuLinks();
			try {
				i = scanner.nextInt();
				Scanner sc =  new Scanner(System.in);
				while(true) {
					if(i == 1) {
						AddFileScreen addFileScreen = new AddFileScreen("Add File","");
						addFileScreen.displayMessage(addFileScreen.title);
						//addFileScreen.displayMenuLinks();
						
						System.out.println("Enter file Name: ");
						//sc.next();
						fileName = sc.nextLine();
						path = "./records/"+fileName;
						System.out.println("Enter file content: ");
						fileContent = sc.nextLine(); 
						FileHandler fileHandler = new FileHandler(path, fileContent);
						fileHandler.createNewFile();
						System.out.println("File has been successfully created and Data Saved");
						//sc.close();
						break;
					}else if(i == 2) {
						Screen searchScreen = new SearchFileScreen("Search File","Kindly follow the instructions below: ");
						searchScreen.displayMessage(searchScreen.title);
						//searchScreen.displayMenuLinks();
						System.out.println("Enter file Name with extension(e.g .txt, .docx,..): ");
						fileName = sc.nextLine();
						path = "./records/"+fileName;
						File file = new File(path);
						if(file.exists()) {
							System.out.println("The contents of the File: "+fileName+" are displayed below :");
							try (BufferedReader reader =
					                new BufferedReader(new FileReader(new File(path)))) {
					            reader.lines().forEach(System.out::println);
					        }
					        catch (IOException e) {
					            e.printStackTrace();
					        }
						}else {
							System.out.println("FNF:");
							System.out.println("Ensure to type in the file name accurately with its extension");
							//break;
						}
						//sc.close();
						break;
					}else if(i == 3) {
						Screen deleteScreen = new DeleteFileScreen("Delete File","");
						deleteScreen.displayMessage(deleteScreen.title);
						//deleteScreen.displayMenuLinks();
						try {
							System.out.println("Enter file Name: ");
							//sc.next();
							fileName = sc.nextLine();
							path = "./records/"+fileName;
							FileHandler fh = new FileHandler(path,"");
							boolean check = fh.deleteFile();
							System.out.println(check);
							if(check) {
								System.out.println("File was successfully deleted!");
							}else {
								System.out.println("FNF");
							}
						}catch(IOException e) {
							e.printStackTrace();
						}
						
						//sc.close();
						break;
					}else if(i == 4) {
						//List all files
						Screen listOrder = new ListFilesInOrder("File List","");
						listOrder.displayMessage(listOrder.title);
						System.out.println("Kindly Specify in which order you want the Lists(asc or desc)");
						String sortOrder = sc.nextLine();
						path = "./records";
						FileHandler fileHandler = new FileHandler(path,"");
						fileHandler.displaySortedFileList(sortOrder);
						
						//System.out.println("Here is listing all the files");
						break;
					}else if(i == 5) {
						//exit
						System.out.println("Exiting the application");
						flag = false;
						System.exit(0);
					}else {
						break;
					}
						
				}
				
			}catch(InputMismatchException e) {
				scanner.next();
				System.out.println("Kindly input input integers found on the menu links to proceed");
			}
		}
		
		
			
		
		
		//Scanner scanner = null;
		//String str = homeScreen.inputAction(scanner);
		//System.out.println(str);
		
		//if(str == valueOf(str))
		
	}
	
	/*
	public static int readMenuInteger() {
		while(true) {
			try {
				return scanner.nextInt();
			}catch(InputMismatchException e) {
				scanner.next();
				System.out.println("Kindly input input integers found on the menu links to proceed");
			}
		}
	}
	*/
	

}
