package kz.fotya.beerinventoryservice.services;

import kz.fotya.beerinventoryservice.web.model.BeerInventoryDto;

import java.util.List;
import java.util.UUID;

public interface BeerInventoryService {

    List<BeerInventoryDto> getBeersById(UUID beerId);

    BeerInventoryDto saveNewBeerInventory(BeerInventoryDto inventoryDto);
}
