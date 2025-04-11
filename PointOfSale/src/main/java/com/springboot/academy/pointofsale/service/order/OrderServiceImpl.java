package com.springboot.academy.pointofsale.service.order;

import com.springboot.academy.pointofsale.dto.request.RequestOderSaveDTO;
import com.springboot.academy.pointofsale.dto.response.PaginatedResponseOrderDetails;
import com.springboot.academy.pointofsale.dto.response.ResponseOrderDetails;
import com.springboot.academy.pointofsale.entity.Item;
import com.springboot.academy.pointofsale.entity.Order;
import com.springboot.academy.pointofsale.entity.OrderItem;
import com.springboot.academy.pointofsale.repo.CustomerRepo;
import com.springboot.academy.pointofsale.repo.ItemRepo;
import com.springboot.academy.pointofsale.repo.OrderItemRepo;
import com.springboot.academy.pointofsale.repo.OrderRepo;
import com.springboot.academy.pointofsale.util.queryinterface.OrderDetailsInterface;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
        
        Order newOrder = new Order(
                customerRepo.getReferenceById(requestOderSaveDTO.getCustomer()),
                requestOderSaveDTO.getDate(),
                requestOderSaveDTO.getOrderTotalPrice()
        );
        Order order = orderRepo.save(newOrder);

        if(orderRepo.existsById(order.getId())){
            List<OrderItem> orderItemList = modelMapper
                    .map(requestOderSaveDTO.getOrderItemDTOList(),
                            new TypeToken<List<OrderItem>>(){}.getType());

            for (OrderItem orderItem : orderItemList) {
                orderItem.setId(null);
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

    @Override
    public PaginatedResponseOrderDetails getAllOrderDetails() {

        List<OrderDetailsInterface> orderDetailsList = orderRepo.getAllOrderDetails();

        List<ResponseOrderDetails> responseOrderDetails = new ArrayList<>();

        for (OrderDetailsInterface orderDetails : orderDetailsList){
             ResponseOrderDetails order = ResponseOrderDetails.builder()
                     .customerName(orderDetails.getCustomerName())
                     .customerAddress(orderDetails.getCustomerAddress())
                     .contactNumber(orderDetails.getContactNumber())
                     .date(orderDetails.getDate())
                     .orderTotalPrice(orderDetails.getOrderTotalPrice())
                     .build();
             responseOrderDetails.add(order);
        }
        return PaginatedResponseOrderDetails.builder()
                .orderDetailsList(responseOrderDetails)
                .count(responseOrderDetails.size())
                .build();
    }
}
