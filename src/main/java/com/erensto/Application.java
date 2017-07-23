package com.erensto;

import com.erensto.book.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;

/**
 * Created by Ernesto on 2016-07-06.
 */
@SpringBootApplication
public class Application implements CommandLineRunner{

    @Autowired
    private ElasticsearchOperations es;

    @Autowired
    private BookService bookService;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {
        System.out.println("running");
    }
}
