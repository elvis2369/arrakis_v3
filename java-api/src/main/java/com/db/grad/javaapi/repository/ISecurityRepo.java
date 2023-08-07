package com.db.grad.javaapi.repository;

import com.db.grad.javaapi.model.Security;
import com.db.grad.javaapi.service.SecurityService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

public interface ISecurityRepo extends JpaRepository<Security,Long> {

    @Query(nativeQuery = true, value = "SELECT DISTINCT(security.id), security.isin, security.cusip, security.issuer_name, security.maturity_date, security.coupon, security.type, security.face_value, security.currency, security.status\n" +
            "FROM trade\n" +
            "INNER JOIN security\n" +
            "ON trade.security_id = security.id\n" +
            "WHERE trade.book_id IN (SELECT book_id\n" +
            "                   FROM book_user\n" +
            "                  WHERE user_id=1);")
      //          "                  WHERE user_id=:id);")
    ArrayList<Security> getMyBonds(long id);

    @Query(nativeQuery = true, value = "select * from security where id=:id")
    public Security getSecurityById(long id);

}





