package com.springboot.academy.pointofsale.util.mappers;

import com.springboot.academy.pointofsale.dto.ItemDTO;
import com.springboot.academy.pointofsale.entity.Item;
import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ItemMapper {

    ItemDTO itemConvertToDto(Item item);

    List<ItemDTO> entityListToDtoList(List<Item> itemList);

    List<ItemDTO> listToDtoToPage(Page<Item> itemPage);
}
