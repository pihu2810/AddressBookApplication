package com.example.addressbook.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

public @Data class ContactDTO {
    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$", message = "Address book is FirstNameInvalid ")
    @NotEmpty(message = "first name cannot be null")
    public String firstName;
    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$", message = "Address book is LastNameInvalid")
    @NotEmpty(message = "Last name cannot be null")
    public String lastName;
    public String address;
    public String state;
    public String city;
    @Pattern(regexp = "^[0-9]{3}\\s{0,1}[0-9]{3}$")
    public String zip;
    @Pattern(regexp = "^[0-9]{2}?[\\s,-]{0,1}[7-9]{1}[0-9]{9}$")
    public String phone;
    @Pattern(regexp = "^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9]+(?:\\.[a-zA-Z0-9]+)*$")
    public String email;

    public ContactDTO(String firstName, String lastName, String address, String state, String city, String zip,
                      String phone, String email) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.state = state;
        this.city = city;
        this.zip = zip;
        this.phone = phone;
        this.email= email;
    }


    @Override
    public String toString() {
        return "ContactDTO [firstName=" + firstName + ", lastName=" + lastName + ", address=" + address + ", state="
                + state + ", city=" + city + ", zip=" + zip + ", phone=" + phone +  ", email=" + email +  "]";
    }
}
