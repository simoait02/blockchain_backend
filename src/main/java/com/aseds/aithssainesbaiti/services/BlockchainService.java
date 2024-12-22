package com.aseds.aithssainesbaiti.services;

import com.aseds.aithssainesbaiti.domain.Block;
import com.aseds.aithssainesbaiti.domain.Blockchain;
import org.springframework.stereotype.Service;

@Service
public class BlockchainService {
    private final Blockchain blockchain;

    public BlockchainService() {
        this.blockchain = new Blockchain();
    }

    public Block addBlock(String data) {
        return blockchain.addBlock(data);
    }

    public boolean isBlockchainValid() {
        return blockchain.isChainValid();
    }
    public Blockchain getBlockchain() {
        return blockchain;
    }
}
