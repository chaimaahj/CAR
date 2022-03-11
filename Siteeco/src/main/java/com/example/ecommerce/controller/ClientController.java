package com.example.ecommerce.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.example.ecommerce.repositories.ClientRepository;
import com.example.ecommerce.entities.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@Controller
public class ClientController {

    private static List<Client> clients = new ArrayList<Client>();

    @Autowired
    ClientRepository client;


    @RequestMapping(value = {"/addClient"}, method = RequestMethod.GET)
    public String showAddClientPage(Model model) {

        ClientForm clientForm = new ClientForm();
        model.addAttribute("clientForm", clientForm);

        return "addClient";
    }

    @RequestMapping(value={"/clientInformation"},method = RequestMethod.GET)
    public String clientIN(){
        return "CltInfo";
    }

    @RequestMapping(value = {"/addClient"}, method = RequestMethod.POST)
    public String savePerson(Map<String, Object> model, //
                             @ModelAttribute("clientForm") ClientForm clientForm) {

        String login = clientForm.getLogin();
        String nom = clientForm.getNom();
        String prenom = clientForm.getPrenom();
        String password = clientForm.getPassword();

        String email = clientForm.getEmail();

        if (nom != null && nom.length() > 0 //
                && prenom != null && prenom.length() > 0) {
            Client newClient = new Client(login, password, prenom, nom, email);
            clients.add(newClient);
            client.save(newClient);


            for (Client client : client.findAll()) {
                System.out.println("     " + client);
            }
            model.put("client", newClient);
        }

        return "CltInfo";
    }

    @RequestMapping(value="/sigin")
    public String login(@Param("login") String login,@Param("password") String password , HttpServletRequest request) {
        Client user= client.findByLogin(login);
        System.out.println("   user  " + user);


        for(Client u : client.findAll()) {
            if(u.getLogin().equals(login) && u.getPassword().equals(password)) {

                HttpSession session = request.getSession();
                session.setAttribute("username", u.getNom());
                System.out.println("user session " + session.getAttribute("username"));
                session.setMaxInactiveInterval(300);

                return "produits";
            }
        }
        return "account";
    }




}

