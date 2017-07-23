package com.erensto;

import org.elasticsearch.client.Client;

import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

import java.net.InetAddress;

/**
 * Created by Ernesto on 2017-07-07.
 */

@Configuration
@EnableElasticsearchRepositories(basePackages = "com.erensto.book.repository")

public class EsConfig {


    @Value("${elasticsearch.host}")
    private String EsHost;

    @Value("${elasticsearch.port}")
    private int EsPort;

    @Value("${elasticsearch.clustername}")
    private String EsClusterName;


    @Bean
    public Client client() throws Exception {


        /*return new PreBuiltTransportClient(Settings.EMPTY)
                .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("localhost"), 9300));
*/
        //return client;


        Settings esSettings = Settings.settingsBuilder()
                .put("cluster.name", EsClusterName)
                .put("network.server", true)
                .build();

        return TransportClient.builder()
                .settings(esSettings)
                .build()
                .addTransportAddress(
                        new InetSocketTransportAddress(InetAddress.getByName("localhost"),9300)
                );
        //InetAddress.getByName(EsHost)


    }

    @Bean
    public ElasticsearchOperations elasticsearchTemplate() throws Exception {
        return new ElasticsearchTemplate(client());
    }

}
