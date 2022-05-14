package my.blog.account.controllers;

import my.blog.account.resources.entity.User;
import my.blog.account.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/findById/{id}", method = RequestMethod.GET)
    public User findUserById(@PathVariable("id") String id) {
        return userService.findById(id);
    }
}
