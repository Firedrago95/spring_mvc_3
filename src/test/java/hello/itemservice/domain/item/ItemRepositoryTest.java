package hello.itemservice.domain.item;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class ItemRepositoryTest {

    private ItemRepository itemRepository = new ItemRepository();

    @AfterEach
    void afterEach() {
        itemRepository.clearStore();
    }

    @Test
    void save() {
        //given
        Item item = new Item("itemA", 20000, 20);

        //when
        Item savedItem = itemRepository.save(item);
        Long savedItemId = savedItem.getId();

        //then
        Item findItem = itemRepository.findById(savedItemId);
        assertThat(findItem).isEqualTo(item);
    }

    @Test
    void findAll() {
        //given
        Item item1 = new Item("itemA", 10000, 10);
        Item item2 = new Item("itemB", 20000, 20);

        itemRepository.save(item1);
        itemRepository.save(item2);

        //when
        List<Item> items = itemRepository.findAll();

        //then
        assertThat(items.size()).isEqualTo(2);
        assertThat(items).contains(item1);
        assertThat(items).contains(item2);
    }

    @Test
    void update() {
        //given
        Item item1 = new Item("itemA", 10000, 10);
        itemRepository.save(item1);
        Long item1Id = item1.getId();

        //when
        Item itemParam = new Item("itemB", 20000, 20);
        itemRepository.update(item1Id, itemParam);

        //then
        Item updatedItem = itemRepository.findById(item1Id);
        assertThat(updatedItem.getItemName()).isEqualTo(itemParam.getItemName());
        assertThat(updatedItem.getPrice()).isEqualTo(itemParam.getPrice());
        assertThat(updatedItem.getQuantity()).isEqualTo(itemParam.getQuantity());
    }
}