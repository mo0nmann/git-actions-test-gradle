package com.dewc.crudrestapichallenge.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dewc.crudrestapichallenge.entities.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {
     
}
