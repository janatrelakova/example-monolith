package cz.muni.fi.xtrelak.dto;

public class BaseDto {

    private String name;
    private final int id;

    public BaseDto(int id, String name) {
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
