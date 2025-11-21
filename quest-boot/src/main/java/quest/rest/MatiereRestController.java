package quest.rest;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import quest.model.Matiere;
import quest.service.MatiereService;
import quest.view.Views;

@RestController
@RequestMapping("/api/matiere")
public class MatiereRestController {
	
	 private final static Logger log = LoggerFactory.getLogger(MatiereRestController.class);
	 
	@Autowired
	MatiereService matiereSrv;


	@JsonView(Views.Matiere.class)
	@GetMapping
	public List<Matiere> allMatieres()
	{
		log.error("On recherche toutes les matieres");
		return matiereSrv.getAll();
	}

	@JsonView(Views.Matiere.class)
	@GetMapping("/{id}")
	public ResponseEntity<Matiere> ficheMatiere(@PathVariable Integer id, Matiere matiere) {
		Matiere m = matiereSrv.getById(id);
		log.error("On recherche la matiere{}",id);

		if (m == null) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok(m);
	}

	@PostMapping
	public Matiere ajoutMatiere(@RequestBody Matiere matiere)
	{
		return matiereSrv.create(matiere);
	}


	@JsonView(Views.Matiere.class)
	@PutMapping("/{id}")
	public Matiere modifierMatiere(@PathVariable Integer id,@RequestBody Matiere matiere)
	{
		matiere.setId(id);
		return (Matiere) matiereSrv.update(matiere);
	}


	@JsonView(Views.Matiere.class)
	@DeleteMapping("/{id}")
	public void supprimerMatiere(@PathVariable Integer id) {
		matiereSrv.deleteById(id);
	}
}
