package finalprojectfasttrackit.finalproject.Service;

import finalprojectfasttrackit.finalproject.Model.Categories;
import finalprojectfasttrackit.finalproject.Model.Products;
import finalprojectfasttrackit.finalproject.Repository.CategoriesRepo;
import finalprojectfasttrackit.finalproject.Repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoriesRepo myCategoryRepo;

    public List<Categories> getAllCategories(){
       return myCategoryRepo.findAll();
    }

    public Categories findById(Integer id){
        return myCategoryRepo.findById(id).orElseThrow(()->new RuntimeException("Category not found in DB"));
    }

    public Categories createCategories(Categories myCategories){
        return myCategoryRepo.save(myCategories);
    }

    public Categories updateCategories(Integer id, Categories categoriesUpdated){

        Categories myCategories = myCategoryRepo.findById(id).orElseThrow(()->new RuntimeException("Category not found in DB"));
        myCategories.setName(categoriesUpdated.getName());
        myCategories.setDescription(categoriesUpdated.getDescription());

        return  myCategoryRepo.save(myCategories);
    }
    public Categories deleteCategories(Integer id){
        myCategoryRepo.deleteById(id);
        return null;
    }
}
