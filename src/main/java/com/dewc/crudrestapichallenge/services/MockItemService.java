package com.dewc.crudrestapichallenge.services;

import com.dewc.crudrestapichallenge.adaptors.ItemAdaptor;
import com.dewc.crudrestapichallenge.dao.MockItemDao;
import com.dewc.crudrestapichallenge.dto.InputtedItemDto;
import com.dewc.crudrestapichallenge.dto.ItemDto;
import com.dewc.crudrestapichallenge.entities.Item;
import com.dewc.crudrestapichallenge.services.interfaces.IItemService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
// @Primary
@Qualifier("itemService")
public class MockItemService implements IItemService {
    
    private final MockItemDao mockItemDao;

    @Autowired
    public MockItemService(@Qualifier("mockItemDao") MockItemDao mockItemDao) {
        this.mockItemDao = mockItemDao;
    }

    @Override
    public ItemDto saveItem(InputtedItemDto itemDto) {
        Item item = ItemAdaptor.toEntity(itemDto);
        mockItemDao.save(item);
        return ItemAdaptor.toDto(item);
    }

    @Override
    public List<ItemDto> getItems() {
        List<Item> items = mockItemDao.findAll();
        return items.stream()
                    .map(ItemAdaptor::toDto)
                    .collect(Collectors.toList());
    }

    @Override
    public Optional<ItemDto> getItem(Long id) {
        Optional<Item> item = mockItemDao.findById(id);
        return item.map(ItemAdaptor::toDto);
    }

    @Override
    public void updateItem(Long id, String name, String description) {
        Optional<Item> optionalItem = mockItemDao.findById(id);
        if(optionalItem.isPresent()){
            Item item = optionalItem.get();
            item.setName(name);
            item.setDescription(description);
            mockItemDao.save(item);
        }
    }

    @Override
    public void deleteItem(Long id) {
        mockItemDao.deleteById(id);
    } 

}
