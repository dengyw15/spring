package bean;

public class User {

    private Integer id;
    private String name;
    private String gender;

    public Integer getId() {
        return id;
    }

    public User setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public User setName(String name) {
        this.name = name;
        return this;
    }

    public String getGender() {
        return gender;
    }

    public User setGender(String gender) {
        this.gender = gender;
        return this;
    }

    @Override
    public String toString() {
        return this.id + " " + this.name + " " + this.gender;
    }
}
