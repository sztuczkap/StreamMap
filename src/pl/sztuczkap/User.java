package pl.sztuczkap;

import java.math.BigDecimal;
import java.util.List;

public class User {

    private Integer id;
    private String name;
    private Integer age;
    private BigDecimal salary;
    private List<String> hobbies;

    public User(Integer id, String name, Integer age, List<String> hobbies) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.hobbies = hobbies;
    }

    public User(Integer id, String name, Integer age, BigDecimal salary, List<String> hobbies) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.hobbies = hobbies;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public List<String> getHobbies() {
        return hobbies;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (id != null ? !id.equals(user.id) : user.id != null) return false;
        if (name != null ? !name.equals(user.name) : user.name != null) return false;
        if (age != null ? !age.equals(user.age) : user.age != null) return false;
        if (salary != null ? !salary.equals(user.salary) : user.salary != null) return false;
        return hobbies != null ? hobbies.equals(user.hobbies) : user.hobbies == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (age != null ? age.hashCode() : 0);
        result = 31 * result + (salary != null ? salary.hashCode() : 0);
        result = 31 * result + (hobbies != null ? hobbies.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                ", hobbies=" + hobbies +
                '}';
    }
}
