package project.controllers; 

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import project.models.Costumer;
import project.services.CostumerService;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/costumers")
public class CostumerController {
	private final CostumerService costumerService;
	
	@GetMapping
	public List<Costumer> listCostumers() {
		return costumerService.listCostumers();
	}
	
	@GetMapping(value = "{id}")
	public Costumer getCostumerById(@PathVariable("id") UUID id) {
		return costumerService.getCostumerById(id);
	}
	
	@PostMapping
	public ResponseEntity<Costumer> saveNewCostumer(@RequestBody Costumer costumer) {
		
		Costumer savedCostumer = costumerService.saveNewCostumer(costumer);
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("location", "/api/v1/costumers/" + savedCostumer.getId().toString());
		
		return new ResponseEntity<>(headers, HttpStatus.CREATED);
	}
	
	
	@PutMapping(value = "{id}")
	public ResponseEntity<Costumer> updateCostumerById(@PathVariable("id") UUID id, @RequestBody Costumer costumer) {
		costumerService.updateCostumerById(id, costumer);
		
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@DeleteMapping(value = "{id}")
	public ResponseEntity<Costumer> deleteCostumerById(@PathVariable("id") UUID id) {
		costumerService.deleteCostumerById(id);
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
