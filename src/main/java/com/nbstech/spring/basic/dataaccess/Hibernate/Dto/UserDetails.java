package com.nbstech.spring.basic.dataaccess.Hibernate.Dto;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @Embedded
    private Address address;

    @ElementCollection
    private Set<Address> travelAddresses = new HashSet<>();

    public UserDetails( ) {

    }

    public UserDetails(String name) {
        super();
        this.name = name;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }



    @Override
    public String toString() {
        return "UserDetails: ";
    }
}
