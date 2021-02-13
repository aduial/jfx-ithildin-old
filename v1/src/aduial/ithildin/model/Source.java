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
public class Source{

    private static final long serialVersionUID = 38383838389L;

    private final IntegerProperty      id         = new SimpleIntegerProperty();
    private final StringProperty       name       = new SimpleStringProperty();
    private final StringProperty       prefix     = new SimpleStringProperty();
    private final ObjectProperty<Type> sourceType = new SimpleObjectProperty<>();

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

    public String getPrefix() {
        return prefix.get();
    }

    public void setPrefix(String value) {
        prefix.set(value);
    }

    public StringProperty prefixProperty() {
        return prefix;
    }

    @ManyToOne
    @JoinColumn(name = "sourcetype_id", referencedColumnName = "id")
    public Type getSourceType() {
        return sourceType.get();
    }

    public void setSourceType(Type value) {
        sourceType.set(value);
    }

    public ObjectProperty<Type> sourceTypeProperty() {
        return sourceType;
    }

}
