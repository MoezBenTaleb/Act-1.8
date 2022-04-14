

import java.util.ArrayList;

import java.util.Collections;

import java.util.Scanner;


public class PlayListeUI {



	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MusiqueImpl music1 = new MusiqueImpl("Billie Jean", "MJ", "interprete1", "POP");
		MusiqueImpl music2 = new MusiqueImpl("Godzilla","Eminem", "interprete2", "RAP");
		MusiqueImpl music3 = new MusiqueImpl("Keys to Imagination", "YANNI", "interprete3", "INSTRUMENTAL");

		MusiqueImpl music4 = new MusiqueImpl("maad city", "kendrick lamar", "interprete4", "RAP");
		MusiqueImpl music5 = new MusiqueImpl("freedom","pharell", "interprete5", "RNB");
		MusiqueImpl music6 = new MusiqueImpl("all about us", "Tatu", "interprete6", "RNB");

		ArrayList<MusiqueImpl> myList1 = new ArrayList<MusiqueImpl>() ;
		ArrayList<MusiqueImpl> myList2 = new ArrayList<MusiqueImpl>() ;
		
		PlayListeImpl PlayListe1=new PlayListeImpl("Best Music", "Hits",5,myList1);
		PlayListeImpl PlayListe2=new PlayListeImpl("Gold Music", "Hits",5,myList2);

		ArrayList<PlayListeImpl> arrayPlayListe = new ArrayList<PlayListeImpl>();
		arrayPlayListe.add((PlayListeImpl) PlayListe1);
		arrayPlayListe.add((PlayListeImpl) PlayListe2);
		
		PlayListe1.Ajouter(music1);
		PlayListe1.Ajouter(music2);
		PlayListe1.Ajouter(music3);


		PlayListe2.Ajouter(music4);
		PlayListe2.Ajouter(music5);
		PlayListe2.Ajouter(music6);
		Scanner sc = new Scanner(System.in); 
		
		
		System.out.println("Affichage de la play liste");
		for (PlayListeImpl playListeImpl : arrayPlayListe ) {
			System.out.println(playListeImpl.getList() + " ");
		System.out.println();
		}
			
		User utilisateur = new User("Moez","BEN TALEB","MBT",arrayPlayListe);
		
			
			String titre;
			System.out.println("donner le titre de la chanson recherchée : ");
			titre = sc.nextLine();
			MusiqueImpl test= utilisateur.rechercherMusiqueParTitre(myList1, titre);
			System.out.println(test);
			String auteur;
			System.out.println("\ndonner l'auteur de la chanson recherchée : ");
			auteur = sc.nextLine();
			MusiqueImpl test1=utilisateur.rechercherMusiqueParAuteur(myList2, auteur);
			System.out.println(test1);
	
			
			System.out.println("\nAffichage de la playList dans un ordre croissant et décroissant");
						
			Collections.sort(arrayPlayListe, User.ComparatorNomCroissant);
			System.out.println("\nAfficage de la play liste par nom dans l'ordre croissant \n");
			for (PlayListeImpl playlisteImpl : arrayPlayListe) {
				System.out.println(playlisteImpl.getNom() + " ");
			}
				Collections.sort(arrayPlayListe, User.ComparatorNomDecroissant);
				System.out.println("\nAfficage de la play liste par nom dans l'ordre décroissant \n");
					for (PlayListeImpl playlisteImpl1 : arrayPlayListe) {
						System.out.println(playlisteImpl1.getNom() + " ");
					}
					
			System.out.println("\ndonner la musique à supprimer : ");
			String musique = sc.nextLine();
			utilisateur.SupprimerMusique(myList1,musique);
			PlayListe1.afficherPlayListe();

	
}
}

