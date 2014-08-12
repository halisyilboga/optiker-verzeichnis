package de.optikerverzeichnis.entity;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;

@Entity
public class Optician {

	@Id
	protected Long id;

	protected String name;

    protected String street;

    protected Integer postalcode;

    protected String city;

    protected String country;

    protected String phone;

    protected String fax;

    protected String email;

    protected String website;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Integer getPostalcode() {
        return postalcode;
    }

    public void setPostalcode(Integer postalcode) {
        this.postalcode = postalcode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Optician)) return false;

        Optician optician = (Optician) o;

        if (!city.equals(optician.city)) return false;
        if (!country.equals(optician.country)) return false;
        if (!email.equals(optician.email)) return false;
        if (!fax.equals(optician.fax)) return false;
        if (!name.equals(optician.name)) return false;
        if (!phone.equals(optician.phone)) return false;
        if (!postalcode.equals(optician.postalcode)) return false;
        if (!street.equals(optician.street)) return false;
        if (!website.equals(optician.website)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + street.hashCode();
        result = 31 * result + postalcode.hashCode();
        result = 31 * result + city.hashCode();
        result = 31 * result + country.hashCode();
        result = 31 * result + phone.hashCode();
        result = 31 * result + fax.hashCode();
        result = 31 * result + email.hashCode();
        result = 31 * result + website.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Optician{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", street='" + street + '\'' +
                ", postalcode=" + postalcode +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", phone='" + phone + '\'' +
                ", fax='" + fax + '\'' +
                ", email='" + email + '\'' +
                ", website='" + website + '\'' +
                '}';
    }
}
