package finalprojectfasttrackit.finalproject.Service;

import finalprojectfasttrackit.finalproject.Model.Products;
import finalprojectfasttrackit.finalproject.Model.Users;
import finalprojectfasttrackit.finalproject.Repository.ProductRepo;
import finalprojectfasttrackit.finalproject.Repository.UsersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductsService {

    @Autowired
    private ProductRepo myProductRepo;

    public List<Products> getAllProducts(){
       return myProductRepo.findAll();
    }

    public Products findById(Integer id){
        return myProductRepo.findById(id).orElseThrow(()->new RuntimeException("Product not found in DB"));
    }

    public Products createProducts(Products myProduct){
        return myProductRepo.save(myProduct);
    }

    public Products updateProducts(Integer id, Products productUpdated){

        Products myProduct = myProductRepo.findById(id).orElseThrow(()->new RuntimeException("Product not found in DB"));
        myProduct.setName(productUpdated.getName());
        myProduct.setDescription(productUpdated.getDescription());
        myProduct.setPrice(productUpdated.getPrice());
//        myProduct.setIduser(productUpdated.getIduser());
        myProduct.setIdCategory(productUpdated.getIdCategory());

        return  myProductRepo.save(myProduct);
    }
    public Products deleteProduct(Integer id){
        myProductRepo.deleteById(id);
        return null;
    }
}
