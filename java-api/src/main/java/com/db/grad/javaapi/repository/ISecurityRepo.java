package com.db.grad.javaapi.repository;

import com.db.grad.javaapi.model.Security;
import com.db.grad.javaapi.service.SecurityService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.RequestBody;

public interface ISecurityRepo extends JpaRepository<Security,Long> {
    @Query(nativeQuery = true, value = "select * from security where id=:id")
    public Security getSecurityById(long id);
}
