package com.example.addressbook.service;

import com.example.addressbook.dto.ContactDTO;
import com.example.addressbook.exception.AddressBookException;
import com.example.addressbook.model.Contact;
import com.example.addressbook.repository.AddressBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AddressBookService implements IAddressBookService {

    @Autowired
    private AddressBookRepository addressBookRepository;

    List<Contact> contactList = new ArrayList<Contact>();

    @Override
    public List<Contact> getContact() {

        return contactList;
    }

    @Override
    public Contact getContactById(int contactId) {

        return contactList.stream().filter(contact -> contact.getContactId() == contactId).findFirst()
                .orElseThrow(() -> new AddressBookException("Contact not found"));
    }

    @Override
    public Contact createContact(ContactDTO contactDTO) {
        Contact contactData = new Contact(contactList.size()+1, contactDTO);

        contactList.add(contactData);
        return addressBookRepository.save(contactData);
    }

    @Override
    public Contact updateContact(int contactId, ContactDTO contactDTO) {
        Contact contact = this.getContactById(contactId);
        contact.setFirstName(contactDTO.firstName);
        contact.setLastName(contactDTO.lastName);
        contact.setAddress(contactDTO.address);
        contact.setState(contactDTO.state);
        contact.setCity(contactDTO.city);
        contact.setZip(contactDTO.zip);
        contact.setPhone(contactDTO.phone);
        contact.setEmail(contactDTO.email);
        contactList.set(contactId - 1, contact);
        return contact;
    }

    @Override
    public void deleteContact(int contactId) {
        contactList.remove(contactId-1);

    }
}
