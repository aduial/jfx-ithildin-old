/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aduial.ithildin.model;

import javafx.beans.property.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * @author luthien
 */
@Entity
public class Cat{

    private static final long serialVersionUID = 12341234L;

    private final IntegerProperty     id     = new SimpleIntegerProperty();
    private final StringProperty      label  = new SimpleStringProperty();
    private final ObjectProperty<Cat> parent = new SimpleObjectProperty<>();

    @Id
    public int getId() {
        return id.get();
    }

    public void setId(int value) {
        id.set(value);
    }

    public IntegerProperty idProperty() {
        return id;
    }

    public String getLabel() {
        return label.get();
    }

    public void setLabel(String value) {
        label.set(value);
    }

    public StringProperty labelProperty() {
        return label;
    }

    @ManyToOne
    @JoinColumn(name = "parent_id", referencedColumnName = "id")
    public Cat getParent() {
        return parent.get();
    }

    public void setParent(Cat value) {
        parent.set(value);
    }

    public ObjectProperty<Cat> parentProperty() {
        return parent;
    }

}
