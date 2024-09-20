package com.springbootdemo1.demo2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springbootdemo1.demo2.entity.Book;

/*
 * postman- restController-service-DAO-Database
 * DAO- interacting to database
 */
public interface BookRepository extends JpaRepository<Book, Integer> {

    /*
     * configuration file
     * 
     * 2 way-
     * xml way-
     * hiberUtil-
     * 
     * Configuration(hibernate.cfg.xml)
     * SessionFactory
     * Session
     * Transaction
     * session.save() 
     * 
     * :- Not required everything will be taken care by spring boot.
     * 
     * 
     */
    
}
