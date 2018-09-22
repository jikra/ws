package hello;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Greeting {

    @NotNull
    @Size(min = 2, message = "chyba...")
    private String name;

    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Greeting{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
