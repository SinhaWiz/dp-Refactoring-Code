package edu.iutcs.cr.persons;

import java.io.Serializable;

/**
 * @author Raian Rahman
 * @since 4/18/2024
 */
public class Seller extends Person implements Serializable {

    public Seller(String name, String id, String email) {
        super(name, id, email);
    }

    /** Lookup-only constructor — only id is required for equality checks. */
    public Seller(String id) {
        super(id);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
