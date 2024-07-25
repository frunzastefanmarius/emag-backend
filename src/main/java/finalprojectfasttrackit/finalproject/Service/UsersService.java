package finalprojectfasttrackit.finalproject.Service;

import finalprojectfasttrackit.finalproject.Model.Users;
import finalprojectfasttrackit.finalproject.Repository.UsersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class UsersService {

    @Autowired
    private UsersRepo myUsersRepo;

    public List<Users> getAllUsers(){
       return myUsersRepo.findAll();
    }

    public Users findById(Integer id){
        return myUsersRepo.findById(id).orElseThrow(()->new RuntimeException("User not found in DB"));
    }

    public Users createUser(Users myUsers){
        return myUsersRepo.save(myUsers);
    }
    public Users updateUsers(Integer id, Users userUpdated){

        Users myUser = myUsersRepo.findById(id).orElseThrow(()->new RuntimeException("User not found in DB"));
        myUser.setUsername(userUpdated.getUsername());
        myUser.setPassword(userUpdated.getPassword());
        myUser.setIsactive(userUpdated.isIsactive());
        myUser.setIsbuyer(userUpdated.isIsbuyer());

        return  myUsersRepo.save(myUser);
    }
    public Users deleteUser(Integer id){
        myUsersRepo.deleteById(id);
        return null;
    }

}
