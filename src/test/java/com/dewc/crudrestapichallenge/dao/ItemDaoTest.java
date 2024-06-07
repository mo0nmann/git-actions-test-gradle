package com.dewc.crudrestapichallenge.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.dewc.crudrestapichallenge.entities.Item;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ItemDaoTest {

    private MockItemDao mockItemDao;

    @BeforeEach
    public void setUp() {
        mockItemDao = new MockItemDao();
    }

    @Test
    public void testSave() {
        Item item = new Item();
        item.setName("TestItem");
        item.setDescription("TestDescription");

        mockItemDao.save(item);

        assertEquals(1, mockItemDao.findAll().size());
    }

    @Test
    public void testFindById() {
        Item item = new Item();
        item.setName("TestItem");
        item.setDescription("TestDescription");

        mockItemDao.save(item);

        assertTrue(mockItemDao.findById(1L).isPresent());
    }
}