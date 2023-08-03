package com.db.grad.javaapi.repository;

import com.db.grad.javaapi.model.Security;
import com.db.grad.javaapi.service.SecurityService;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISecurityRepo extends JpaRepository<Security,Long> {
}
