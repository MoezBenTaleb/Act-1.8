package TriFichiers;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class User {
private String nom;
private String prenom;
private String pseudo;
ArrayList<PlayListeImpl> list = new ArrayList<PlayListeImpl>();



public User(String nom, String prenom, String pseudo, ArrayList<PlayListeImpl> list) {
	super();
	this.nom = nom;
	this.prenom = prenom;
	this.pseudo = pseudo;
	this.list = list;
}


public String getNom() {
	return nom;
}

public void setNom(String nom) {
	this.nom = nom;
}

public String getPrenom() {
	return prenom;
}

public void setPrenom(String prenom) {
	this.prenom = prenom;
}

public String getPseudo() {
	return pseudo;
}

public void setPseudo(String pseudo) {
	this.pseudo = pseudo;
}


public ArrayList<PlayListeImpl> getList() {
	return list;
}


public void setList(ArrayList<PlayListeImpl> list) {
	this.list = list;
}

public void SupprimerMusique(List<MusiqueImpl> playlist, String Musique1) {
for(MusiqueImpl m: playlist) {
if(m.getTitre().equals(Musique1)) {
playlist.remove(m);
break;
}
}
}
public MusiqueImpl rechercherMusiqueParTitre(ArrayList<MusiqueImpl> array, String titre) {
	
	for (MusiqueImpl musiqueImpl : array) {
		if (musiqueImpl.getTitre().equalsIgnoreCase(titre)) {
			return musiqueImpl;
		}
	}
	return null;
}

public MusiqueImpl rechercherMusiqueParAuteur(ArrayList<MusiqueImpl> array, String auteur) {
	for (MusiqueImpl musiqueImpl : array) {
		if (musiqueImpl.getAutheur().equalsIgnoreCase(auteur)) {
			return musiqueImpl;
		}
	}
	return null;
}
public static Comparator <PlayListeImpl> ComparatorNomCroissant = new Comparator <PlayListeImpl> () {

	public int compare( PlayListeImpl e1, PlayListeImpl e2) {
		return e1.getNom().compareTo(e2.getNom());
	}
};

public static Comparator<PlayListeImpl> ComparatorNomDecroissant = new Comparator<PlayListeImpl>() {

	@Override
	public int compare(PlayListeImpl e1, PlayListeImpl e2) {
		return e2.getNom().compareTo(e1.getNom());
	}
};

}