package com.anton.project.model;

import javax.persistence.*;

/**
 * Created by Anton on 17.02.16.
 */

@MappedSuperclass
//@Access(AccessType.FIELD)
public class BaseEntitiy {

    @Id
    @SequenceGenerator(name="global_seq", sequenceName = "global_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "global_seq")
    protected Integer id;

    public BaseEntitiy() {
    }

    public BaseEntitiy(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BaseEntitiy that = (BaseEntitiy) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id != null ? id : 0;
    }

    public boolean isNew() {
        return id == null;
    }
}
