/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aduial.ithildin.model;

import javafx.beans.property.*;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author luthien
 */
@Entity
public class Grammar {
  
    private static final long serialVersionUID = 45938745874L;

    private final IntegerProperty id = new SimpleIntegerProperty();
    private final StringProperty txt = new SimpleStringProperty();

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

}
