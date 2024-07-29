package finalprojectfasttrackit.finalproject.Controller;

import finalprojectfasttrackit.finalproject.Model.Basket;
import finalprojectfasttrackit.finalproject.Service.BasketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/basket")
public class BasketRestController {

    @Autowired
    private BasketService myBasketService;

    @GetMapping
    public List<Basket> getAllBasket(){
        return myBasketService.getAllBasket();
    }

    @PostMapping
    public Basket createBasket(@RequestBody Basket myBasket){
        return myBasketService.createBasket(myBasket);
    }


    @PutMapping("/{id}")
    public Basket updateBasket(@PathVariable Integer id, @RequestBody Basket basketUpdated){

        return myBasketService.updateBasket(id, basketUpdated);
    }
    @DeleteMapping("/{id}")
    public Basket deleteBasket(@PathVariable Integer id){
        myBasketService.deleteBasket(id);
        return null;
    }
}
