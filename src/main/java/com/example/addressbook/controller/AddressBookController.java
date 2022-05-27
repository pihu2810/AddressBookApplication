package com.example.addressbook.controller;

import com.example.addressbook.dto.ContactDTO;
import com.example.addressbook.dto.ResponseDTO;
import com.example.addressbook.model.Contact;
import com.example.addressbook.service.IAddressBookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/addressbook")
@Slf4j
public class AddressBookController {
    @Autowired
    private IAddressBookService addressbookservice;

    @GetMapping(value = { "", "/", "/get" })
    public ResponseEntity<ResponseDTO> getContactData() {

        List<Contact> contactData = addressbookservice.getContact();
        log.debug("Address Book DTO: " +contactData.toString());
        ResponseDTO response = new ResponseDTO("Get call success", contactData);
        return new ResponseEntity<ResponseDTO>(response, HttpStatus.OK);
    }


    @GetMapping("/get/{contactId}")
    public ResponseEntity<ResponseDTO> getContactData(@PathVariable("contactId") int contactId) {
        Contact contactData = addressbookservice.getContactById(contactId);
        ResponseDTO response = new ResponseDTO("Get call success for id", contactData);
        return new ResponseEntity<ResponseDTO>(response, HttpStatus.OK);

    }

    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> createContactData(@Valid @RequestBody ContactDTO contactDTO) {
        Contact contactData = addressbookservice.createContact(contactDTO);
        log.debug("Address Book DTO: " +contactData.toString());
        ResponseDTO response = new ResponseDTO("Created contact data for", contactData);
        return new ResponseEntity<ResponseDTO>(response, HttpStatus.OK);

    }

    @PutMapping("/update/{contactId}")
    public ResponseEntity<ResponseDTO> updateContactDataById(@PathVariable("contactId") int contactId,
                                                         @Valid @RequestBody ContactDTO contactDTO) {
        Contact contactData = addressbookservice.updateContact(contactId, contactDTO);
        log.debug("AddressBook Contact After Update " + contactData.toString());

        ResponseDTO response = new ResponseDTO("Updated contact data for", contactData);
        return new ResponseEntity<ResponseDTO>(response, HttpStatus.OK);

    }

    @DeleteMapping("/delete/{contactId}")
    public ResponseEntity<ResponseDTO> deleteContactData(@PathVariable("contactId") int contactId) {
        addressbookservice.deleteContact(contactId);

        ResponseDTO response = new ResponseDTO("Delete call success for id ", "deleted id:" + contactId);
        return new ResponseEntity<ResponseDTO>(response, HttpStatus.OK);
    }

    @GetMapping("/sortbystate")
    public ResponseEntity<ResponseDTO> sortByState() {
        List<Contact> contactList = null;
        contactList = addressbookservice.sortByState();
        ResponseDTO response = new ResponseDTO("Get Call  is Successful Sort By State: ", contactList);
        return new ResponseEntity<ResponseDTO>(response, HttpStatus.OK);
    }

    @GetMapping("/sortbycity")
    public ResponseEntity<ResponseDTO> sortByCity() {
        List<Contact> contactList = null;
        contactList = addressbookservice.sortByCity();
        ResponseDTO response = new ResponseDTO("Get Call  is Successful Sort By City: ", contactList);
        return new ResponseEntity<ResponseDTO>(response, HttpStatus.OK);
    }



}
