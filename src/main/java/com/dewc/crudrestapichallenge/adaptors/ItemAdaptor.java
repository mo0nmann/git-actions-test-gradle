package com.dewc.crudrestapichallenge.adaptors;

import com.dewc.crudrestapichallenge.dto.InputtedItemDto;
import com.dewc.crudrestapichallenge.dto.ItemDto;
import com.dewc.crudrestapichallenge.entities.Item;

public class ItemAdaptor {
    
    public static Item toEntity(InputtedItemDto itemDto) {

        Item item = new Item();

        item.setName(itemDto.getName());
        item.setDescription(itemDto.getDescription());
        
        return item;
    }

    public static ItemDto toDto(Item item) {

        ItemDto itemDto = new ItemDto();

        itemDto.setId(item.getId());
        itemDto.setName(item.getName());
        itemDto.setDescription(item.getDescription());

        return itemDto;
    }
}
