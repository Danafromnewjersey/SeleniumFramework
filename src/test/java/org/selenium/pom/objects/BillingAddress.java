package org.selenium.pom.objects;

public class BillingAddress {

    private String firstName;
    private String lastName;
    private String addressLineOne;
    private String city;
    private String postCode;
    private String email;
    private String phone;
    private String country;
    private String state;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    private String companyName;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public BillingAddress() {
    }

    public String getFirstName() {
        return firstName;
    }

    public BillingAddress setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public BillingAddress setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getAddressLineOne() {
        return addressLineOne;
    }

    public BillingAddress setAddressLineOne(String addressLineOne) {
        this.addressLineOne = addressLineOne;
        return this;
    }

    public String getCity() {
        return city;
    }

    public BillingAddress setCity(String city) {
        this.city = city;
        return this;
    }

    public String getPostCode() {
        return postCode;
    }

    public BillingAddress setPostCode(String postCode) {
        this.postCode = postCode;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public BillingAddress setEmail(String email) {
        this.email = email;
        return this;
    }
    public BillingAddress (String firstName, String lastName, String companyName, String addressLineOne, String city,
                           String postCode, String phone, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.companyName = companyName;
        this.addressLineOne = addressLineOne;
        this.city = city;
        this.postCode = postCode;
        this.phone = phone;
        this.email = email;
    }
}
