package finalprojectfasttrackit.finalproject.Controller;

import finalprojectfasttrackit.finalproject.Model.Categories;
import finalprojectfasttrackit.finalproject.Model.Users;
import finalprojectfasttrackit.finalproject.Service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/categories")
public class CategoriesRestController {

    @Autowired
    private CategoryService myCategoryService;

    @GetMapping
    public List<Categories> getAllCategories(){
        return myCategoryService.getAllCategories();
    }

    @PostMapping
    public Categories createCategories(@RequestBody Categories myCategories){
        return myCategoryService.createCategories(myCategories);
    }

    @PutMapping("/{id}")
    public Categories updateCategories(@PathVariable Integer id, @RequestBody Categories categoriesUpdated){

        return myCategoryService.updateCategories(id, categoriesUpdated);
    }
    @DeleteMapping("/{id}")
    public Users deleteProduct(@PathVariable Integer id){
        myCategoryService.deleteCategories(id);
        return null;
    }
}


