package lld.hotelroombooking;
// For simplicity, we are not defining getter and setter functions. The reader can

// assume that all class attributes are private and accessed through their respective
// public getter method and modified only through their public setter method.

public abstract class Account {
    private String id;
    private String password;
    private AccountStatus status;

    public boolean resetPassword() {
        return false;
    }
}
