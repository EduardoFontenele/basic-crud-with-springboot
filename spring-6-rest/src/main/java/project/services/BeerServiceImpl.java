package project.services;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import project.models.Beer;
import project.models.BeerStyle;

@Service
@Slf4j
public class BeerServiceImpl implements BeerService{
	
	private Map<UUID, Beer> beerMap;
	public BeerServiceImpl() {
		this.beerMap = new HashMap<>();
		
		Beer beer1 = Beer.builder()
				.id(UUID.randomUUID())
                .version(1)
                .beerName("Galaxy Cat")
                .beerStyle(BeerStyle.PALE_ALE)
                .upc("12356")
                .price(new BigDecimal("12.99"))
                .quantityOnHand(122)
                .createdDate(LocalDateTime.now())
                .updateDate(LocalDateTime.now())
				.build();
		
		Beer beer2 = Beer.builder()
                .id(UUID.randomUUID())
                .version(1)
                .beerName("Crank")
                .beerStyle(BeerStyle.PALE_ALE)
                .upc("12356222")
                .price(new BigDecimal("11.99"))
                .quantityOnHand(392)
                .createdDate(LocalDateTime.now())
                .updateDate(LocalDateTime.now())
                .build();

        Beer beer3 = Beer.builder()
                .id(UUID.randomUUID())
                .version(1)
                .beerName("Sunshine City")
                .beerStyle(BeerStyle.IPA)
                .upc("12356")
                .price(new BigDecimal("13.99"))
                .quantityOnHand(144)
                .createdDate(LocalDateTime.now())
                .updateDate(LocalDateTime.now())
                .build();

        beerMap.put(beer1.getId(), beer1);
        beerMap.put(beer2.getId(), beer2);
        beerMap.put(beer3.getId(), beer3);
	}
	
	@Override
	public List<Beer> listBeers() {
		return new ArrayList<>(beerMap.values());
	}
	
	@Override
	public Beer getBeerById(UUID id) {
		log.debug("Get Beer by Id - in service. Id: " + id.toString());

        return beerMap.get(id);
	}

	@Override
	public Beer saveNewBeer(Beer beer) {
		
		Beer savedBeer = Beer.builder()
				.id(UUID.randomUUID())
				.createdDate(LocalDateTime.now())
				.version(1)
				.updateDate(LocalDateTime.now())
				.beerName(beer.getBeerName())
				.beerStyle(beer.getBeerStyle())
				.quantityOnHand(beer.getQuantityOnHand())
				.upc(beer.getUpc())
				.price(beer.getPrice())
				.build();
		
		beerMap.put(savedBeer.getId(), savedBeer);
		
		return savedBeer;
	}

	@Override
	public void updateBeerById(UUID id, Beer beer) {
		Beer updateBeer = beerMap.get(id);
		
		updateBeer.setBeerName(beer.getBeerName());
		updateBeer.setBeerStyle(beer.getBeerStyle());
		updateBeer.setVersion(beer.getVersion());
		updateBeer.setUpc(beer.getUpc());
		updateBeer.setQuantityOnHand(beer.getQuantityOnHand());
		updateBeer.setPrice(beer.getPrice());
		updateBeer.setUpdateDate(LocalDateTime.now());
		
		beerMap.put(updateBeer.getId(), updateBeer);
		
	}

	@Override
	public void deleteBeerById(UUID id) {
		beerMap.remove(id);
	}

}
