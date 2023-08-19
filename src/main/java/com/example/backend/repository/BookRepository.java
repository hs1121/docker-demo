package com.example.backend.repository;

import com.example.backend.model.Book;
import com.example.backend.model.BookRequest;
import com.example.backend.model.BookResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    @Query("SELECT b FROM BOOK b")
    List<Book> getAllBooks();

    @Query("SELECT b FROM BOOK b where b.name = ?1")
    Optional<Book> getBookByName(String name);

    @Modifying
    @Query("DELETE FROM BOOK b WHERE b.name = ?1")
    void deleteBookByName(String name);


}
