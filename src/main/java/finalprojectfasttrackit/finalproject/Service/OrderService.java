package finalprojectfasttrackit.finalproject.Service;

import finalprojectfasttrackit.finalproject.Model.Order;
import finalprojectfasttrackit.finalproject.Repository.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepo myOrderRepo;
    @Autowired
    private BasketService myBasketService;

    public List<Order> getAllOrders(){
       return myOrderRepo.findAll();
    }

    public Order findById(Integer id){
        return myOrderRepo.findById(id).orElseThrow(()->new RuntimeException("Order not found in DB"));
    }

    public Order createOrder(Order myOrder){
        Calendar currentTime = Calendar.getInstance();
        myOrder.setCreationDateTime(new Timestamp(currentTime.getTime().getTime()));

        Order newOrder = myOrderRepo.save(myOrder);
        myBasketService.deleteBasketForProductAndUser(myOrder.getIdProduct(), myOrder.getIdUser());

        return newOrder;
    }

    public Order updateOrder(Integer id, Order orderUpdated){

        Order myOrder = myOrderRepo.findById(id).orElseThrow(()->new RuntimeException("Order not found in DB"));
        myOrder.setCreationDateTime(orderUpdated.getCreationDateTime());
        myOrder.setDelivery(orderUpdated.isDelivery());
        myOrder.setPayment(orderUpdated.isPayment());
        myOrder.setIdUser(orderUpdated.getIdUser());
        myOrder.setIdProduct(orderUpdated.getIdProduct());

        return  myOrderRepo.save(myOrder);
    }
    public Order deleteOrder(Integer id){
        myOrderRepo.deleteById(id);
        return null;
    }
}
