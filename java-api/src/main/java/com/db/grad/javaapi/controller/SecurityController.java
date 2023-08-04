package com.db.grad.javaapi.controller;

import com.db.grad.javaapi.model.Security;
import com.db.grad.javaapi.service.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class SecurityController {

    @Autowired
    SecurityService securityService;

    @GetMapping("/allSecurities")
    public ArrayList<Security> getAllBonds()
    {
        ArrayList<Security> securities = securityService.getAllBonds();
        return securities;
    }

    @GetMapping("/bondSecurity/{id}")
    public Security getSecurityById(@PathVariable(name = "id") int id) {
        return this.securityService.getSecurityById(id);
    }
}
