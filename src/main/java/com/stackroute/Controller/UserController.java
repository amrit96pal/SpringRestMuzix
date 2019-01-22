package com.stackroute.Controller;

import com.stackroute.Service.UserService;
import com.stackroute.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("first")
public class UserController {

    UserService userService;
    @Autowired
    public UserController(UserService userService){
        this.userService=userService;
    }

    @PostMapping("ans")
    public ResponseEntity<?> saveTheUser(@RequestBody User user){
        ResponseEntity responseEntity;
        try {
            User user12=userService.saveUser(user);
            responseEntity=new ResponseEntity<String>("Success", HttpStatus.CREATED);
            return responseEntity;
        }catch (Exception e){
            responseEntity= new ResponseEntity<String>(e.getMessage(), HttpStatus.CONFLICT);
            return responseEntity;
        }
    }



    @GetMapping("anss")
    public ResponseEntity<?> getAllUserAvailable(){
        ResponseEntity responseEntity;
        try {
            return new ResponseEntity<List<User>>(userService.getAllUsers(),HttpStatus.CREATED);
        }catch (Exception e){
            responseEntity=new ResponseEntity<String>(e.getMessage(),HttpStatus.CONFLICT);
            return responseEntity;
        }
    }


    @GetMapping("ans")
    public ResponseEntity<?> getUserUsingId(@RequestParam String id){
        ResponseEntity responseEntity;
        try {
            return new ResponseEntity<Optional<User>>(userService.getUserById(Integer.parseInt(id)), HttpStatus.CREATED);
        }catch (Exception e){
            responseEntity=new ResponseEntity<String>(e.getMessage(),HttpStatus.CONFLICT);
            return responseEntity;
        }
    }

    @GetMapping("ansusername")
    public ResponseEntity<?> getUserUsingName(@RequestParam String name){
        ResponseEntity responseEntity;
        try {
            return new ResponseEntity<User>(userService.getBYFirstname(name), HttpStatus.CREATED);
        }catch (Exception e){
            responseEntity=new ResponseEntity<String>(e.getMessage(),HttpStatus.CONFLICT);
            return responseEntity;
        }
    }


    @DeleteMapping("ans")
    public ResponseEntity<?> deleteTheUser(@RequestParam String id){
        ResponseEntity responseEntity;
        try {
            userService.delete(Integer.parseInt(id));
            responseEntity=new ResponseEntity<String>("Success", HttpStatus.CREATED);
            return responseEntity;
        }catch (Exception e){
            responseEntity= new ResponseEntity<String>(e.getMessage(), HttpStatus.CONFLICT);
            return responseEntity;
        }
    }

    @PutMapping("ans")
    public ResponseEntity<?> updateTheUser(@RequestBody User user){
        ResponseEntity responseEntity;
        try {
            userService.updateUser(user);
            responseEntity=new ResponseEntity<String>("Success", HttpStatus.CREATED);
            return responseEntity;
        }catch (Exception e){
            responseEntity= new ResponseEntity<String>(e.getMessage(), HttpStatus.CONFLICT);
            return responseEntity;
        }
    }


}
