package com.anton.project.model;

/**
 * Created by Anton on 17.02.16.
 */


public class BaseEntitiy {
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
}
