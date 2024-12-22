package com.aseds.aithssainesbaiti.services;

import com.aseds.aithssainesbaiti.domain.Block;
import com.aseds.aithssainesbaiti.domain.Blockchain;
import com.aseds.aithssainesbaiti.domain.HashUtils;
import org.springframework.stereotype.Service;

@Service
public class MiningService {
    private final BlockchainService blockchainService;

    public MiningService(BlockchainService blockchainService) {
        this.blockchainService = blockchainService;
    }
    public Block mineBlock() {
        Blockchain blockchain = blockchainService.getBlockchain();
        Block lastBlock = blockchain.getLatestBlock();
        String data = "Mined Block Data";
        int proof = generateProofOfWork(lastBlock.getProof());
        Block newBlock = new Block(
                blockchain.getChain().size(),
                lastBlock.getHash(),
                data,
                proof
        );
        blockchain.addBlock(newBlock.getData());
        return newBlock;
    }
    private int generateProofOfWork(int lastProof) {
        int proof = 0;
        while (!isValidProof(lastProof, proof)) {
            proof++;
        }
        return proof;
    }
    private boolean isValidProof(int lastProof, int proof) {
        String guess = lastProof + "" + proof;
        String guessHash = HashUtils.hash(guess);
        return guessHash.startsWith("0000");
    }

}
