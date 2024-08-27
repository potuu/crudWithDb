package com.example.crudWithDb.Repositories;

import com.example.crudWithDb.Entities.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Integer> {

    @Query("SELECT c FROM Contact c WHERE"
            + " CONCAT(c.id, c.name, c.email, c.phone)"
            + " LIKE %?1%")
    List<Contact> findAll(String keyword);
}
