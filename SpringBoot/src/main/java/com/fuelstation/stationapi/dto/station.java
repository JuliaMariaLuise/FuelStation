package com.fuelstation.dto;

public class Station {

    private Long id;
    private String address;
    private String fuelType;
    private int plz;
    private int numTransaction;
    private int customerId;

    // Getters und Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public int getPlz() {
        return plz;
    }

    public void setPlz(int plz) {
        this.plz = plz;
    }

    public int getNumTransaction() {
        return numTransaction;
    }

    public void setNumTransaction(int numTransaction) {
        this.numTransaction = numTransaction;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    @Override
    public String toString() {
        return "Station{" +
                "id=" + id +
                ", address='" + address + '\'' +
                ", fuelType='" + fuelType + '\'' +
                ", plz=" + plz +
                ", numTransaction=" + numTransaction +
                ", customerId=" + customerId +
                '}';
    }
}
