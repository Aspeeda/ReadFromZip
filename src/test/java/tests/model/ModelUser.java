package tests.model;

import java.util.ArrayList;

public class ModelUser {
    public static class User {
        public int id;
        public String name;
        public String username;
        public Address address;
        public ArrayList<Cars> cars;

        public static class Address {
            public String street;
            public String suite;
            public String city;
        }
        public static class Cars {
            public String name;
            public ArrayList<String> models;
        }
    }
}
