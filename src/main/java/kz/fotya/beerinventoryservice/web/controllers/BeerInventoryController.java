package kz.fotya.beerinventoryservice.web.controllers;

import kz.fotya.beerinventoryservice.repositories.BeerInventoryRepository;
import kz.fotya.beerinventoryservice.services.BeerInventoryService;
import kz.fotya.beerinventoryservice.web.model.BeerInventoryDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/v1/")
@RestController
public class BeerInventoryController {

    private final BeerInventoryService beerInventoryService;
    @GetMapping("beer/{beerId}/inventory")
    ResponseEntity<List<BeerInventoryDto>> getInventoryByBeerId(@PathVariable UUID beerId){

        return new ResponseEntity<>(beerInventoryService.getBeersById(beerId), HttpStatus.OK);
    }

    @PostMapping("inventory/")
    ResponseEntity<BeerInventoryDto> addNewInventory(@RequestBody BeerInventoryDto inventoryDto){

        return new ResponseEntity<>(
                beerInventoryService.saveNewBeerInventory(inventoryDto),
                HttpStatus.OK);
    }
}
