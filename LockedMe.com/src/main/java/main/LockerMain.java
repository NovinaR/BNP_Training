package main;

import java.util.Collections;
import java.util.List;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import bo.LockerBO;
import boimpl.LockerBOImpl;
import model.Locker;

public class LockerMain {

	public static void main(String[] args) throws IOException {
		int choice,choice2;
		String filename;
		int fileno=1;
		Scanner sc=new Scanner(System.in);
		
		LockerBO lockerbo=new LockerBOImpl();
		
		File dir = new File("Root Directory");
		dir.mkdir();
		
		String[] filelist=dir.list();
		
		do {
		System.out.println("\nHello \nWelcome to Locker Pvt");
		System.out.println("This application is developed by \nNovina Rayudu");
		System.out.println("\nNote: You can find the actions you perform getting reflected to HashMap");
		System.out.println("\nPlease select the options which you want to try");
		System.out.println("1. Get list of files sorted in Ascending order");
		System.out.println("2. Perform Operations on file");
		System.out.println("3. Close the app"
				+ "lication");
		
		choice=Integer.parseInt(sc.nextLine());
		
		switch(choice) {
		
		case 1:
			List<String> lockerList=lockerbo.getallfiles();
			Collections.addAll(lockerList, filelist);
			Collections.sort(lockerList, new ignorecase()); 
			if(lockerList!=null && lockerList.size()>0) {
				System.out.println("There are total "+lockerList.size()+" files in the directory named "+dir.getPath()+" \nDetails of the files as shown below");
				for(String l1:lockerList) {
					System.out.println(l1);
				}
			}else {
				System.out.println("Currently the directory is empty");
			}
			break;
			
		case 2:
			do {
			System.out.println("1. Add a file to the directory");
			System.out.println("2. Delete a file from the directory");
			System.out.println("3. Search for a file in the directory");
			System.out.println("4. Navigate back to Main menu");
			
			choice2=Integer.parseInt(sc.nextLine());
			switch(choice2) {
			case 1:
				System.out.println("Enter the name of your file");
				filename=sc.nextLine();
				File newfile=new File(dir,filename);
				if(!newfile.exists()) {
					newfile.createNewFile();
				}
				else {
					File nfile=new File(dir,filename+fileno);
					nfile.createNewFile();
					System.out.println("File already exist!! \nSaving your file with name "+nfile.getName());
				}
				System.out.println("Enter the data inside the file");
				String filedata=sc.nextLine();
				try(FileWriter fstream = new FileWriter(filename,true);
						  BufferedWriter out = new BufferedWriter(fstream);){
					out.write(filedata);
				}catch(IOException e) {
					System.out.println(e);
				}
				Locker locker=new Locker(filename,filedata);
				locker = lockerbo.createfile(locker);
				break;
				
			case 2:
				System.out.println("Enter the file name you want to delete");
				filename=sc.nextLine();
				System.out.println("Enter the data inside the file");
				String passdata=sc.nextLine();
				File delfile=new File(dir,filename);
				for(int i=0;i<filelist.length;i++) {
					if(delfile.exists() && filename.equals(filelist[i])) {
						System.out.println("File found at location "+delfile.getPath());
						delfile.delete();
					}
				}
				Locker lockerr=new Locker();
				locker = lockerbo.demo(lockerr);
				System.out.println("Enter the key from above to delelte the value from HashMap");
				int key=Integer.parseInt(sc.nextLine());
				Locker dellocker=new Locker(filename,passdata);
				dellocker = lockerbo.deletefile(key);
				break;
			
			case 3:
				System.out.println("Enter the file name to be searched");
				String sfile=sc.nextLine();
				File searchfile=new File(sfile);
				if(searchfile.exists()) {
					System.out.println("File Found at location "+searchfile.getPath());
				}else {
					System.out.println("Sorry File not present!!");
				}
				break;
				
			case 4:
				break;
			}
			}while(choice2!=4);
			
		case 3:
			System.out.println("Thankyou for using our application!! \nHope to see you back again:)");
			break;
			
		default:
			System.out.println("Sorry!!!! \nInvalid choice \nPlease try again");
			break;
		}
	
		}while(choice!=3);
	        
	}

}
