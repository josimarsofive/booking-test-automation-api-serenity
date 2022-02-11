package models;

public class CheckBooking {
    private String checkin;
    private String checkout;

    public CheckBooking(String checkin,String checkout){
        this.checkin=checkin;
        this.checkout=checkout;
    }

    // Getter Methods

    public String getCheckin() {
        return checkin;
    }

    public String getCheckout() {
        return checkout;
    }

    // Setter Methods

    public void setCheckin( String checkin ) {
        this.checkin = checkin;
    }

    public void setCheckout( String checkout ) {
        this.checkout = checkout;
    }
}
