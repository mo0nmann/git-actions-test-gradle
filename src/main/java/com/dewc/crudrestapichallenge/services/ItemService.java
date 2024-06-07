package com.dewc.crudrestapichallenge.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.dewc.crudrestapichallenge.adaptors.ItemAdaptor;
import com.dewc.crudrestapichallenge.dao.interfaces.IItemDao;
import com.dewc.crudrestapichallenge.dto.InputtedItemDto;
import com.dewc.crudrestapichallenge.dto.ItemDto;
import com.dewc.crudrestapichallenge.entities.Item;
import com.dewc.crudrestapichallenge.services.interfaces.IItemService;

@Service
@Primary
@Qualifier("itemService")
public class ItemService implements IItemService {

    private final IItemDao itemDao;

    @Autowired
    public ItemService(@Qualifier("itemDao") IItemDao itemDao) {
        this.itemDao = itemDao;
    }

    @Override
    public ItemDto saveItem(InputtedItemDto itemDto) {
        Item item = ItemAdaptor.toEntity(itemDto);
        itemDao.save(item);
        return ItemAdaptor.toDto(item);
    }

    @Override
    public Optional<ItemDto> getItem(Long id) {
        Optional<Item> item = itemDao.findById(id);
        return item.isPresent() ? Optional.of(ItemAdaptor.toDto(item.get())) : Optional.empty();
    }

    @Override
    public List<ItemDto> getItems() {
        List<Item> items = itemDao.findAll();
        List<ItemDto> itemDtos = items.stream()
                                    .map(ItemAdaptor::toDto)
                                    .collect(Collectors.toList());
        return itemDtos;
    }

    @Override
    public void updateItem(Long id, String name, String description) {
        Optional<Item> optionalItem = itemDao.findById(id);
        if(optionalItem.isPresent()){
            Item item = optionalItem.get();
            item.setName(name);
            item.setDescription(description);
            itemDao.save(item);
        }
    }

    @Override
    public void deleteItem(Long id) {
        itemDao.deleteById(id);
    }
}
