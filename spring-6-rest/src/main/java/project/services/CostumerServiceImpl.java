package project.services;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.stereotype.Service;

import project.models.Costumer;

@Service
public class CostumerServiceImpl implements CostumerService {
	
	private Map<UUID, Costumer> costumerMap;
	
	public CostumerServiceImpl() {
		this.costumerMap = new HashMap<>();
		
		Costumer costumer1 = Costumer.builder()
				.costumerName("Eduardo Fontenele")
				.id(UUID.randomUUID())
				.version(2132)
				.createdDate(LocalDateTime.now())
				.updatedDate(LocalDateTime.now())
				.build();
		
		Costumer costumer2 = Costumer.builder()
				.costumerName("Manoel Gomes")
				.id(UUID.randomUUID())
				.version(5443)
				.createdDate(LocalDateTime.now())
				.updatedDate(LocalDateTime.now())
				.build();
		
		Costumer costumer3 = Costumer.builder()
				.costumerName("Nando Moura")
				.id(UUID.randomUUID())
				.version(6543)
				.createdDate(LocalDateTime.now())
				.updatedDate(LocalDateTime.now())
				.build();
		
		costumerMap.put(costumer1.getId(), costumer1);
		costumerMap.put(costumer2.getId(), costumer2);
		costumerMap.put(costumer3.getId(), costumer3);
	}



	@Override
	public List<Costumer> listCostumers() {
		return new ArrayList<>(costumerMap.values());
	}



	@Override
	public Costumer getCostumerById(UUID id) {
		return costumerMap.get(id);
	}



	@Override
	public Costumer saveNewCostumer(Costumer costumer) {
		Costumer savedCostumer = Costumer.builder()
				.id(UUID.randomUUID())
				.costumerName(costumer.getCostumerName())
				.version(costumer.getVersion())
				.createdDate(LocalDateTime.now())
				.updatedDate(LocalDateTime.now())
				.build();
		
		costumerMap.put(savedCostumer.getId(), savedCostumer);
		
		return savedCostumer;
	}



	@Override
	public void updateCostumerById(UUID id, Costumer costumer) {
		Costumer updateCostumer = costumerMap.get(id);
		
		updateCostumer.setCostumerName(costumer.getCostumerName());
		updateCostumer.setUpdatedDate(LocalDateTime.now());
		
		costumerMap.put(updateCostumer.getId(), updateCostumer);
	}



	@Override
	public void deleteCostumerById(UUID id) {
		costumerMap.remove(id);
	}

}
