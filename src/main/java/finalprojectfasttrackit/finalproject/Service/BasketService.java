package finalprojectfasttrackit.finalproject.Service;

import finalprojectfasttrackit.finalproject.Model.Basket;
import finalprojectfasttrackit.finalproject.Model.Categories;
import finalprojectfasttrackit.finalproject.Repository.BasketRepo;
import finalprojectfasttrackit.finalproject.Repository.CategoriesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BasketService {

    @Autowired
    private BasketRepo myBasketRepo;

    public List<Basket> getAllBasket(){
       return myBasketRepo.findAll();
    }

    public Basket findById(Integer id){
        return myBasketRepo.findById(id).orElseThrow(()->new RuntimeException("Basket not found in DB"));
    }

    public Basket createBasket(Basket myBasket){
        return myBasketRepo.save(myBasket);
    }

    public Basket updateBasket(Integer id, Basket basketUpdated){

        Basket myBasket = myBasketRepo.findById(id).orElseThrow(()->new RuntimeException("Basket not found in DB"));
        myBasket.setIdUser(basketUpdated.getIdUser());
        myBasket.setIdProduct(basketUpdated.getIdProduct());

        return  myBasketRepo.save(myBasket);
    }
    public Categories deleteBasket(Integer id){
        myBasketRepo.deleteById(id);
        return null;
    }
}
