package com.dewc.crudrestapichallenge.dao.interfaces;

import java.util.List;
import java.util.Optional;
import com.dewc.crudrestapichallenge.entities.Item;

public interface IItemDao {
    Item save(Item item);
    Optional<Item> findById(Long id);
    List<Item> findAll();
    void deleteById(Long id);
}
