package com.sda.biblioteka.spring.db;

import com.sda.biblioteka.spring.db.model.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.util.List;

import static javafx.scene.input.KeyCode.T;

@Repository
public interface BookRepository extends CrudRepository<Book, Integer>{

    List<Book> findByAuthor(String author);
}
