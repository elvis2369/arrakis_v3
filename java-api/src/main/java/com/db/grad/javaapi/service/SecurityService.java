package com.db.grad.javaapi.service;

import com.db.grad.javaapi.model.Security;
import com.db.grad.javaapi.repository.ISecurityRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;

@Service
public class SecurityService {
    @Autowired
    private ISecurityRepo securityRepo;

    public ArrayList<Security> getAllBonds()
    {
        ArrayList<Security> allBonds = (ArrayList<Security>) securityRepo.findAll();
        return allBonds;
    }

    public Security getSecurityById(long id) {
        return this.securityRepo.getSecurityById(id);
    }
}
