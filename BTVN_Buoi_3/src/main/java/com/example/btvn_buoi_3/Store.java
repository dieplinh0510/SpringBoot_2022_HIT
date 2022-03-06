package com.example.btvn_buoi_3;


import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Store {
    static  List<User> users = new ArrayList<>();

    static {
        users.add(new User(1, "lamlinh1", "lamlinh101", "Lam Linh 1"));
        users.add(new User(2, "lamlinh2", "lamlinh102", "Lam Linh 2"));
        users.add(new User(3, "lamlinh3", "lamlinh103", "Lam Linh 3"));
        users.add(new User(4, "lamlinh4", "lamlinh104", "Lam Linh 4"));
        users.add(new User(5, "lamlinh5", "lamlinh105", "Lam Linh 5"));
    }
}
