package com.example.addressbook.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

public @Data class ContactDTO {
    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$", message = "Firstname Invalid ")
    @NotEmpty(message = "first name cannot be null")
    public String firstName;

    @Pattern(regexp = "^[A-Z]{1,}[a-zA-z\\s]{2,}$", message = "Lastname Invalid!!! ")
    @NotEmpty(message = "last name cannot be null")
    public String lastName;

    @Pattern(regexp = "^[A-Za-z,.0-9]{3,}$", message = "Address Invalid!!! ")
    @NotEmpty(message = "Address cannot be null")
    public String address;

    @Pattern(regexp = "^[A-Z]{1,}[a-zA-z\\s]{2,}$", message = "State Invalid!!! ")
    @NotEmpty(message = "State cannot be null")
    public String state;
    @Pattern(regexp = "^[A-Z]{1,}[a-zA-z\\s]{2,}$", message = "City Invalid!!! ")
    @NotEmpty(message = "City cannot be null")
    public String city;

    @Pattern(regexp = "^[0-9]{3}\\s{0,1}[0-9]{3}$", message = "Invalid Zip")
    @NotEmpty(message = "zip cannot be null")
    public String zip;

    @Pattern(regexp = "^[0-9]{2}?[\\s,-]{0,1}[7-9]{1}[0-9]{9}$", message = "Invalid Phone number")
    @NotEmpty(message = "Phone number cannot be null")
    public String phone;
    @Pattern(regexp = "^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9]+(?:\\.[a-zA-Z0-9]+)*$", message = "EmailInvalid")
    @NotEmpty(message = "Email cannot be null")
    public String email;


    public ContactDTO(String firstName, String lastName, String address, String city, String state, String zip,
                      String phone , String email) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.phone = phone;
        this.email= email;
    }

    @Override
    public String toString() {
        return "ContactDTO [firstName=" + firstName + ", lastName=" + lastName + ", address=" + address + ", state="
                + state + ", city=" + city + ", zip=" + zip + ", phone=" + phone +   ",email=" + email +"]";
    }

}
