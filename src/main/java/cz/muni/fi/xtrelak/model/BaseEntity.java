package cz.muni.fi.xtrelak.model;

public class BaseEntity {

    private String name;
    private final int id;

    public BaseEntity(int id, String name) {
        this.name = name;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
