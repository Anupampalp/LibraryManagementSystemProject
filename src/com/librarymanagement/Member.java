package com.librarymanagement;

public class Member {
    private int memberId;
    private String name;
    private String email;
    private String contactNumber;

    public Member(int memberId, String name, String email, String contactNumber) {
        this.memberId = memberId;
        this.name = name;
        this.email = email;
        this.contactNumber = contactNumber;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }
}
