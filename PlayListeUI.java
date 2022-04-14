package TriFichiers;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import java.util.Collections;

import java.util.Scanner;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import java.util.Collections;

import java.util.Scanner;


public class PlayListeUI {


	
	public static ArrayList<MusiqueImpl> storePlaylistFromFile(ArrayList<MusiqueImpl> playlist)  {
		
	
		
		
		System.out.println("Saving playlost to reading.txt");

		   try { 
			   
				File A=new File (System.getProperty("user.dir")+"\\src\\TriFichiers\\musics.txt");
				FileReader fileReader = new FileReader(A);
				BufferedReader reader = new BufferedReader (fileReader);
		  
		      String line = reader.readLine();

		      while(line != null) {

		         
		            System.out.println(line);

		           
		            line = reader.readLine();
		            
		           if(line != null) {
		        	   String[] music =   line.split(",");
			           
			           playlist.add(new MusiqueImpl(music[0],music[1], music[2], music[3]));	
		           }
		           
		           
		      }
		      
		      reader.close();
		    } 


		      catch (Exception e) {

		    	  	e.printStackTrace();


		      }

		     
		      
		      return playlist;

		  
		   
	}
	
	public static void storePlaylistToFile(ArrayList<MusiqueImpl> playlist)  {
		
		
		
		
		System.out.println("Saving playlost to save.txt");

		   try { 
			   
				File A=new File (System.getProperty("user.dir")+"\\src\\TriFichiers\\save.txt");
				FileWriter fileWriter = new FileWriter(A);
				BufferedWriter writer = new BufferedWriter (fileWriter);
		  
		 
		      
		      
		      for(MusiqueImpl music : playlist) {
		    	  
		    	  writer.write(music.getTitre() + ",");
		    	  writer.write(music.getAutheur() + ",");
		    	  writer.write(music.getInterprete() + ",");
		    	  writer.write(music.getGenre());
		    	  writer.newLine();
		      }
		     
		      
		      writer.close();
		    } 


		      catch (Exception e) {

		    	  	e.printStackTrace();


		      }

		     
		    

		  
		   
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MusiqueImpl music1 = new MusiqueImpl("Billie Jean", "MJ", "interprete1", "POP");
		MusiqueImpl music2 = new MusiqueImpl("Godzilla","Eminem", "interprete2", "RAP");
		MusiqueImpl music3 = new MusiqueImpl("Keys to Imagination", "YANNI", "interprete3", "INSTRUMENTAL");

		MusiqueImpl music4 = new MusiqueImpl("maad city", "kendrick lamar", "interprete4", "RAP");
		MusiqueImpl music5 = new MusiqueImpl("freedom","pharell", "interprete5", "RNB");
		MusiqueImpl music6 = new MusiqueImpl("all about us", "Tatu", "interprete6", "RNB");

		ArrayList<MusiqueImpl> musicList1 = new ArrayList<MusiqueImpl>() ;
		ArrayList<MusiqueImpl> musicList2 = new ArrayList<MusiqueImpl>() ;
		
		
		
		
	
		
		PlayListeImpl playList1=new PlayListeImpl("Best Music", "Hits",5,musicList1);
		PlayListeImpl playList2=new PlayListeImpl("Gold Music", "Hits",5,musicList2);

		ArrayList<PlayListeImpl> playlistList = new ArrayList<PlayListeImpl>();
		playlistList.add((PlayListeImpl) playList1);
		playlistList.add((PlayListeImpl) playList2);
		
		playList1.Ajouter(music1);
		playList1.Ajouter(music2);
		playList1.Ajouter(music3);


		playList2.Ajouter(music4);
		playList2.Ajouter(music5);
		playList2.Ajouter(music6);
		
		
		ArrayList<MusiqueImpl> allMusics = new ArrayList<MusiqueImpl>();
		allMusics.addAll(musicList1);
		allMusics.addAll(musicList2);
	
		
		Scanner sc = new Scanner(System.in); 
		
		
		System.out.println("Affichage de la play liste");
		for (PlayListeImpl playListeImpl : playlistList ) {
			System.out.println(playListeImpl.getList() + " ");
		System.out.println();
		}
			
		User utilisateur = new User("Moez","BEN TALEB","MBT",playlistList);
		
			
			String titre;
			System.out.println("donner le titre de la chanson recherch�e : ");
			titre = sc.nextLine();
			MusiqueImpl test= utilisateur.rechercherMusiqueParTitre(allMusics, titre);
			System.out.println(test);
			String auteur;
			System.out.println("\ndonner l'auteur de la chanson recherch�e : ");
			auteur = sc.nextLine();
			MusiqueImpl test1=utilisateur.rechercherMusiqueParAuteur(allMusics, auteur);
			System.out.println(test1);
	
			
			System.out.println("\nAffichage de la playList dans un ordre croissant et d�croissant");
						
			Collections.sort(playlistList, User.ComparatorNomCroissant);
			System.out.println("\nAfficage de la play liste par nom dans l'ordre croissant \n");
			for (PlayListeImpl playlisteImpl : playlistList) {
				System.out.println(playlisteImpl.getNom() + " ");
			}
				Collections.sort(playlistList, User.ComparatorNomDecroissant);
				System.out.println("\nAfficage de la play liste par nom dans l'ordre d�croissant \n");
					for (PlayListeImpl playlisteImpl1 : playlistList) {
						System.out.println(playlisteImpl1.getNom() + " ");
					}
					
			System.out.println("\ndonner la musique � supprimer : ");
			String musique = sc.nextLine();
			utilisateur.SupprimerMusique(allMusics,musique);
			
			
			
			storePlaylistFromFile(musicList1);
			storePlaylistToFile(musicList1);
			
			
			
			System.out.println(allMusics.toString());
	
}
}

