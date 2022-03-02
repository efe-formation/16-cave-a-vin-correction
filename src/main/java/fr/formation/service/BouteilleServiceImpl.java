package fr.formation.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import fr.formation.entity.Bouteille;
import fr.formation.repository.BouteilleDao;

@Service
public class BouteilleServiceImpl implements BouteilleService {

	
	private BouteilleDao dao;

	// @Autowired
	public BouteilleServiceImpl(BouteilleDao dao) {
		System.out.println("Injection automatique de BouteilleDao dans BouteilleServiceImpl");
		this.dao = dao;
	}

	@Override
	public void ajouterBouteille(Bouteille b) throws ServiceException {
		if (b == null)
			throw new ServiceException("Bouteille null");
		if (b.getNom() == null || b.getNom().trim().length() == 0)
			throw new ServiceException("Le nom est obligatoire");
		if (b.getRegion() == null || b.getRegion().trim().length() == 0)
			throw new ServiceException("La region est obligatoire");
		if (b.getRobe() == null || b.getRobe().trim().length() == 0)
			throw new ServiceException("La robe est obligatoire");
		if (b.getNbBouteilles() == null || b.getNbBouteilles() < 0)
			throw new ServiceException("Le nombre de bouteilles doit etre positif");

		if (b.getNote() != null && (b.getNote() < 1 || b.getNote() > 10))
			throw new ServiceException("La note doit être comprise entre 1 et 10");

		dao.save(b);
	}

	@Override
	public void modifierBouteille(Bouteille b) throws ServiceException {
		if (b == null)
			throw new ServiceException("Bouteille null");
		
		if (b.getId() == 0) {
			throw new ServiceException("La bouteille doit exister");
		}
		if (b.getNom() == null || b.getNom().trim().length() == 0)
			throw new ServiceException("Le nom est obligatoire");
		if (b.getRegion() == null || b.getRegion().trim().length() == 0)
			throw new ServiceException("La region est obligatoire");
		if (b.getRobe() == null || b.getRobe().trim().length() == 0)
			throw new ServiceException("La robe est obligatoire");
		if (b.getNbBouteilles() == null || b.getNbBouteilles() < 0)
			throw new ServiceException("Le nombre de bouteilles doit etre positif");

		if (b.getNote() != null && (b.getNote() < 1 || b.getNote() > 10))
			throw new ServiceException("La note doit être comprise entre 1 et 10");

		
		dao.save(b);
		
	}


	@Override
	public void supprimerBouteille(int id) throws ServiceException {
		dao.deleteById(id);
		
	}

	@Override
	public List<Bouteille> listerBouteilles() {
		return dao.findAll();
	}

	@Override
	public Bouteille trouverBouteille(int id) {
		Optional<Bouteille> opt =  dao.findById(id);
		return opt.isPresent() ? opt.get() : null;
	}

	@Override
	public void boire(int nb, int id) throws ServiceException {
		Bouteille b = trouverBouteille(id);
		if (b == null)
			throw new ServiceException("La bouteille n'existe pas");
		b.setNbBouteilles(b.getNbBouteilles() - nb);
		modifierBouteille(b);
		
	}

	@Override
	public void racheter(int nb, int id) throws ServiceException {
		Bouteille b = trouverBouteille(id);
		if (b == null)
			throw new ServiceException("La bouteille n'existe pas");
		b.setNbBouteilles(b.getNbBouteilles() + nb);
		modifierBouteille(b);
	}

	@Override
	public void noter(int note, int id) throws ServiceException {
		Bouteille b = trouverBouteille(id);
		if (b == null)
			throw new ServiceException("La bouteille n'existe pas");
		b.setNote(note);
		modifierBouteille(b);
	}

	@Override
	public void commenter(String comm, int id) throws ServiceException {
		Bouteille b = trouverBouteille(id);
		if (b == null)
			throw new ServiceException("La bouteille n'existe pas");
		b.setCommentaires(comm);
		modifierBouteille(b);
	}
	
	

}
