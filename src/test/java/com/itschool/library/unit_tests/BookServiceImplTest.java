package com.itschool.library.unit_tests;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.itschool.library.models.dtos.BookDTO;
import com.itschool.library.models.entities.Book;
import com.itschool.library.repositories.BookRepository;
import com.itschool.library.services.BookServiceImpl;
import org.apache.coyote.Request;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class BookServiceImplTest {

    @Mock
    private ObjectMapper objectMapper;

    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private BookServiceImpl bookService;

    @Test
    void testCreateBook() {
        //given
        BookDTO bookDTO = new BookDTO();
        bookDTO.setId(1L);
        bookDTO.setTitle("Test Title");
        bookDTO.setAuthor("Test Author");
        bookDTO.setIsbn("Test ISBN");
        bookDTO.setGenre("Test Genre");

        Book bookEntity = new Book();
        bookEntity.setId(1L);
        bookEntity.setTitle("Test Title");
        bookEntity.setAuthor("Test Author");
        bookEntity.setIsbn("Test ISBN");
        bookEntity.setGenre("Test Genre");

        Book savedBookEntity = new Book();
        savedBookEntity.setId(1L);
        savedBookEntity.setTitle("Test Title");
        savedBookEntity.setAuthor("Test Author");
        savedBookEntity.setIsbn("Test ISBN");
        savedBookEntity.setGenre("Test Genre");

        when(objectMapper.convertValue(bookDTO, Book.class)).thenReturn(bookEntity);
        when(bookRepository.save(bookEntity)).thenReturn(savedBookEntity);
        when(objectMapper.convertValue(savedBookEntity, BookDTO.class)).thenReturn(bookDTO);

        //when
        BookDTO savedBookDTO = bookService.createBook(bookDTO);

        //then
        verify(bookRepository, times(1)).save(bookEntity);
        assertEquals(bookDTO.getAuthor(), savedBookDTO.getAuthor());
        assertEquals(bookDTO.getTitle(), savedBookDTO.getTitle());
    }
}