package finalprojectfasttrackit.finalproject.Repository;

import finalprojectfasttrackit.finalproject.Model.Products;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Products,Integer> {
}
