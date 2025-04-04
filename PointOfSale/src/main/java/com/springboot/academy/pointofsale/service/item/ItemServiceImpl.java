package com.springboot.academy.pointofsale.service.item;

import com.springboot.academy.pointofsale.dto.ItemDTO;
import com.springboot.academy.pointofsale.dto.response.PaginatedResponseItemDTO;
import com.springboot.academy.pointofsale.entity.Item;
import com.springboot.academy.pointofsale.exceptions.ItemNotFound;
import com.springboot.academy.pointofsale.repo.ItemRepo;
import com.springboot.academy.pointofsale.util.mappers.ItemMapper;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService{


    private final ItemRepo itemRepo;


    private final ItemMapper itemMapper;

    private final ModelMapper modelMapper;

    @Override
    public ItemDTO saveItem(ItemDTO itemDTO) {


        //Item saveItem = itemDtoToItem(itemDTO);

        Item saveItem = modelMapper.map(itemDTO,Item.class);
        System.out.println(saveItem);

        return modelMapper.map(itemRepo.save(saveItem), ItemDTO.class);
        //return itemConvertToDTO(itemRepo.save(saveItem));
    }

    @Override
    public ItemDTO getItemIsAvailable(String name) {

        Optional<Item> getItem = itemRepo.findByItemNameAndAvailableEquals(name,true);

        // Debugging line
        getItem.ifPresent(item -> System.out.println("Item found: " + item.isAvailable()));

        //Using Mapping Structure
        return getItem.map(itemMapper::itemConvertToDto).orElse(null);
    }

    @Override
    public List<ItemDTO> getAllItemsByStatus(boolean activeStatus) {

            List<Item> itemList = itemRepo.findAllByAvailableEquals(activeStatus);

            if (!itemList.isEmpty()){
                return itemMapper.entityListToDtoList(itemList);
            }else {
                throw new ItemNotFound("Not Found Items");
            }



    }

    @Override
    public PaginatedResponseItemDTO getAllItemsByPaginStatus(boolean activeStatus, int page, int size) {

        Page<Item> itemPage = itemRepo.findAllByAvailableEquals(activeStatus, PageRequest.of(page,size));
        int allDataCount = itemRepo.countAllByAvailableEquals(activeStatus);
        System.out.println(itemPage);

        if (!itemPage.isEmpty()){
            return PaginatedResponseItemDTO.builder()
                    .itemDTOList(itemMapper.listToDtoToPage(itemPage))
                    .dataCount(allDataCount)
                    .build();
        }else {
            throw new ItemNotFound("Not Found Items");
        }

    }


    private ItemDTO itemConvertToDTO(Item item){

        return ItemDTO.builder()
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
                .id(null)
                .itemName(item.getItemName())
                .measuringUnitType(item.getMeasuringUnitType())
                .balanceQty(item.getBalanceQty())
                .supplierPrice(item.getSupplierPrice())
                .sellingPrice(item.getSellingPrice())
                .available(item.isAvailable())
                .build();
    }
}
