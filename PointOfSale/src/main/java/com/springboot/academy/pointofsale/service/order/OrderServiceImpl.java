package com.springboot.academy.pointofsale.service.order;

import com.springboot.academy.pointofsale.dto.request.RequestOderSaveDTO;
import com.springboot.academy.pointofsale.entity.Item;
import com.springboot.academy.pointofsale.entity.Order;
import com.springboot.academy.pointofsale.entity.OrderItem;
import com.springboot.academy.pointofsale.repo.CustomerRepo;
import com.springboot.academy.pointofsale.repo.ItemRepo;
import com.springboot.academy.pointofsale.repo.OrderItemRepo;
import com.springboot.academy.pointofsale.repo.OrderRepo;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
@Transactional
public class OrderServiceImpl implements OrderService{


    private final CustomerRepo customerRepo;
    private final OrderRepo orderRepo;
    private final OrderItemRepo orderItemRepo;
    private final ModelMapper modelMapper;
    private final ItemRepo itemRepo;


    @Override
    @Transactional
    public boolean saveNewOrder(RequestOderSaveDTO requestOderSaveDTO) {

        // Error
        Order newOrder = new Order(
                customerRepo.getReferenceById(requestOderSaveDTO.getCustomer()),
                requestOderSaveDTO.getDate(),
                requestOderSaveDTO.getOrderTotalPrice()
        );
        orderRepo.save(newOrder);

        if(orderRepo.existsById(newOrder.getId())){
            List<OrderItem> orderItemList = modelMapper
                    .map(requestOderSaveDTO.getOrderItemDTOList(),
                            new TypeToken<List<OrderItem>>(){}.getType());

            for (OrderItem orderItem : orderItemList) {
                orderItem.setOrder(newOrder);
                Item item = itemRepo.getReferenceById(orderItem.getItem().getId()); // Ensure you're using getReferenceById for lazy loading
                orderItem.setItem(item);
            }

            if(!orderItemList.isEmpty()){
                orderItemRepo.saveAll(orderItemList);
                return true;
            }else {
                return false;
            }
        }else {
            return false;
        }
    }
}
