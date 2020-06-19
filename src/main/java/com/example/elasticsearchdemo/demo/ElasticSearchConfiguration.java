package com.example.elasticsearchdemo.demo;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;


/**
 * @author zhouguanya
 * @version Id: ElasticSearchConfiguration.java, v 0.1  2020/6/19 zhouguanya Exp $$
 */
@Component
public class ElasticSearchConfiguration {
    @Value("${es.host}")
    public String host;
    @Value("${es.port}")
    public int port;
    @Value("${es.scheme}")
    public String scheme;

    @Bean
    public RestClientBuilder restClientBuilder() {
        return RestClient.builder(makeHttpHost());
    }

    private HttpHost makeHttpHost() {
        return new HttpHost(host, port, scheme);
    }

    @Bean
    public RestClient restClient(){
        return RestClient.builder(new HttpHost(host, port, scheme)).build();
    }

    @Bean
    public RestHighLevelClient restHighLevelClient(@Autowired RestClientBuilder restClientBuilder){
        return new RestHighLevelClient(restClientBuilder);
    }

}
