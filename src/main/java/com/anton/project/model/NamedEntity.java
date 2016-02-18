package com.anton.project.model;

/**
 * Created by Anton on 17.02.16.
 */
public class NamedEntity extends BaseEntitiy {
    protected String name;

    public NamedEntity() {
    }

    public NamedEntity(Integer id, String name) {
        super(id);
        this.name = name;
    }
}
