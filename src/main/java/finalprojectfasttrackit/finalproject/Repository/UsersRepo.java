package finalprojectfasttrackit.finalproject.Repository;

import finalprojectfasttrackit.finalproject.Model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsersRepo extends JpaRepository<Users,Integer> {

    Optional<Users> findByUsernameAndPassword(String username, String password);

}
