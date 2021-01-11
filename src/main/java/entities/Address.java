/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author sumit
 */
@Entity
public class Address implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String street;
    
    @OneToMany(mappedBy = "address", cascade = CascadeType.PERSIST)
    private List<User> users ;
    
    @ManyToOne(cascade = CascadeType.PERSIST)
    private CityInfo cityInfo;

    public Address(String street) {
        this.street = street;
        this.users = new ArrayList();
       
    }

    public Address() {
    }

    public CityInfo getCityInfo() {
        return cityInfo;
    }

    public void setCityInfo(CityInfo cityInfo) {
        if(cityInfo !=null){
            cityInfo.getAddresses().add(this);
            this.cityInfo = cityInfo;
        }
    }

    public String getAddress() {
        return street;
    }

    public void setAddress(String address) {
        this.street = address;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(User user) {
        if(user != null){
            user.setAddress(this);
            this.users.add(user);
        }
    }
 
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public void deleteCityInfo(CityInfo cityInfo){
        if(cityInfo != null){  
            cityInfo.getAddresses().remove(this);
        }
        this.setCityInfo(null);
    }


    
}
