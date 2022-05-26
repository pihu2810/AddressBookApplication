package com.example.addressbook.repository;

import com.example.addressbook.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public class AddressBookRepository extends JpaRepository<Contact, Integer> {
}
