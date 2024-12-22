package com.aseds.aithssainesbaiti.domain;


public class Block {
    private int index;
    private String previousHash;
    private String hash;
    private String data;
    private long timestamp;
    private int proof;

    public Block(int index, String previousHash, String data, int proof) {
        this.index = index;
        this.previousHash = previousHash;
        this.data = data;
        this.timestamp = System.currentTimeMillis();
        this.proof = proof;
        this.hash = calculateHash();
    }

    public String calculateHash() {
        String input = index + previousHash + timestamp + data + proof;
        return HashUtils.hash(input);
    }

    // Getters and setters for all fields
    public int getIndex() { return index; }
    public String getPreviousHash() { return previousHash; }
    public String getHash() { return hash; }
    public String getData() { return data; }
    public long getTimestamp() { return timestamp; }
    public int getProof() { return proof; }
}
