package ro.pentalog.wheaterapp;


public class User {

    String name, country, email, password;

    public User(String name, String country, String email, String password) {
        this.name = name;
        this.country = country;
        this.email = email;
        this.password = password;
    }

    public User(String email, String password){
        this.email = email;
        this.password = password;

        this.name = "";
        this.country ="";
    }
}
