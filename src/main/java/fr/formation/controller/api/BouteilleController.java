package fr.formation.controller.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.formation.entity.Bouteille;
import fr.formation.service.BouteilleService;
import fr.formation.service.ServiceException;

@RestController
@RequestMapping("/cave")
//@CrossOrigin(origins = {"192.154.32.21", "www.monserveur.com:8180"})
@CrossOrigin(origins = "*")
public class BouteilleController {

	@Autowired
	private BouteilleService bs;
	
	@GetMapping("/liste")
	public List<Bouteille> getBouteilles(){
		
		return bs.listerBouteilles();
	}
	
	
	@PostMapping("/ajout")
	public ResponseEntity<String> postBouteille(@RequestBody Bouteille b) {
		try {
			bs.ajouterBouteille(b);
			
			return new ResponseEntity<String>(HttpStatus.OK);
		} catch (ServiceException e) {
			return new ResponseEntity<String>("Erreur lors de l'ajout de le bouteille : " + e.getMessage(), HttpStatus.CONFLICT);
		}
	}
	
	@PutMapping("/modif")
	public ResponseEntity<String> putBouteille(@RequestBody Bouteille b) {
		try {
			bs.modifierBouteille(b);
			
			return new ResponseEntity<String>(HttpStatus.OK);
		} catch (ServiceException e) {
			return new ResponseEntity<String>("Erreur lors de la modification de le bouteille : " + e.getMessage(), HttpStatus.CONFLICT);
		}
	}
	
	@DeleteMapping("/supp/{id}")
	public ResponseEntity<String> deleteBouteille(@PathVariable("id") int id) {
		try {
			bs.supprimerBouteille(id);
			
			return new ResponseEntity<String>(HttpStatus.OK);
		} catch (ServiceException e) {
			return new ResponseEntity<String>("Erreur lors de la suppression de le bouteille : " + e.getMessage(), HttpStatus.CONFLICT);
		}
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<Bouteille> getBouteille(@PathVariable("id") int id){
		
		Bouteille b = bs.trouverBouteille(id);
		if (b != null)
			return new ResponseEntity<Bouteille>(b, HttpStatus.OK); 
		else
			return new ResponseEntity<Bouteille>(HttpStatus.CONFLICT);

	}

	
	@GetMapping("/boire/{nb}/{id}")
	public ResponseEntity<String> boire(@PathVariable("nb") int nb, @PathVariable("id") int id){
		
		try {
			bs.boire(nb, id);;
			
			return new ResponseEntity<String>(HttpStatus.OK);
		} catch (ServiceException e) {
			return new ResponseEntity<String>("Erreur lors de la modification de le bouteille : " + e.getMessage(), HttpStatus.CONFLICT);
		}
	}


	
	@GetMapping("/racheter/{nb}/{id}")
	public ResponseEntity<String> racheter(@PathVariable("nb") int nb, @PathVariable("id") int id){
		
		try {
			bs.racheter(nb, id);
			
			return new ResponseEntity<String>(HttpStatus.OK);
		} catch (ServiceException e) {
			return new ResponseEntity<String>("Erreur lors de la modification de le bouteille : " + e.getMessage(), HttpStatus.CONFLICT);
		}
	}

	
	@GetMapping("/noter/{note}/{id}")
	public ResponseEntity<String> noter(@PathVariable("note") int note, @PathVariable("id") int id){
		
		try {
			bs.noter(note, id);
			
			return new ResponseEntity<String>(HttpStatus.OK);
		} catch (ServiceException e) {
			return new ResponseEntity<String>("Erreur lors de la modification de le bouteille : " + e.getMessage(), HttpStatus.CONFLICT);
		}
	}
	
	@GetMapping("/commenter/{comm}/{id}")
	public ResponseEntity<String> commenter(@PathVariable("comm") String comm, @PathVariable("id") int id){
		
		try {
			bs.commenter(comm, id);
			
			return new ResponseEntity<String>(HttpStatus.OK);
		} catch (ServiceException e) {
			return new ResponseEntity<String>("Erreur lors de la modification de le bouteille : " + e.getMessage(), HttpStatus.CONFLICT);
		}
	}

}
