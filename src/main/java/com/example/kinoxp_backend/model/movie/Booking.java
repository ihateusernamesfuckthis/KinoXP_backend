package com.example.kinoxp_backend.model.movie;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Booking {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String customerName;

     public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

}
