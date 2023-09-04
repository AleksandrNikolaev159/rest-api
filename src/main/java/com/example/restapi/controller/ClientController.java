package com.example.restapi.controller;

import com.example.restapi.model.Client;
import com.example.restapi.serviceImpl.ClientServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.SortDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.logging.Logger;

@RestController
@RequestMapping("/clients")
public class ClientController {

    private final Logger logger = Logger.getLogger(this.getClass().getName());

    @Autowired
    private ClientServiceImpl clientService;

    //вывод всех клиентов
    @RequestMapping(method = RequestMethod.GET)
    @Operation(summary = "Вывести все записи из таблицы \"clients\"")
    public ResponseEntity<Collection<Client>>getClients(@ModelAttribute Client client, @SortDefault(sort = "id") Sort sort){
        return new ResponseEntity<>(clientService.getAll(client,sort), HttpStatus.OK);
    }

    //вывод клиента по id
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    @Operation(summary = "Вывести запись из таблицы \"clients\"по id")
    public ResponseEntity<Client> getClient(@PathVariable long id){
        Client client = clientService.geByID(id);

        if (client !=null){
            return new ResponseEntity<>(clientService.geByID(id),HttpStatus.OK);
        }else {
            logger.severe("ClientId " + id + " is not existed");
            return new ResponseEntity<>((Client)null,HttpStatus.NOT_FOUND);
        }
    }

    //добавление клиента
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    @Operation(summary = "Добавить запись в таблицу \"clients\"")
    public ResponseEntity<?> addClient (@RequestBody Client client){
        return new ResponseEntity<>(clientService.save(client),HttpStatus.CREATED);
    }

    //обновление клиента
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    @Operation(summary = "Обновить запись в таблице \"clients\"  по id")
    public ResponseEntity<?> updateClient (@RequestBody Client client){
        return new ResponseEntity<>(clientService.update(client),HttpStatus.UPGRADE_REQUIRED);
    }

    //удаление клиента по id
    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    @Operation(summary = "Удалить запись в таблице \"clients\"  по id")
    public ResponseEntity<Void>deleteClient(@PathVariable long id){

        Client client = clientService.geByID(id);

        if (client != null){
            clientService.remove(id);
            return new ResponseEntity<Void>(HttpStatus.OK);
        }else{
            logger.severe("Did not delete the object. ClientId " + id + " is not existed");
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }
    }

}
