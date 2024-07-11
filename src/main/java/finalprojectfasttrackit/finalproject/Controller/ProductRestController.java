package finalprojectfasttrackit.finalproject.Controller;

import finalprojectfasttrackit.finalproject.Model.Products;
import finalprojectfasttrackit.finalproject.Repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductRestController {

    @Autowired
    private ProductRepo myProductRepo;

    @GetMapping("")
    public List<Products> getAllProducts(){
        return myProductRepo.findAll();
    }

    @PostMapping("")
    public Products createProduct(@RequestBody Products myProduct){
        return myProductRepo.save(myProduct);
    }

    @PutMapping("/{id}")
    public Products updateProduct(@PathVariable Integer id, @RequestBody Products productUpdated){

        Products myProduct = myProductRepo.findById(id).orElseThrow(()->new RuntimeException("Products not found in DB"));
        myProduct.setName(productUpdated.getName());
        myProduct.setDescription(productUpdated.getDescription());
        myProduct.setPrice(productUpdated.getPrice());
        //myProduct.setIdCategory(productUpdated.getIdCategory());

        return  myProductRepo.save(myProduct);
    }
    @DeleteMapping("/{id}")
    public Products deleteProduct(@PathVariable Integer id){
        myProductRepo.deleteById(id);
        return null;//de ce aici e nevoie si in exemplu de la curs nu?
    }
}
