package cz.muni.fi.xtrelak.dto;


import cz.muni.fi.xtrelak.model.User;

public class UserDto extends BaseDto {

    public UserDto() {
        super(0, "");
    }

    public UserDto(int id, String name) {
        super(id, name);
    }

    public User toUserModel() {
        return new User(this.getId(), this.getName());
    }
}
