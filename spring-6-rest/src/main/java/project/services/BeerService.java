package project.services;

import java.util.List;
import java.util.UUID;

import project.models.Beer;

public interface BeerService {
	Beer getBeerById(UUID id);

	List<Beer> listBeers();
	
	Beer saveNewBeer(Beer beer);
	
	void updateBeerById(UUID id, Beer beer);
	
	void deleteBeerById(UUID id);
}
