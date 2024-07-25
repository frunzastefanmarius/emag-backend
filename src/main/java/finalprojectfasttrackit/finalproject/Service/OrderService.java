package finalprojectfasttrackit.finalproject.Service;

import finalprojectfasttrackit.finalproject.Model.Order;
import finalprojectfasttrackit.finalproject.Model.Products;
import finalprojectfasttrackit.finalproject.Repository.OrderRepo;
import finalprojectfasttrackit.finalproject.Repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepo myOrderRepo;

    public List<Order> getAllOrders(){
       return myOrderRepo.findAll();
    }

    public Order findById(Integer id){
        return myOrderRepo.findById(id).orElseThrow(()->new RuntimeException("Order not found in DB"));
    }

    public Order createOrder(Order myOrder){
        return myOrderRepo.save(myOrder);
    }

    public Order updateOrder(Integer id, Order orderUpdated){

        Order myOrder = myOrderRepo.findById(id).orElseThrow(()->new RuntimeException("Order not found in DB"));
        myOrder.setCreationDateTime(orderUpdated.getCreationDateTime());
        myOrder.setDelivery(orderUpdated.isDelivery());
        myOrder.setPayment(orderUpdated.isPayment());
        myOrder.setIduser(orderUpdated.getIduser());
        myOrder.setIdproduct(orderUpdated.getIdproduct());

        return  myOrderRepo.save(myOrder);
    }
    public Order deleteOrder(Integer id){
        myOrderRepo.deleteById(id);
        return null;
    }
}
