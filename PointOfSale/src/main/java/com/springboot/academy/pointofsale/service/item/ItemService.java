package com.springboot.academy.pointofsale.service.item;

import com.springboot.academy.pointofsale.dto.ItemDTO;

public interface ItemService {

    ItemDTO saveItem(ItemDTO itemDTO);

    ItemDTO getItemIsAvailable(String name);
}
