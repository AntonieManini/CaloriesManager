package com.anton.project.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

/**
 * Created by Anton on 17.02.16.
 */

@MappedSuperclass
public class NamedEntity extends BaseEntitiy {
    @NotEmpty
    @Column(name="name", nullable = false)
    protected String name;

    public NamedEntity() {
    }

    public NamedEntity(Integer id, String name) {
        super(id);
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return name;
    }
}
