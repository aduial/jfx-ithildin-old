package aduial.ithildin.model;

import javafx.beans.property.*;

/**
 * Created by luthien on 02/07/2017.
 */
public class User{
    private IntegerProperty id;
    private StringProperty  firstname;
    private StringProperty  lastname;

    //    public User(IntegerProperty id, StringProperty firstname, StringProperty lastname) {
    //        this.id = id;
    //        this.firstname = firstname;
    //        this.lastname = lastname;
    //    }

    public User() {
        this.id        = new SimpleIntegerProperty();
        this.firstname = new SimpleStringProperty();
        this.lastname  = new SimpleStringProperty();

    }

    public int getId() {
        return id.get();
    }

    public IntegerProperty idProperty() {
        return id;
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public String getFirstname() {
        return firstname.get();
    }

    public StringProperty firstnameProperty() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname.set(firstname);
    }

    public String getLastname() {
        return lastname.get();
    }

    public StringProperty lastnameProperty() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname.set(lastname);
    }
}
