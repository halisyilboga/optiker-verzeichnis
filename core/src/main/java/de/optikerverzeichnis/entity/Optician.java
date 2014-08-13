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

    // "types" : [ "street_number" ]
    protected String mapsStreetNumber;

    // "types" : [ "route" ]
    protected String mapsStreet;

    // "types" : [ "sublocality_level_2", "sublocality", "political" ]
    protected String mapsDistrict;

    // "types" : [ "sublocality_level_1", "sublocality", "political" ]
    protected String mapsArea;

    // "types" : [ "locality", "political" ]
    protected String mapsCity;

    // "types" : [ "administrative_area_level_1", "political" ]
    protected String mapsState;

    // "types" : [ "country", "political" ]
    protected String mapsCountry;

    // "types" : [ "postal_code" ]
    protected String mapsPostalCode;

    protected double mapsLongitude;

    protected double mapsLatitude;

    public String getMapsStreetNumber() {
        return mapsStreetNumber;
    }

    public void setMapsStreetNumber(String mapsStreetNumber) {
        this.mapsStreetNumber = mapsStreetNumber;
    }

    public String getMapsStreet() {
        return mapsStreet;
    }

    public void setMapsStreet(String mapsStreet) {
        this.mapsStreet = mapsStreet;
    }

    public String getMapsDistrict() {
        return mapsDistrict;
    }

    public void setMapsDistrict(String mapsDistrict) {
        this.mapsDistrict = mapsDistrict;
    }

    public String getMapsArea() {
        return mapsArea;
    }

    public void setMapsArea(String mapsArea) {
        this.mapsArea = mapsArea;
    }

    public String getMapsCity() {
        return mapsCity;
    }

    public void setMapsCity(String mapsCity) {
        this.mapsCity = mapsCity;
    }

    public String getMapsState() {
        return mapsState;
    }

    public void setMapsState(String mapsState) {
        this.mapsState = mapsState;
    }

    public String getMapsCountry() {
        return mapsCountry;
    }

    public void setMapsCountry(String mapsCountry) {
        this.mapsCountry = mapsCountry;
    }

    public String getMapsPostalCode() {
        return mapsPostalCode;
    }

    public void setMapsPostalCode(String mapsPostalCode) {
        this.mapsPostalCode = mapsPostalCode;
    }

    public double getMapsLongitude() {
        return mapsLongitude;
    }

    public void setMapsLongitude(double mapsLongitude) {
        this.mapsLongitude = mapsLongitude;
    }

    public double getMapsLatitude() {
        return mapsLatitude;
    }

    public void setMapsLatitude(double mapsLatitude) {
        this.mapsLatitude = mapsLatitude;
    }

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

        if (Double.compare(optician.mapsLatitude, mapsLatitude) != 0) return false;
        if (Double.compare(optician.mapsLongitude, mapsLongitude) != 0) return false;
        if (!city.equals(optician.city)) return false;
        if (!country.equals(optician.country)) return false;
        if (!email.equals(optician.email)) return false;
        if (!fax.equals(optician.fax)) return false;
        if (mapsArea != null ? !mapsArea.equals(optician.mapsArea) : optician.mapsArea != null) return false;
        if (mapsCity != null ? !mapsCity.equals(optician.mapsCity) : optician.mapsCity != null) return false;
        if (mapsCountry != null ? !mapsCountry.equals(optician.mapsCountry) : optician.mapsCountry != null)
            return false;
        if (!mapsDistrict.equals(optician.mapsDistrict)) return false;
        if (mapsPostalCode != null ? !mapsPostalCode.equals(optician.mapsPostalCode) : optician.mapsPostalCode != null)
            return false;
        if (mapsState != null ? !mapsState.equals(optician.mapsState) : optician.mapsState != null) return false;
        if (!mapsStreet.equals(optician.mapsStreet)) return false;
        if (!mapsStreetNumber.equals(optician.mapsStreetNumber)) return false;
        if (!name.equals(optician.name)) return false;
        if (!phone.equals(optician.phone)) return false;
        if (!postalcode.equals(optician.postalcode)) return false;
        if (!street.equals(optician.street)) return false;
        if (!website.equals(optician.website)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = name.hashCode();
        result = 31 * result + street.hashCode();
        result = 31 * result + postalcode.hashCode();
        result = 31 * result + city.hashCode();
        result = 31 * result + country.hashCode();
        result = 31 * result + phone.hashCode();
        result = 31 * result + fax.hashCode();
        result = 31 * result + email.hashCode();
        result = 31 * result + website.hashCode();
        result = 31 * result + mapsStreetNumber.hashCode();
        result = 31 * result + mapsStreet.hashCode();
        result = 31 * result + mapsDistrict.hashCode();
        result = 31 * result + (mapsArea != null ? mapsArea.hashCode() : 0);
        result = 31 * result + (mapsCity != null ? mapsCity.hashCode() : 0);
        result = 31 * result + (mapsState != null ? mapsState.hashCode() : 0);
        result = 31 * result + (mapsCountry != null ? mapsCountry.hashCode() : 0);
        result = 31 * result + (mapsPostalCode != null ? mapsPostalCode.hashCode() : 0);
        temp = Double.doubleToLongBits(mapsLongitude);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(mapsLatitude);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
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
                ", mapsStreetNumber='" + mapsStreetNumber + '\'' +
                ", mapsStreet='" + mapsStreet + '\'' +
                ", mapsDistrict='" + mapsDistrict + '\'' +
                ", mapsArea='" + mapsArea + '\'' +
                ", mapsCity='" + mapsCity + '\'' +
                ", mapsState='" + mapsState + '\'' +
                ", mapsCountry='" + mapsCountry + '\'' +
                ", mapsPostalCode='" + mapsPostalCode + '\'' +
                ", mapsLongitude=" + mapsLongitude +
                ", mapsLatitude=" + mapsLatitude +
                '}';
    }
}
