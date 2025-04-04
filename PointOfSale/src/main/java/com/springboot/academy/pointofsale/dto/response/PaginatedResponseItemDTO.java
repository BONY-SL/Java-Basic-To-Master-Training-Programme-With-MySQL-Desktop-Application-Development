package com.springboot.academy.pointofsale.dto.response;

import com.springboot.academy.pointofsale.dto.ItemDTO;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PaginatedResponseItemDTO {

    private List<ItemDTO> itemDTOList;
    private long dataCount;

}
