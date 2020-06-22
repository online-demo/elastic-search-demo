package com.example.elasticsearchdemo.demo;

import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;

/**
 * @author zhouguanya
 * @version Id: RestHighLevelClientService.java, v 0.1  2020/6/22 zhouguanya Exp $$
 */
@Service
public class RestHighLevelClientService {
    @Resource
    private RestHighLevelClient restHighLevelClient;
    /**
     * 添加文档 手动指定id
     * @param indexName
     * @param id
     * @param source
     * @return
     * @throws IOException
     */
    public IndexResponse add(String indexName, String id, String source) throws IOException{
        IndexRequest request = new IndexRequest(indexName);
        if (null != id) {
            request.id(id);
        }
        request.source(source, XContentType.JSON);
        return restHighLevelClient.index(request, RequestOptions.DEFAULT);
    }
}
