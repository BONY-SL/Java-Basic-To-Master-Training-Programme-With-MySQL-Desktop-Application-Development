package com.springboot.academy.pointofsale.controller;

import com.springboot.academy.pointofsale.dto.ItemDTO;
import com.springboot.academy.pointofsale.service.item.ItemService;
import com.springboot.academy.pointofsale.util.StandardResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/item")
@CrossOrigin
@RequiredArgsConstructor
public class ItemController {

    private final ItemService itemService;

    @PostMapping("/save-new-item")
    public ResponseEntity<ItemDTO> saveNewItem(ItemDTO itemDTO){

        return ResponseEntity.ok(itemService.saveItem(itemDTO));

    }

    @PostMapping("/save-new-item2")
    public ResponseEntity<StandardResponse> saveNewItem2(ItemDTO itemDTO){

        // standard method
        return  new ResponseEntity<>(
                new StandardResponse(201,"New Item Created Success",itemService.saveItem(itemDTO)
                ),HttpStatus.CREATED
                );
    }



    @GetMapping(path = "/get-available-items-by-name"
    ,params = "name")
    public ResponseEntity<?> getItemIsAvailable(@RequestParam (value = "name")
                                                          String name){

        ItemDTO itemDTO = itemService.getItemIsAvailable(name);

        if (itemDTO != null){
            return ResponseEntity.status(HttpStatus.OK).body(itemDTO);
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Item is not available");

        }
    }

}
