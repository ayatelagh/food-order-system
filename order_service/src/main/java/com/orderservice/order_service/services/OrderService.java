
package com.orderservice.order_service.services;
import com.orderservice.order_service.Repositories.OrderRepository;
import com.orderservice.order_service.VO.Item;
import com.orderservice.order_service.VO.ResponseTemplateVO;
import com.orderservice.order_service.models.Order;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private RestTemplate restTemplate;

    public List<Order> getAllOrders() {
        return this.orderRepository.findAll();
    }

    public Order getOrderById(Long id) {
        return this.orderRepository.findById(id).get();
    }

    public Order addOrder(Order order) {
        return this.orderRepository.save(order);
    }

    public ResponseTemplateVO getOrderWithItemByOrderId(Long orderId) {
        Order order = this.getOrderById(orderId);
        Item item = this.restTemplate.getForObject("http://ITEM-SERVICE:9001/items/" + order.getItem_id(), Item.class);   //http://ITEM-SERVICE:9001/items/ ///http://localhost:9001/items/
                        

        ResponseTemplateVO vo = new ResponseTemplateVO();

        vo.setOrder(order);
        vo.setItem(item);

        return vo;

    }

}
