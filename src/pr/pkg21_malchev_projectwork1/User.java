package pr.pkg21_malchev_projectwork1;


import org.json.simple.JSONObject;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author user
 */
    class User{
        public String name;
        public String login;
        public String password;
        
        public User(JSONObject user){
            name = (String)user.get("firstName");
            login = (String)user.get("username");
            password = (String)user.get("password");
        }
    }