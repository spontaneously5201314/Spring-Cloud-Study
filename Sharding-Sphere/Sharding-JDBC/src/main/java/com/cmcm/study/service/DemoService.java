package com.cmcm.study.service;

import com.cmcm.study.domain.Order;
import com.cmcm.study.domain.OrderItem;
import com.cmcm.study.mapper.OrderItemMapper;
import com.cmcm.study.mapper.OrderMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author Spontaneously
 * @time 2018-09-07 下午2:27
 */
@Service
public class DemoService {

    @Resource
    private OrderMapper orderRepository;

    @Resource
    private OrderItemMapper orderItemRepository;

    public String insert(Integer userId) {
        Order order = new Order();
        order.setUserId(userId);
        order.setStatus("INSERT_TEST");
        orderRepository.insert(order);

        long orderId = order.getOrderId();
        OrderItem item = new OrderItem();
        item.setOrderId(orderId);
        item.setUserId(userId);
        item.setStatus("INSERT_TEST");
        orderItemRepository.insert(item);

        return orderId + "|" + item.getOrderItemId();
    }
}
