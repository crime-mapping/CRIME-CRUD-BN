package com.crimemapping.crimecrudbn.controllers;

import com.crimemapping.crimecrudbn.models.User;
import com.crimemapping.crimecrudbn.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "http://localhost:5173")
public class UserController {

        private final UserService userService;

        public UserController(UserService userService) {
            this.userService = userService;
        }

        @PostMapping("/register")
        public ResponseEntity<?> saveUser(@RequestBody User user) {
            try {
                if (!user.getPassword().equals(user.getConfirmPass())) {
                    return ResponseEntity.badRequest().body("Password Mismatches !");
                }
                if (userService.emailExists(user.getEmail()) != null) {
                    return ResponseEntity.badRequest().body("Email already Registered !");
                }
                BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
                String hashedPassword = encoder.encode(user.getPassword());
                user.setPassword(hashedPassword);
                User savedUser = userService.createUser(user);
                if (savedUser != null) {
                    return ResponseEntity.ok("Registration done Successfully!");
                } else {
                    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An expected error occurred!");
                }
            } catch (Exception e) {
                e.printStackTrace();
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal Server error!");
            }
        }

        @PostMapping("/login")
        public ResponseEntity<?> loginUser(@RequestBody User logUser) {
            try {

                User user = userService.emailExists(logUser.getEmail());
                if (user == null) {
                    System.out.println("User"+user.getEmail()+" Password "+user.getPassword());
                    return ResponseEntity.badRequest().body(new ErrorResponse("Invalid Credentials !"));
                }
                BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
                if(encoder.matches(logUser.getPassword(), user.getPassword())) {
                    return ResponseEntity.ok(user);
                }
                else{
                    return ResponseEntity.badRequest().body(new ErrorResponse("Invalid Credentials !"));
                }
//            if(user.getPassword().equals(logUser.getPassword())){
//                return ResponseEntity.ok(user);
//            }
            } catch (Exception e) {
                e.printStackTrace();
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ErrorResponse("Internal Server error!"));
            }
            // return ResponseEntity.badRequest().body(new ErrorResponse("Invalid Credentials !"+logUser.getEmail()+" Password"+logUser.getPassword()));
        }

        static class ErrorResponse {
            private String message;

            public ErrorResponse(String message) {
                this.message = message;
            }

            public String getMessage() {
                return message;
            }

            public void setMessage(String message) {
                this.message = message;
            }
        }
    }

