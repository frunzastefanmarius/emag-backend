package finalprojectfasttrackit.finalproject.Controller;

import finalprojectfasttrackit.finalproject.Model.Products;
import finalprojectfasttrackit.finalproject.Model.Users;
import finalprojectfasttrackit.finalproject.Service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/products")
public class ProductRestController {

    @Autowired
    private ProductsService myProductService;

    @GetMapping
    public List<Products> getAllProducts(){
        return myProductService.getAllProducts();
    }

    @PostMapping
    public Products createProducts(@RequestBody Products myProducts){
        return myProductService.createProducts(myProducts);
    }

    @PutMapping("/{id}")
    public Products updateProducts(@PathVariable Integer id, @RequestBody Products productsUpdated){

        return myProductService.updateProducts(id, productsUpdated);
    }
    @DeleteMapping("/{id}")
    public Users deleteProduct(@PathVariable Integer id){
        myProductService.deleteProduct(id);
        return null;
    }
}
