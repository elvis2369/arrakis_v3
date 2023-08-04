package com.db.grad.javaapi.repository;

import com.db.grad.javaapi.model.BookUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IBookUserRepo extends JpaRepository<BookUser, Long> {

    @Query(nativeQuery = true, value = "select * from book_user where user_id=:id")
    List<BookUser> findBooksByUserId(long id);

}
