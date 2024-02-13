package jpabook.jpashop.service;

import jpabook.jpashop.domain.Item.Book;
import jpabook.jpashop.domain.Item.Item;
import jpabook.jpashop.repository.ItemRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class ItemServiceTest {
    @Autowired
    ItemService itemService;
    @Autowired
    ItemRepository itemRepository;

    @Test
    public void 상품등록() throws Exception {
        // given
        Book book = new Book();
        book.setName("책");

        // when
        itemService.saveItem(book);
        List<Item> items = itemRepository.findAll();

        // then
        assertEquals("책", items.get(0).getName());
    }

    @Test
    public void 상품조회() throws Exception {
        // given
        Book book = new Book();
        book.setName("책");

//        Book book2 = new Book();
//        book2.setName("책2");

        // when
        itemService.saveItem(book);
//        itemService.saveItem(book2);
        Item findItem = itemService.findOne(book.getId());

        // then
        org.assertj.core.api.Assertions.assertThat(findItem.getId()).isEqualTo(book.getId());
    }

    @Test
    public void 상품전체조회() throws Exception {
        // given
        Book book1 = new Book();
        book1.setName("책1");

        Book book2 = new Book();
        book2.setName("책2");

        // when
        itemService.saveItem(book1);
        itemService.saveItem(book2);
        List<Item> bookList = itemService.findItems();

        // then
        org.assertj.core.api.Assertions.assertThat(bookList.size()).isEqualTo(2);
    }
}