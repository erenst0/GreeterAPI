package com.erensto.hello;

import com.erensto.book.service.BookService;
import org.elasticsearch.client.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * Created by Ernesto on 2016-07-06.
 */

@RestController
public class GreeterController {
    private final AtomicLong counter = new AtomicLong();

    @Autowired
    private ElasticsearchOperations es;


    @Autowired
    private BookService bookService;


    @RequestMapping(value = "/greeting", method = GET)
    public String greeting(@RequestParam(value="name", defaultValue = "World") String name) {
        return new Greeting(counter.incrementAndGet(),name).getGreeting();
    }

    @RequestMapping(value = "/esconfig", method = GET)
    public String esconfig() {
        return printElasticSearchInfo();
    }


    private String printElasticSearchInfo() {
        StringBuilder info = new StringBuilder();

        info.append("---ElasticSearch Info start---" + "<br/>");

        Client client = es.getClient();
        Map<String, String> asMap = client.settings().getAsMap();

        asMap.forEach((k,v) -> {
            info.append(k + " = " + v + "<br/>");
            info.append(System.lineSeparator());
        });

        info.append("---ElasticSearch Info end---");

        return info.toString();
    }
}
