package com.db.grad.javaapi.service;

import com.db.grad.javaapi.model.Trade;
import com.db.grad.javaapi.repository.ITradesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TradeService {

    @Autowired
    ITradesRepo tradesRepo;
    public ArrayList<Trade> getAllTrades() {
        List<Trade> trades = tradesRepo.findAll();
        System.out.println(trades);
        return (ArrayList<Trade>) trades;
    }
}
