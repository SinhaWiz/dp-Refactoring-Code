package edu.iutcs.cr.persons;

import java.io.Serializable;
import java.util.Objects;
import edu.iutcs.cr.io.IOHandler;

/**
 * @author Raian Rahman
 * @since 4/18/2024
 */
public class Person implements Serializable {

    private String name;
    private String id;
    private String email;
    private final IOHandler ioHandler;

    public Person(IOHandler ioHandler) {
        this.ioHandler = ioHandler;
    }

    public Person(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void inputDetails() {
        ioHandler.print("Enter name: ");
        this.name = ioHandler.readLine();
        if (this.name.isEmpty()) {
            ioHandler.println("Name is mandatory!");
        }
    }

    public String getId() {
        return id;
    }

    public void setId() {
        ioHandler.print("Enter id: ");
        this.id = ioHandler.readLine();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail() {
        ioHandler.print("Enter email: ");
        this.email = ioHandler.readLine();
    }

    @Override
    public String toString() {
        return "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", email='" + email + '\'';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person person)) return false;

        return Objects.equals(id, person.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
