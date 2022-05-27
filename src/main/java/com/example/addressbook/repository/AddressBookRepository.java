package com.example.addressbook.repository;

import com.example.addressbook.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AddressBookRepository extends JpaRepository<Contact, Integer> {

    @Query(value = "SELECT * FROM address_book.addressbook_db order by state", nativeQuery = true)
    List<Contact> sortByState();

    @Query(value = "SELECT * FROM address_book.addressbook_db order by city", nativeQuery = true)
    List<Contact> sortByCity();


}
