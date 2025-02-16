package com.startup.course.data.vo.v1;

import org.springframework.hateoas.RepresentationModel;
import org.springframework.web.bind.annotation.Mapping;

import java.io.Serializable;
import java.util.Objects;

public class PersonVO extends RepresentationModel<PersonVO> implements Serializable {


    private Long key;
//    @JsonProperty("first_name")
    private String firstName;
//    @JsonProperty("last_name") apresentar dessa forma na serializaçao
    private String lastName;

    private String address;

    private String gender;

    public PersonVO() {
    }

    public Long getKey() {
        return key;
    }

    public void setKey(Long key) {
        this.key = key;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonVO personVO = (PersonVO) o;
        return Objects.equals(key, personVO.key) && Objects.equals(firstName, personVO.firstName) && Objects.equals(lastName, personVO.lastName) && Objects.equals(address, personVO.address) && Objects.equals(gender, personVO.gender);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key, firstName, lastName, address, gender);
    }
}
