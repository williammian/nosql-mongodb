package br.com.wm.nosqlmongodb.entity;

public class Phone {
    private String phoneNumber;
    private String mobileNumber;

    public Phone() {
        super();
    }

    public Phone(String phoneNumber, String mobileNumber) {
        this.phoneNumber = phoneNumber;
        this.mobileNumber = mobileNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "phoneNumber='" + phoneNumber + '\'' +
                ", mobileNumber='" + mobileNumber + '\'' +
                '}';
    }
}
