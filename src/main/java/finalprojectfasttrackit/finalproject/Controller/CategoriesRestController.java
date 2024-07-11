package finalprojectfasttrackit.finalproject.Controller;

import finalprojectfasttrackit.finalproject.Model.Categories;
import finalprojectfasttrackit.finalproject.Repository.CategoriesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoriesRestController {

    @Autowired
    private CategoriesRepo myCategoriesRepo;

    @GetMapping("")
    public List<Categories> getAllCategories(){
        return myCategoriesRepo.findAll();
    }

    @PostMapping("")
    public Categories createCategories(@RequestBody Categories category){
        return myCategoriesRepo.save(category);
    }

    @PutMapping("/{id}")
    public Categories updateToDo(@PathVariable Integer id, @RequestBody Categories categoriesUpdated){

        Categories myCategory = myCategoriesRepo.findById(id).orElseThrow(()->new RuntimeException("Category not found in DB"));
        myCategory.setName(categoriesUpdated.getName());
        myCategory.setDescription(categoriesUpdated.getDescription());

        return  myCategoriesRepo.save(myCategory);
    }
    @DeleteMapping("/{id}")
    public Categories deleteCategories(@PathVariable Integer id){
        myCategoriesRepo.deleteById(id);
        return null;//de ce aici e nevoie si in exemplu de la curs nu?
    }
}


