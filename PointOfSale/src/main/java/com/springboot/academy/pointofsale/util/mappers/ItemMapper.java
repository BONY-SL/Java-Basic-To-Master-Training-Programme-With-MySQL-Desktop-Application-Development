package com.springboot.academy.pointofsale.util.mappers;

import com.springboot.academy.pointofsale.dto.ItemDTO;
import com.springboot.academy.pointofsale.entity.Item;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ItemMapper {

    ItemDTO itemConvertToDto(Item item);
}
