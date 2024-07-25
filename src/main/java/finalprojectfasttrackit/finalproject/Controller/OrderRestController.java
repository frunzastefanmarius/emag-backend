package finalprojectfasttrackit.finalproject.Controller;


import finalprojectfasttrackit.finalproject.Model.Order;
import finalprojectfasttrackit.finalproject.Model.Products;
import finalprojectfasttrackit.finalproject.Model.Users;
import finalprojectfasttrackit.finalproject.Repository.OrderRepo;
import finalprojectfasttrackit.finalproject.Service.OrderService;
import finalprojectfasttrackit.finalproject.Service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderRestController {

    @Autowired
    private OrderService myOrderService;

    @GetMapping
    public List<Order> getAllProducts(){
        return myOrderService.getAllOrders();
    }

    @PostMapping
    public Order createOrder(@RequestBody Order myOrder){
        return myOrderService.createOrder(myOrder);
    }

    @PutMapping("/{id}")
    public Order updateOrder(@PathVariable Integer id, @RequestBody Order orderUpdated){

        return myOrderService.updateOrder(id, orderUpdated);
    }
    @DeleteMapping("/{id}")
    public Order deleteOrder(@PathVariable Integer id){
        myOrderService.deleteOrder(id);
        return null;
    }


}
