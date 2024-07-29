package finalprojectfasttrackit.finalproject.Controller;

import finalprojectfasttrackit.finalproject.Model.Users;
import finalprojectfasttrackit.finalproject.Model.request.CredentialsRequest;
import finalprojectfasttrackit.finalproject.Service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/auth")
public class AuthRestController {

    @Autowired
    private UsersService myUsersService;

    @PostMapping("/signup")
    public ResponseEntity<Users> signUp(@RequestBody CredentialsRequest myUser){
        try {
            return ResponseEntity.ok(myUsersService.createUser(new Users(myUser.getUsername(), myUser.getPassword())));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/login")
    public ResponseEntity<Users> login(@RequestBody CredentialsRequest myUser){
        try {
            return ResponseEntity.ok(myUsersService.authenticateUser(myUser.getUsername(), myUser.getPassword()));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

}
