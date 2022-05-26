package com.example.addressbook.model;

import com.example.addressbook.dto.ContactDTO;
import lombok.Data;

@Data
public class Contact {
    private int contactId;
    private String firstName;
    private String lastName;
    private String address;
    private String state;
    private String city;
    private String zip;
    private String phone;
    private String email;

    public Contact(int contactId, String firstName, String lastName, String address, String state, String city,
                   String zip, String phone,String email) {
        super();
        this.contactId = contactId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.state = state;
        this.city = city;
        this.zip = zip;
        this.phone = phone;
        this.email=email;
    }


    public Contact(int contactId, ContactDTO contactDTO) {
        super();
        this.contactId = contactId;
        this.firstName = contactDTO.firstName;
        this.lastName = contactDTO.lastName;
        this.address = contactDTO.address;
        this.state = contactDTO.state;
        this.city = contactDTO.city;
        this.zip = contactDTO.zip;
        this.phone = contactDTO.phone;
        this.email=contactDTO.email;
    }
    
}
