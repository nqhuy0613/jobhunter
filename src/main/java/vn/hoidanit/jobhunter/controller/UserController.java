package vn.hoidanit.jobhunter.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import vn.hoidanit.jobhunter.domain.User;
import vn.hoidanit.jobhunter.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // @GetMapping("create/db")

    @PostMapping("user")
    public User createUser(@RequestBody User postManUser) {

        User vipUser = this.userService.handleCreateUser(postManUser);
        return vipUser;
    }

    @DeleteMapping("user/{id}")
    public String deleteUser(@PathVariable("id") long id) {

        this.userService.handleDeleteUser(id);
        return "vip";
    }

    @GetMapping("user/{id}")
    public User getUserById(@PathVariable("id") long id) {

        return this.userService.fetchUserById(id);
    }

    @GetMapping("user")
    public List<User> getAllUser() {

        List<User> arrUsers = this.userService.fetchAllUser();
        return arrUsers;
    }

    @PutMapping("user")
    public User updateUser(@RequestBody User UserfromPost) {

        User userUpdate = this.userService.handleUpdateUser(UserfromPost);
        return userUpdate;
    }
}
