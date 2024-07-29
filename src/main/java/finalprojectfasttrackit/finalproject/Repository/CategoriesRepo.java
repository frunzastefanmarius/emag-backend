package finalprojectfasttrackit.finalproject.Repository;

import finalprojectfasttrackit.finalproject.Model.Categories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface CategoriesRepo extends JpaRepository<Categories,Integer>{

}
