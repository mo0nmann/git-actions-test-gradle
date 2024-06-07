package com.dewc.crudrestapichallenge.services.interfaces;

import java.util.Optional;
import java.util.List;

import com.dewc.crudrestapichallenge.dto.InputtedItemDto;
import com.dewc.crudrestapichallenge.dto.ItemDto;

public interface IItemService {
    
    public ItemDto saveItem(InputtedItemDto itemDto);

    List<ItemDto> getItems();

    Optional<ItemDto> getItem(Long id);

    void updateItem(Long id, String name, String description);

    void deleteItem(Long id);
}
