package com.das_web.das_web_spring.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cliente")
public class Clientes {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column
    private int id;

    @Column
    private String nome;

    @Column
    private String sobrenome;

    @Column
    private String cpf;

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getNome(){
        return nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public String getSobrenome(){
        return sobrenome;
    }

    public void setSobrenome(String sobrenome){
        this.sobrenome = sobrenome;
    }

    public String Cpf(){
        return cpf;
    }

    public void setCpf(String cpf){
        this.cpf = cpf;
    }

}
