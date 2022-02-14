package com.inventory.failover.controllers;

import com.inventory.failover.model.BeerInventoryDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.OffsetDateTime;
import java.util.UUID;

@RestController
public class FallbackController {

    @GetMapping("/inventory-failover")
    public ResponseEntity<BeerInventoryDto> getFallbackInventory() {
        OffsetDateTime now = OffsetDateTime.now();
        BeerInventoryDto inventoryDto = BeerInventoryDto.builder()
                .id(UUID.randomUUID())
                .beerId(UUID.fromString("00000000-0000-0000-0000-000000000000"))
                .quantityOnHand(999)
                .createdDate(now)
                .lastModifiedDate(now)
                .build();
        return ResponseEntity.ok(inventoryDto);
    }
}
