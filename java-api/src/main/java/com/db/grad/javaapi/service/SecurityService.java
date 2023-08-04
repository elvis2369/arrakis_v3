package com.db.grad.javaapi.service;

import com.db.grad.javaapi.model.Security;
import com.db.grad.javaapi.repository.ISecurityRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SecurityService {
    @Autowired
    private ISecurityRepo securityRepo;

    public ArrayList<Security> getAllBonds()
    {
        ArrayList<Security> allBonds = (ArrayList<Security>) securityRepo.findAll();
        return allBonds;
    }

    public List<Security> getMyBonds(long id){

        return this.securityRepo.getMyBonds(id);
    }

}
