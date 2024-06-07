package com.dewc.crudrestapichallenge.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RestController;

import com.dewc.crudrestapichallenge.controllers.bases.ItemControllerBase;
import com.dewc.crudrestapichallenge.services.interfaces.IItemService;

@RestController
public class ItemController extends ItemControllerBase {
    
    @Autowired
    public ItemController(@Qualifier("itemService") IItemService itemService) {
        super(itemService);
    }

}
