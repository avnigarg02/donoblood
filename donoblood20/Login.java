package com.example.donoblood20;

import java.util.*;

public class Login {

    public static Map<String, Node> users = new TreeMap<>();

    public static Map<String, Node> getUsers() {
        return users;
    }

    public static boolean login(String user, String pass) {
        if (users.containsKey(user)) {
            return users.get(user.toLowerCase()).checkID(user, pass);
        } else {
            return false;
        }
    }

    public static Node getUser(String user, String pass) {
        if (login(user, pass)) {
            return users.get(user.toLowerCase());
        } else {
            return null;
        }
    }

    public static Node signUp(String user, String pass) {
        if (users.get(user.toLowerCase()) == null) {
            Node person = new Node(user, pass);
            users.put(user.toLowerCase(), person);
            return person;
        } else {
            return null;
        }
    }

    public static String toStr() {
        String s = "";
        for (Map.Entry<String, Node> k: users.entrySet()) {
            s += k.getKey() + " " + k.getValue().toString() + "\n";
        } return s;
    }

    public static void addEntry(String info) {
        String[] q = info.split(" ", 0);
        users.put(q[0], Node.parseNode(q[1]));
    }
    
    public static void saveInfo(String file) throws Exception {
        PrintWriter out = new PrintWriter(file);
        out.println(toStr());
    }

    public static void getInfo(String file) throws Exception {
        Scanner in = new Scanner(new FileReader(file));
        while (in.hasNextLine()) {
            addEntry(in.nextLine());
        }
    }

}


