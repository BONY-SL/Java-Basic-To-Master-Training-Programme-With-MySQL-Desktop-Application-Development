package com.springboot.academy.pointofsale.service.item;

import com.springboot.academy.pointofsale.dto.ItemDTO;
import com.springboot.academy.pointofsale.dto.response.PaginatedResponseItemDTO;

import java.util.List;

public interface ItemService {

    ItemDTO saveItem(ItemDTO itemDTO);

    ItemDTO getItemIsAvailable(String name);

    List<ItemDTO> getAllItemsByStatus(boolean activeStatus);

    PaginatedResponseItemDTO getAllItemsByPaginStatus(boolean activeStatus, int page, int size);
}
