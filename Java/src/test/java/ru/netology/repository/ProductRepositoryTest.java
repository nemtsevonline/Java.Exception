package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.exception.NotFoundException;
import ru.netology.domain.Product;
import ru.netology.domain.TShirt;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {
    private ProductRepository repository = new ProductRepository();
    private Book book1 = new Book(1, "Книга", 50000, "Автор", 450, 2010);
    private Product product1 = new Product(3, "Продукт", 60000);
    private TShirt tshirt1 = new TShirt(4, "TShirt", 40000, "white", "S");

    @BeforeEach
    public void setUp() {
        repository.save(book1);
        repository.save(product1);
        repository.save(tshirt1);
    }

    @Test
    public void removeByIdRight() {
        repository.removeById(3);

        Product[] expected = new Product[]{book1, tshirt1};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void removeByIdException() {
        assertThrows(NotFoundException.class, () -> repository.removeById(2));
    }

}
