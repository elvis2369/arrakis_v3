package com.db.grad.javaapi.controller;

import com.db.grad.javaapi.model.BookUser;
import com.db.grad.javaapi.model.Security;
import com.db.grad.javaapi.model.User;
import com.db.grad.javaapi.service.BookUserService;
import com.db.grad.javaapi.service.SecurityService;
import com.db.grad.javaapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @Autowired
    SecurityService securityService;

    @GetMapping("/myBooks")
    public List<BookUser> getMyBooks(@RequestParam(name = "username") String username) {
        User user = (User) this.userService.searchByUsername(username);
        List<BookUser> bookUserData = this.bookUserService.findBooksByUserId(user.getId());

        return bookUserData;
    }

    @GetMapping("/myBonds")
    public ArrayList<Security> getAllBondsFromMyBooks(@RequestParam(name = "username") String username) {
        User user = (User) this.userService.searchByUsername(username);

        ArrayList<Security> bondData = this.securityService.getMyBonds(user.getId());

        return bondData;
    }

}
