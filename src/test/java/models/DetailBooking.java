package models;


import java.util.List;

public class DetailBooking {
    private String firstname;
    private String lastname;
    private String totalprice;
    private String depositpaid;

    public CheckBooking getCheckBooking() {
        return checkBooking;
    }

    public void setCheckBooking(CheckBooking checkBooking) {
        this.checkBooking = checkBooking;
    }

    private CheckBooking checkBooking;
    //private List<CheckBooking> data = null;
    private String additionalneeds;

    public String getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(String totalprice) {
        this.totalprice = totalprice;
    }

    public String getDepositpaid() {
        return depositpaid;
    }

    public void setDepositpaid(String depositpaid) {
        this.depositpaid = depositpaid;
    }



    // Getter Methods

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }


    public String getAdditionalneeds() {
        return additionalneeds;
    }

    // Setter Methods

    public void setFirstname( String firstname ) {
        this.firstname = firstname;
    }

    public void setLastname( String lastname ) {
        this.lastname = lastname;
    }


    public void setAdditionalneeds( String additionalneeds ) {
        this.additionalneeds = additionalneeds;
    }


}
