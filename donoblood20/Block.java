package com.example.donoblood20;

// Source: https://www.baeldung.com/java-blockchain

import java.security.*;
import java.util.Date;

import static java.nio.charset.StandardCharsets.UTF_8;

public class Block {

    private String hash;
    private final String previousHash;
    private final int donation;
    private final long timeStamp;
    private int nonce;
    private int points;

    public Block(int donation, Block prevBlock) {
        this.timeStamp = new Date().getTime();
        this.donation = donation;
        this.previousHash = prevBlock.getHash();
        this.hash = calculateBlockHash();
        addPoints(prevBlock.getPoints());
    }


    public Block(int donation) {
        this.timeStamp = new Date().getTime();
        this.donation = donation;
        this.previousHash = "";
        this.hash = calculateBlockHash();
    }

    // to rebuild from text file
    private Block(String hash, long time, int donation, String prevHash, int nonce, int points) {
        this.timeStamp = time;
        this.donation = donation;
        this.previousHash = prevHash;
        this.hash = hash;
        this.points = points;
        this.nonce = nonce;
    }

    private void addPoints(int prevPoints) {
        points = prevPoints + donation;
    }

    public int getPoints() {
        return points;
    }

    public String getHash() {
        return hash;
    }

    public String getPreviousHash() {
        return previousHash;
    }

    public int getDonation() {
        return donation;
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    public String calculateBlockHash() {
        String dataToHash = previousHash
                + Long.toString(timeStamp)
                + Integer.toString(nonce)
                + points;
        MessageDigest digest = null;
        byte[] bytes = null;
        try {
            digest = MessageDigest.getInstance("SHA-256");
            bytes = digest.digest(dataToHash.getBytes(UTF_8));
        } catch (NoSuchAlgorithmException ex) {
            // logger.log(Level.SEVERE, ex.getMessage());
            System.out.println("ERROR: " + ex.getMessage());
        }
        StringBuilder buffer = new StringBuilder();
        assert bytes != null;
        for (byte b : bytes) {
            buffer.append(String.format("%02x", b));
        }
        return buffer.toString();
    }

    public String mineBlock(int prefix) {
        String prefixString = new String(new char[prefix]).replace('\0', '0');
        while (!hash.substring(0, prefix).equals(prefixString)) {
            nonce++;
            hash = calculateBlockHash();
        }
        return hash;
    }

    public String toString() {
        return hash + ";" + Long.toString(timeStamp) + ";" + donation + ";" + previousHash + ";"  + nonce + ";" + points;
    }

    public static Block parseBlock(String str) {
        String[] s = str.split(";", 0);
        return new Block(s[0], Long.parseLong(s[1]), Integer.parseInt(s[2]), s[3], Integer.parseInt(s[4]), Integer.parseInt(s[5]));
    }

}

