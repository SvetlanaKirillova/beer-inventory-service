package kz.fotya.beerinventoryservice.web.mappers;

import kz.fotya.beerinventoryservice.domain.BeerInventory;
import kz.fotya.beerinventoryservice.web.model.BeerInventoryDto;
import org.mapstruct.Mapper;

@Mapper(uses = {DateMapper.class})
public interface BeerInventoryMapper {
    BeerInventory inventoryFromDto(BeerInventoryDto dto);
    BeerInventoryDto dtoFromInventory(BeerInventory beerInventory);
}
