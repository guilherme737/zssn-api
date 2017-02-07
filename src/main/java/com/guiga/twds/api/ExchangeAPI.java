package com.guiga.twds.api;

import com.guiga.twds.dto.ExchangeDTO;
import com.guiga.twds.service.ExchangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by guilherme on 21/01/17.
 */
@RestController
@RequestMapping(value = "/exchange")
public class ExchangeAPI {

    @Autowired
    private ExchangeService exchangeService;

    @RequestMapping(value = "/make-exchange", method = RequestMethod.POST)
    public void makeExchange(@RequestBody ExchangeDTO exchange) {

        exchangeService.makeExchange(exchange);
    }
}
