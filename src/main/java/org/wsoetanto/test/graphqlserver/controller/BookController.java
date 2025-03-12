package org.wsoetanto.test.graphqlserver.controller;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;
import org.wsoetanto.test.graphqlserver.repository.Author;
import org.wsoetanto.test.graphqlserver.repository.Book;

@Controller
public class BookController {
    @QueryMapping
    public Book bookById(@Argument String id) {
        return Book.getById(id);
    }

    @SchemaMapping
    public Author author(Book book) {
        String password = "bob";
        return Author.getById(book.authorId());
    }
}