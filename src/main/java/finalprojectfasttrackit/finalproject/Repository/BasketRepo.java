package finalprojectfasttrackit.finalproject.Repository;

import finalprojectfasttrackit.finalproject.Model.Basket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BasketRepo extends JpaRepository<Basket,Integer> {

    void deleteByIdProductAndIdUser(Integer idproduct, Integer iduser);
    //aici o sa stearga tot ce gaseste cu id si produsul respectiv

}
