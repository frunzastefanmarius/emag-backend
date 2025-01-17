package finalprojectfasttrackit.finalproject.Controller;

import finalprojectfasttrackit.finalproject.Model.Users;
import finalprojectfasttrackit.finalproject.Service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/users")
public class UsersRestController {

    @Autowired
    private UsersService myUsersService;

    @GetMapping
    public List<Users> getAllUsers(){
        return myUsersService.getAllUsers();
    }

    @GetMapping("/{id}")
    public Users getUserById(@PathVariable Integer id){
        return myUsersService.findById(id);
    }

    @PostMapping
    public ResponseEntity<Users> createUser(@RequestBody Users myUsers){
        try {
            return ResponseEntity.ok(myUsersService.createUser(myUsers));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/{id}")
    public Users updateUsers(@PathVariable Integer id, @RequestBody Users userUpdated){

        return myUsersService.updateUsers(id, userUpdated);
    }
    @DeleteMapping("/{id}")
    public Users deleteUser(@PathVariable Integer id){
        myUsersService.deleteUser(id);
        return null;
    }
}
