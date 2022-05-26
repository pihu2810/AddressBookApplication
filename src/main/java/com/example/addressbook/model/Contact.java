package com.example.addressbook.model;

import com.example.addressbook.dto.ContactDTO;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "addressbook_DB")
@Data
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Contact_Id")
    private int contactId;
    private String firstName;
    private String lastName;
    private String address;
    private String state;
    private String city;
    private String zip;
    private String phone;
    private String email;

    public Contact(int contactId, ContactDTO contactDTO) {
        super();
        this.contactId = contactId;
        this.updateContact(contactDTO);
    }

    public void  updateContact( ContactDTO contactDTO) {

        this.contactId = contactId;
        this.firstName = contactDTO.firstName;
        this.lastName = contactDTO.lastName;
        this.address = contactDTO.address;
        this.city = contactDTO.city;
        this.state = contactDTO.state;
        this.zip = contactDTO.zip;
        this.phone = contactDTO.phone;
        this.email=contactDTO.email;
    }

    public Contact() {
        super();
        // TODO Auto-generated constructor stub
    }

    @Override
    public String toString() {
        return "Contact [contactId=" + contactId + ", firstName=" + firstName + ", lastName=" + lastName + ", address="
                + address + ", state=" + state + ", city=" + city + ", zip=" + zip + ", phone=" + phone + ",email= " + email+ "]";
    }


}
