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
import lombok.extern.slf4j.Slf4j;
import project.models.Beer;
import project.services.BeerService;

@AllArgsConstructor
@Slf4j
@RestController
@RequestMapping("/api/v1/beers")
public class BeerController {
	private final BeerService beerService;
	
	@PostMapping
	public ResponseEntity<Beer> handlePost(@RequestBody Beer beer) {
		Beer savedBeer = beerService.saveNewBeer(beer);
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("Location", "/api/v1/beers/" + savedBeer.getId().toString() );
		
		return new ResponseEntity<>(headers, HttpStatus.CREATED);
		
	}
	
	@GetMapping
	public List<Beer> listBeers() {
		return beerService.listBeers();
	}
	
	@GetMapping(value = "{id}")
	public Beer getBeerById(@PathVariable("id") UUID id) {
		
		log.debug("getBeerById in controller");
		
		return beerService.getBeerById(id);
	}
	
	@PutMapping(value = "{id}")
	public ResponseEntity<Beer> updateBeerById(@PathVariable("id") UUID id, @RequestBody Beer beer) {
		beerService.updateBeerById(id, beer);
		
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@DeleteMapping(value = "{id}")
	public ResponseEntity<Beer> deleteBeerById(@PathVariable("id") UUID id) {
		beerService.deleteBeerById(id);
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
