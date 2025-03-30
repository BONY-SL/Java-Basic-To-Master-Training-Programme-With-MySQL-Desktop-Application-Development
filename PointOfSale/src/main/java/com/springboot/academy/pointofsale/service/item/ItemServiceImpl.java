package com.springboot.academy.pointofsale.service.item;

import com.springboot.academy.pointofsale.dto.ItemDTO;
import com.springboot.academy.pointofsale.entity.Item;
import com.springboot.academy.pointofsale.repo.ItemRepo;
import com.springboot.academy.pointofsale.util.mappers.ItemMapper;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService{


    private final ItemRepo itemRepo;

    private final ModelMapper modelMapper;

    private final ItemMapper itemMapper;

    @Override
    public ItemDTO saveItem(ItemDTO itemDTO) {

        Item saveItem = itemDtoToItem(itemDTO);

        //Item saveItem = modelMapper.map(itemDTO,Item.class);
        itemRepo.save(saveItem);

        //return modelMapper.map(saveItem, ItemDTO.class);
        return itemConvertToDTO(saveItem);
    }

    @Override
    public ItemDTO getItemIsAvailable(String name) {

        Optional<Item> getItem = itemRepo.findByItemNameAndAvailableEquals(name,true);

        // Debugging line
        getItem.ifPresent(item -> System.out.println("Item found: " + item.isAvailable()));

        //Using Mapping Structure
        return getItem.map(itemMapper::itemConvertToDto).orElse(null);
    }

    private ItemDTO itemConvertToDTO(Item item){

        return ItemDTO.builder()
                .id(item.getId())
                .itemName(item.getItemName())
                .measuringUnitType(item.getMeasuringUnitType())
                .balanceQty(item.getBalanceQty())
                .supplierPrice(item.getSupplierPrice())
                .sellingPrice(item.getSellingPrice())
                .available(item.isAvailable())
                .build();

    }

    private Item itemDtoToItem(ItemDTO item){

        return Item.builder()
                .id(item.getId())
                .itemName(item.getItemName())
                .measuringUnitType(item.getMeasuringUnitType())
                .balanceQty(item.getBalanceQty())
                .supplierPrice(item.getSupplierPrice())
                .sellingPrice(item.getSellingPrice())
                .available(item.isAvailable())
                .build();
    }
}
