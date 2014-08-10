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

    protected Integer plz;

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

    public Integer getPlz() {
        return plz;
    }

    public void setPlz(Integer plz) {
        this.plz = plz;
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

        if (city != null ? !city.equals(optician.city) : optician.city != null) return false;
        if (country != null ? !country.equals(optician.country) : optician.country != null) return false;
        if (email != null ? !email.equals(optician.email) : optician.email != null) return false;
        if (fax != null ? !fax.equals(optician.fax) : optician.fax != null) return false;
        if (name != null ? !name.equals(optician.name) : optician.name != null) return false;
        if (phone != null ? !phone.equals(optician.phone) : optician.phone != null) return false;
        if (plz != null ? !plz.equals(optician.plz) : optician.plz != null) return false;
        if (street != null ? !street.equals(optician.street) : optician.street != null) return false;
        if (website != null ? !website.equals(optician.website) : optician.website != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (street != null ? street.hashCode() : 0);
        result = 31 * result + (plz != null ? plz.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (country != null ? country.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (fax != null ? fax.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (website != null ? website.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Optician{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", street='" + street + '\'' +
                ", plz=" + plz +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", phone='" + phone + '\'' +
                ", fax='" + fax + '\'' +
                ", email='" + email + '\'' +
                ", website='" + website + '\'' +
                '}';
    }
}
