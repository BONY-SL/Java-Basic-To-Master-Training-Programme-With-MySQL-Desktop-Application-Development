package com.springboot.academy.pointofsale.controller;

import com.springboot.academy.pointofsale.dto.ItemDTO;
import com.springboot.academy.pointofsale.dto.response.PaginatedResponseItemDTO;
import com.springboot.academy.pointofsale.exceptions.ItemNotFound;
import com.springboot.academy.pointofsale.exceptions.haddlers.AppWideExceptionHandler;
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

    private final AppWideExceptionHandler appWideExceptionHandler;

    @PostMapping("/save-new-item")
    public ResponseEntity<ItemDTO> saveNewItem(@RequestBody ItemDTO itemDTO){

        return ResponseEntity.ok(itemService.saveItem(itemDTO));

    }

    @PostMapping("/save-new-item2")
    public ResponseEntity<StandardResponse> saveNewItem2(@RequestBody ItemDTO itemDTO){

        System.out.println(itemDTO);

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

    @GetMapping(path = "/get-all-item-by-status",
    params = {"activeStatus","page","size"})
    public ResponseEntity<StandardResponse> getAllItemsByStatus(
            @RequestParam(value = "activeStatus") boolean activeStatus,
            @RequestParam(value = "page") int page,
            @RequestParam(value = "size") int size
    ){
        try{
            size = 5;
            //List<ItemDTO> itemDTOList = itemService.getAllItemsByPaginStatus(activeStatus,page,size);
            PaginatedResponseItemDTO paginatedResponseItemDTO = itemService.getAllItemsByPaginStatus(activeStatus,page,size);
            return new ResponseEntity<>(
                    new StandardResponse(200,"Success",paginatedResponseItemDTO),
                    HttpStatus.OK
            );
        }catch (ItemNotFound e){
            return appWideExceptionHandler.itemsNotFoundException(e);
        }
    }

}
