package com.example.restapi.controller;

import com.example.restapi.model.Bank;
import com.example.restapi.serviceImpl.BankServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.SortDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Collection;
import java.util.logging.Logger;

@RestController
@RequestMapping("/banks")
    public class BankController {

    private final Logger logger = Logger.getLogger(this.getClass().getName());

    @Autowired
    private BankServiceImpl bankService;

    //вывод всех банков
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Collection<Bank>> getBanks(@ModelAttribute Bank bank, @SortDefault(sort = "id") Sort sort){
        return new ResponseEntity<>(bankService.getAll(bank, sort), HttpStatus.OK);
    }

    //Вывод банка по id
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public ResponseEntity<Bank> getBank(@PathVariable Long id){
        Bank bank = bankService.getByID(id);

        if (bank != null){
            return new ResponseEntity<>(bankService.getByID(id),HttpStatus.OK);
        }else {
            logger.severe("BankId" + id + " is not existed");
            return new ResponseEntity<>((Bank) null, HttpStatus.NOT_FOUND);
        }
    }

    //Добавление банка
    @RequestMapping (value = "/add",method = RequestMethod.POST)
    public ResponseEntity<?> addBank(@RequestBody Bank bank){
        return new ResponseEntity<>(bankService.save(bank),HttpStatus.CREATED);
    }

    //Обновление банка
    @RequestMapping (value = "/{id}", method = RequestMethod.POST)
    public ResponseEntity<?> updateBank (@RequestBody Bank bank){
        return new ResponseEntity<>(bankService.update(bank),HttpStatus.UPGRADE_REQUIRED);
    }

    //Удаление банка по id
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteBank (@PathVariable Long id){

        Bank bank = bankService.getByID(id);

        if (bank != null){
            bankService.remove(id);
            return new ResponseEntity<Void>(HttpStatus.OK);
        }else{
            logger.severe("Did not delete the object. BankId " + id + " is not existed");
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }
    }


}
