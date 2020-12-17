package tn.enig.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import tn.enig.dao.InterfaceGestionLivre;
import tn.enig.model.Livre;

@CrossOrigin("*")
@RestController
public class ServiceRest {
	@Autowired
	private InterfaceGestionLivre daol;
	
	public void setDaol(InterfaceGestionLivre daol) { this.daol = daol;}
	
	@GetMapping("/listeLivre")
	public List<Livre> fct1(){
		return (List<Livre>) daol.findAll();
		
	}
	
	@PostMapping("/addLivre")
	public void fct2(@RequestBody Livre l) {
		daol.save(l);
	}
	@DeleteMapping("/delLivre/{id}")
	public void fct3(@PathVariable("id") int id) {
		daol.deleteById(id);
	}
	@PutMapping("/updateLivre")
	public void fct4(@RequestBody Livre l) {
		daol.save(l);
		
	}
	@GetMapping("/livreById/{id}")
	public Optional<Livre> fct5 (@PathVariable("id") int id) {
		return daol.findById(id);
	}
	

}
