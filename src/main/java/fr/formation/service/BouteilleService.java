package fr.formation.service;

import java.util.List;

import fr.formation.entity.Bouteille;

public interface BouteilleService {

	void ajouterBouteille(Bouteille b) throws ServiceException;
	void modifierBouteille(Bouteille b) throws ServiceException;
	void supprimerBouteille(int id) throws ServiceException;
	
	List<Bouteille> listerBouteilles();

	Bouteille trouverBouteille(int id);
	
	void boire(int nb, int id) throws ServiceException;
	void racheter(int nb, int id) throws ServiceException;
	void noter(int note, int id) throws ServiceException;
	void commenter(String comm, int id) throws ServiceException;
}
