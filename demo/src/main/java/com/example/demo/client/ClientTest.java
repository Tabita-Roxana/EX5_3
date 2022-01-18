package com.example.demo.client;

import com.example.demo.user.User;
import org.glassfish.jersey.client.ClientConfig;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;

public class ClientTest {

    public static void main(String[] args) throws Exception {
        ClientConfig config = new ClientConfig();
        Client client = ClientBuilder.newClient(config);
        WebTarget target = client.target("http://localhost:8080/");


        GenericType<ArrayList<User>> userArrayList = new GenericType<ArrayList<User>>() {
        };
        ArrayList<User> allUsers = target.path("users").request().accept(MediaType.APPLICATION_JSON).get(userArrayList);
        System.out.println(allUsers);

        System.out.println();


        User user1 = new User("tabita@gmail.com", "Password1");
        target.path("users").request(MediaType.APPLICATION_JSON).post(Entity.json(user1));
        allUsers = target.path("users").request().accept(MediaType.APPLICATION_JSON).get(userArrayList);

            System.out.println(allUsers);


        System.out.println();

        User user3 = target.path("users").path("3").request().accept(MediaType.APPLICATION_JSON).get(User.class);
        System.out.println(user3);

        System.out.println();
        target.path("users").path("1").request().delete();
        allUsers = target.path("users").request().accept(MediaType.APPLICATION_JSON).get(userArrayList);
        for (User u : allUsers) {
            System.out.println(u);
        }
    }
}
