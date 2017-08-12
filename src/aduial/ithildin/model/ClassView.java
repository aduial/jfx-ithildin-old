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
public class ClassView {
  
    private static final long serialVersionUID = 543254253L;

    private final IntegerProperty entryid = new SimpleIntegerProperty();
    private final StringProperty mark = new SimpleStringProperty();
    private final IntegerProperty lgorder = new SimpleIntegerProperty();
    private final StringProperty grammartxt = new SimpleStringProperty();
    private final StringProperty grammartypetxt = new SimpleStringProperty();
    private final IntegerProperty grammarid = new SimpleIntegerProperty();

    @Id
    public int getEntryid() {
      return entryid.get();
    }

    public void setEntryid(int value) {
      entryid.set(value);
    }

    public IntegerProperty entryidProperty() {
        return entryid;
    }
    
    public String getMark() {
      return mark.get();
    }

    public void setMark(String value) {
      mark.set(value);
    }

    public StringProperty markProperty() {
        return mark;
    }
    
    public int getLgorder() {
      return lgorder.get();
    }

    public void setLgorder(int value) {
      lgorder.set(value);
    }

    public IntegerProperty lgorderProperty() {
        return lgorder;
    }
    
    public String getGrammartxt() {
      return grammartxt.get();
    }

    public void setGrammartxt(String value) {
      grammartxt.set(value);
    }

    public StringProperty grammartxtProperty() {
        return grammartxt;
    }
    
    public String getGrammartypetxt() {
      return grammartypetxt.get();
    }

    public void setGrammartypetxt(String value) {
      grammartypetxt.set(value);
    }

    public StringProperty grammartypetxtProperty() {
        return grammartypetxt;
    }
    
    public int getGrammarid() {
      return grammarid.get();
    }

    public void setGrammarid(int value) {
      grammarid.set(value);
    }

    public IntegerProperty grammaridProperty() {
        return grammarid;
    }

}
