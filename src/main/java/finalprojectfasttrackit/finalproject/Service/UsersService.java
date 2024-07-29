package finalprojectfasttrackit.finalproject.Service;

import finalprojectfasttrackit.finalproject.Model.Users;
import finalprojectfasttrackit.finalproject.Repository.UsersRepo;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        if(myUsers.getPassword().length()<6){
            throw new RuntimeException("Password too short.:(");
        }
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

    public Users authenticateUser(String username, String password){
        return myUsersRepo.findByUsernameAndPassword(username, password).orElseThrow(()->new EntityNotFoundException("Invalid credentials"));
    }


    //TODO: exception handling pe partea de FE, sa termin add in basket ca era ceva problema, altele ce mai vin, remove userID din product
}
