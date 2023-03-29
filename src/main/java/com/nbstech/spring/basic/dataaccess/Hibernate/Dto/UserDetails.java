package com.nbstech.spring.basic.dataaccess.Hibernate.Dto;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "USER_DETAILS")
public class UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userId;

    private String name;

    @Embedded
    private Address address;

    @ElementCollection
    @JoinTable(name="USER_TRAVEL_ADDRESS",
            joinColumns = @JoinColumn(name="USER_ID")
    )
    private Set<Address> travelAddresses = new HashSet<>();

    //    @ElementCollection(fetch = FetchType.LAZY) // default
    @ElementCollection(fetch = FetchType.EAGER)
    @JoinTable(name="USER_ADDRESS",
            joinColumns = @JoinColumn(name="USER_ID")
    )
    private Collection<Address> listOfAddresses = new ArrayList<Address>();

    public UserDetails( ) {

    }

    public UserDetails(String name) {
        super();
        this.name = name;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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

    public Collection<Address> getListOfAddresses() {
        return listOfAddresses;
    }
    public void setListOfAddresses(Collection<Address> listOfAddresses) {
        this.listOfAddresses = listOfAddresses;
    }

    @Override
    public String toString() {
        return "UserDetails: ";
    }
}
