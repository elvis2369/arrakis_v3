package com.db.grad.javaapi.service;

import com.db.grad.javaapi.model.BookUser;
import com.db.grad.javaapi.model.Security;
import com.db.grad.javaapi.repository.IBookUserRepo;
import com.db.grad.javaapi.repository.ISecurityRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookUserService {

    @Autowired
    private IBookUserRepo bookUserRepo;


    public ArrayList<BookUser> getMyBooks(long id)
    {
        //ArrayList<BookUser> allBookUser = (ArrayList<BookUser>) bookUserRepo.findById();
        //return allBookUser;
        return null;
    }

    public List<BookUser> findBooksByUserId(long id){

        return this.bookUserRepo.findBooksByUserId(id);
    }


}
