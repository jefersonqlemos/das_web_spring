package com.das_web.das_web_spring.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.das_web.das_web_spring.Model.Clients;
import com.das_web.das_web_spring.Repository.ClientsRepository;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class ClientsController {
    @Autowired
    ClientsRepository clientsRepository;

    @RequestMapping("/list-clients")
    public @ResponseBody List<Clients> listClients(){
        System.out.println(clientsRepository.findAll());
        return clientsRepository.findAll();
    }

    @RequestMapping("/client/{id}")
    public @ResponseBody Clients getClient(@PathVariable int id){
        System.out.println(clientsRepository.findById(id));
        return clientsRepository.findById(id);
    }

    @PostMapping("/client")
    public @ResponseBody String postClient(@RequestBody Clients client){
        System.out.println(client);
        clientsRepository.save(client);
        return "OK";
    }

    @PutMapping("/client")
    public @ResponseBody String putClient(@RequestBody Clients client){
        System.out.println(client);
        clientsRepository.save(client);
        return "OK";
    }

    @DeleteMapping("/client/{id}")
    public @ResponseBody String deleteClient(@PathVariable int id){
        System.out.println(id);
        clientsRepository.deleteById(id);
        return "OK";
    }
}
