package finalprojectfasttrackit.finalproject.Repository;

import finalprojectfasttrackit.finalproject.Model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepo extends JpaRepository<Order,Integer> {
}
