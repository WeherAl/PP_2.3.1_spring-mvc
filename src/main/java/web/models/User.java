package web.models;

import javax.persistence.*;

@Entity
@Table(name = "users")

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "lastname")
    private String lastName;

    @Column(name = "age")
    private Byte age;

    public User() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Byte getAge() {
        return age;
    }

    public void setAge(Byte age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{id: " + id + ", name: " + name + ", lastName: " + lastName + ", age: " + age + "}";
    }

    @Override
    public int hashCode() {

        final int prime = 31;
        int result = age;
        result = prime * result + ((name == null) ? 0 : name.hashCode());

        result = prime * result + id; result = prime * result +
                ((lastName == null) ? 0 : lastName.hashCode()); return result;

    }

    @Override
    public boolean equals(Object obj) {

        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        User user = (User) obj;
        return id == user.id
                && ((age == user.getAge()) &&
                name == user.getName() || (name != null && name.equals(user.getName()))) &&
                (lastName == user.lastName || (lastName != null && lastName.equals(user.getLastName())));
    }
}