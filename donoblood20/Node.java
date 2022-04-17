package com.example.donoblood20;

import java.util.LinkedList;

public class Node {

    private final String username;
    private String password;
    private final LinkedList<Block> blockchain;

    public Node(String user, String pass) {
        username = user;
        password = pass;
        blockchain = new LinkedList<>();
        blockchain.add(new Block(0));
    }

    // to rebuild the node
    private Node(String user, String pass, LinkedList<Block> chain) {
        username = user;
        password = pass;
        blockchain = chain;
    }

    public String getUsername() {
        return username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean checkID(String user, String pass) {
        if (user.equalsIgnoreCase(username) && pass.equals(password)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean makeDonation(String user, String pass, int donation) {
        if (!checkID(user, pass)) {
            return false;
        } else {
            addBlock(donation, blockchain.getFirst());
            return true;
        }
    }

    private void addBlock(int donation, Block prevBlock) {
        Block block = new Block(donation, prevBlock);
        block.mineBlock(4);
        blockchain.addFirst(block);
    }

    public String toString() {
        StringBuilder s = new StringBuilder(username + ":" + password + ":");
        for (Block block : blockchain) {
            s.append(block.toString()).append("/");
        }
        return s.toString();
    }

    public static Node parseNode(String str) {
        String[] s = str.split(":", 0);
        LinkedList<Block> blockchain = new LinkedList<>();
        for (String f: s[2].split("/", 0)) {
            blockchain.add(Block.parseBlock(f));
        } return new Node(s[0], s[1], blockchain);
    }

}

