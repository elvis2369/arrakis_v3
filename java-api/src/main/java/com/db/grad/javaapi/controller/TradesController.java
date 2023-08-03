package com.db.grad.javaapi.controller;

import com.db.grad.javaapi.model.Trade;
import com.db.grad.javaapi.service.TradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;


@RestController
public class TradesController {

    @Autowired
    TradeService tradeService;
    @GetMapping("/allTrades")
    public ArrayList<Trade> getWelcome() {
        ArrayList<Trade> trades = tradeService.getAllTrades();
        return trades;
    }
}
