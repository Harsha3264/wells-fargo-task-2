package com.wellsfargo.counselor.entity;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Portfolio {

    @Id
    @GeneratedValue()
    private long portfolioId;

    @Column(nullable = false)
    private String name;

    @Column
    private String description;

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;

    @OneToMany(mappedBy = "portfolio", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Security> securities = new ArrayList<>();

    protected Portfolio() {
    }

    public Portfolio(String name, Client client) {
        this.name = name;
        this.client = client;
    }

    public Portfolio(String name, String description, Client client) {
        this.name = name;
        this.description = description;
        this.client = client;
    }

    public Long getPortfolioId() {
        return portfolioId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Client getClient() {
        return client;
    }

    public List<Security> getSecurities() {
        return securities;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void setSecurities(List<Security> securities) {
        this.securities = securities;
    }
}
