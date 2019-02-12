package com.mahtzak.giveAwayThingsApp.domain.model;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name="user_details")
public class UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String address="";
    @NotNull
    @Size(min=7)
    @Pattern(regexp = "[0-9]+")
    @Column(name="phone_number")
    private String phoneNumber="";
    @NotNull
    @Column(name="first_name")
    @Size(min=3)
    private String firstName="";
    @NotNull
    @Size(min=2)
    @Column(name="last_name")
    private String lastName="";
    @Column
    private Integer bags = 0;
    @Column
    private Integer organisations = 0;
    @Column
    private Integer fundraisers = 0;

    @OneToOne/*(mappedBy = "userDetails")*/
    private User user;


    public Integer getBags() {
        return bags;
    }

    public void setBags(Integer bags) {
        this.bags = bags;
    }

    public Integer getOrganisations() {
        return organisations;
    }

    public void setOrganisations(Integer organisations) {
        this.organisations = organisations;
    }

    public Integer getFundraisers() {
        return fundraisers;
    }

    public void setFundraisers(Integer fundraisers) {
        this.fundraisers = fundraisers;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
