package finalprojectfasttrackit.finalproject.Controller;

import finalprojectfasttrackit.finalproject.Model.Basket;
import finalprojectfasttrackit.finalproject.Repository.BasketRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/basket")
public class BasketRestController {

    @Autowired
    private BasketRepo myBasketRepo;

    @GetMapping("")
    public List<Basket> getAllBaskets(){
        return myBasketRepo.findAll();
    }

    @PostMapping("")
    public Basket createBasket(@RequestBody Basket myBasket){
        return myBasketRepo.save(myBasket);
    }

    @PutMapping("/{id}")
    public Basket updateBasket(@PathVariable Integer id, @RequestBody Basket BasketUpdated){

        Basket myBasket = myBasketRepo.findById(id).orElseThrow(()->new RuntimeException("Products not found in DB"));
        myBasket.setIdUser(BasketUpdated.getIdUser());
        myBasket.setIdProduct(BasketUpdated.getIdProduct());

        return  myBasketRepo.save(myBasket);
    }
    @DeleteMapping("/{id}")
    public Basket deleteBasket(@PathVariable Integer id){
        myBasketRepo.deleteById(id);
        return null;//de ce aici e nevoie si in exemplu de la curs nu?
    }
}
