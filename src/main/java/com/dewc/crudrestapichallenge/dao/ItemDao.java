package com.dewc.crudrestapichallenge.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.dewc.crudrestapichallenge.dao.interfaces.IItemDao;
import com.dewc.crudrestapichallenge.entities.Item;
import com.dewc.crudrestapichallenge.repositories.ItemRepository;
import java.util.List;
import java.util.Optional;

@Repository
@Qualifier("itemDao")
public class ItemDao implements IItemDao {

    @Autowired
    private ItemRepository itemRepository;

    @Override
    public Item save(Item item) {
        return itemRepository.save(item);
    }

    @Override
    public Optional<Item> findById(Long id) {
        return itemRepository.findById(id);
    }

    @Override
    public List<Item> findAll() {
        return itemRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        itemRepository.deleteById(id);
    }
}
