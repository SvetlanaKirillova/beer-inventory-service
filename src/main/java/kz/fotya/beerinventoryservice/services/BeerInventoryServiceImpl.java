package kz.fotya.beerinventoryservice.services;

import kz.fotya.beerinventoryservice.repositories.BeerInventoryRepository;
import kz.fotya.beerinventoryservice.web.mappers.BeerInventoryMapper;
import kz.fotya.beerinventoryservice.web.model.BeerInventoryDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class BeerInventoryServiceImpl implements BeerInventoryService {
    @Autowired
    private final BeerInventoryRepository beerInventoryRepository;
    private final BeerInventoryMapper inventoryMapper;

    @Override
    public List<BeerInventoryDto> getBeersById(UUID beerId) {
        return beerInventoryRepository
                .findAllByBeerId(beerId)
                .stream()
                .map(inventoryMapper::dtoFromInventory)
                .collect(Collectors.toList());
    }

    @Override
    public BeerInventoryDto saveNewBeerInventory(BeerInventoryDto inventoryDto) {
        return inventoryMapper.dtoFromInventory(
                beerInventoryRepository.save(inventoryMapper.inventoryFromDto(inventoryDto))
        );
    }
}
