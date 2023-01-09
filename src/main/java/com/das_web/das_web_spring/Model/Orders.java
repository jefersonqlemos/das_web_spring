package com.das_web.das_web_spring.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "orders")
public class Orders {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column
    private int id;

    @Column
    private float totalValue;

    @Column
    private int clientId;

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public float getTotalValue(){
        return totalValue;
    }

    public void setTotalValue(float totalValue){
        this.totalValue = totalValue;
    }

    public int getClientId(){
        return clientId;
    }

    public void setClientId(int clientId){
        this.clientId = clientId;
    }

}
