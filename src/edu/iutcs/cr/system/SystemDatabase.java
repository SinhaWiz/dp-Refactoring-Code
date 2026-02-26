package edu.iutcs.cr.system;

import edu.iutcs.cr.Invoice;
import edu.iutcs.cr.persons.Buyer;
import edu.iutcs.cr.persons.Seller;
import edu.iutcs.cr.vehicles.Vehicle;
import java.io.Serializable;
import static java.util.Objects.isNull;
import java.util.Set;

/**
 * @author Raian Rahman
 * @since 4/19/2024
 */
public class SystemDatabase implements Serializable {

    private Set<Buyer> buyers;
    private Set<Seller> sellers;
    private Set<Vehicle> vehicles;
    private Set<Invoice> invoices;

    private static SystemDatabase instance;

    private SystemDatabase() {
        DataStore dataStore = new DataStore();

        buyers = dataStore.loadBuyers();
        sellers = dataStore.loadSellers();
        vehicles = dataStore.loadVehicles();
        invoices = dataStore.loadInvoices();
    }

    public static SystemDatabase getInstance() {
        if (isNull(instance)) {
            instance = new SystemDatabase();
        }

        return instance;
    }

    public void saveSystem() {
        DataStore dataStore = new DataStore();

        dataStore.saveBuyers(buyers);
        dataStore.saveSellers(sellers);
        dataStore.saveVehicles(vehicles);
        dataStore.saveInvoices(invoices);
    }

    public Set<Buyer> getBuyers() {
        return buyers;
    }

    public Set<Seller> getSellers() {
        return sellers;
    }

    public Set<Vehicle> getVehicles() {
        return vehicles;
    }

    public Set<Invoice> getInvoices() {
        return invoices;
    }

}
