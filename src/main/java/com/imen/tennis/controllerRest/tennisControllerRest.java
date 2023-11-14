package com.imen.tennis.controllerRest;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.imen.tennis.entities.WTA_Tour;
import com.imen.tennis.services.TennisServices;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class tennisControllerRest {
	@Autowired
	TennisServices tennisService;
	@GetMapping
	public List<WTA_Tour> getAllWTA_Tour() {
		return tennisService.getAllWTA_Tour();
	 } 
	
	@GetMapping("/{id}")
	public WTA_Tour getWTA_TourById(@PathVariable("id") Long id) { return tennisService.getWTA_Tour(id);
	}
	
	@PostMapping()
	public WTA_Tour createWTA_Tour(@RequestBody WTA_Tour t) {
	return tennisService.saveWTA_Tour(t);
	}
	
	@PutMapping()
	public WTA_Tour updateWTA_Tour(@RequestBody WTA_Tour t) {
	return tennisService.updateWTA_Tour(t);
	}
	
	@DeleteMapping("/{id}")
	public void deleteWTA_Tour(@PathVariable("id") Long id)
	{
	tennisService.deleteWTA_TourById(id);
	}
	
	@GetMapping("/prodscat/{idstats}")
	public List<WTA_Tour> getProduitsByCatId(@PathVariable("idstats") Long idStat) {
	return tennisService.findByStatsIdStat(idStat);
	}
	
	@RequestMapping(value="/prodsByName/{name}",method = RequestMethod.GET)
	public List<WTA_Tour> findByNomProduitContains(@PathVariable("name") String name) {
	return tennisService.findByNameTourContains(name);
	}
	
	
	
	
}
