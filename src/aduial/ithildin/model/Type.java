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
 *
 * @author luthien
 */
@Entity
public class Type {
  
    private static final long serialVersionUID = 34343878734837L;

    private final IntegerProperty id = new SimpleIntegerProperty();
    private final StringProperty txt = new SimpleStringProperty();
    private final ObjectProperty<Type> parent = new SimpleObjectProperty<>();

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
    
    public String getTxt() {
      return txt.get();
    }

    public void setTxt(String value) {
      txt.set(value);
    }

    public StringProperty txtProperty() {
        return txt;
    }
    
    @ManyToOne
    @JoinColumn(name = "parent_id", referencedColumnName = "id")
    public Type getParent() {
        return parent.get();
    }

    public void setParent(Type value) {
        parent.set(value);
    }

    public ObjectProperty<Type> parentProperty() {
        return parent;
    }

}
