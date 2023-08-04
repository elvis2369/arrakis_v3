package com.db.grad.javaapi.controller;

import com.db.grad.javaapi.model.BookUser;
import com.db.grad.javaapi.model.User;
import com.db.grad.javaapi.service.BookUserService;
import com.db.grad.javaapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@RestController
public class BookUserController {

    @Autowired
    BookUserService bookUserService;

    @Autowired
    UserService userService;

    @GetMapping("/myBooks")
    public List<BookUser> getAllBonds(Principal principal)
    {

        User user = (User) this.userService.searchByUsername(principal.getName());
        List<BookUser> bookUserData = this.bookUserService.findBooksByUserId(user.getId());


        return bookUserData;
    }

}
