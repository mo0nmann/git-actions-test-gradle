package com.dewc.crudrestapichallenge.dao;

import com.dewc.crudrestapichallenge.dao.interfaces.IItemDao;
import com.dewc.crudrestapichallenge.entities.Item;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
@Qualifier("mockItemDao")
public class MockItemDao implements IItemDao{

    private final Map<Long, Item> items = new HashMap<>();
    private Long currentId = 1L;

    @Override
    public Item save(Item item) {
        item.setId(currentId++);
        items.put(item.getId(), item);
        return item;
    }

    @Override
    public Optional<Item> findById(Long id) {
        return Optional.ofNullable(items.get(id));
    }

    @Override
    public List<Item> findAll() {
        return new ArrayList<>(items.values());
    }

    @Override
    public void deleteById(Long id) {
        items.remove(id);
    }   

}
