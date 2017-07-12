/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aduial.ithildin.model;

import java.beans.PropertyChangeSupport;
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
public class Language {
  
    private static final long serialVersionUID = 1L;

    private final IntegerProperty id = new SimpleIntegerProperty();
    private final StringProperty name = new SimpleStringProperty();
    private final StringProperty mnemonic = new SimpleStringProperty();
    private final ObjectProperty<Language> parent = new SimpleObjectProperty<>();

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
    
    public String getName() {
      return name.get();
    }

    public void setName(String value) {
      name.set(value);
    }

    public StringProperty nameProperty() {
        return name;
    }
    
    public String getMnemonic() {
      return mnemonic.get();
    }

    public void setMnemonic(String value) {
      mnemonic.set(value);
    }

    public StringProperty mnemonicProperty() {
        return mnemonic;
    }
    
    @ManyToOne
    @JoinColumn(name = "parent_id", referencedColumnName = "id")
    public Language getParent() {
        return parent.get();
    }

    public void setParent(Language value) {
        parent.set(value);
    }

    public ObjectProperty<Language> parentProperty() {
        return parent;
    }

}
