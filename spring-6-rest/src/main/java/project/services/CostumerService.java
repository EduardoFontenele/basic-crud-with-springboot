package project.services;

import java.util.List;
import java.util.UUID;

import project.models.Costumer;

public interface CostumerService {
	List<Costumer> listCostumers();
	
	Costumer getCostumerById(UUID id);
	
	Costumer saveNewCostumer(Costumer costumer);
	
	void updateCostumerById(UUID id, Costumer costumer);
	
	void deleteCostumerById(UUID id);
}
