package com.example.elasticsearchdemo.demo;

import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
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
     *
     * @param indexName
     * @param id
     * @param source
     * @return
     * @throws IOException
     */
    public IndexResponse add(String indexName, String id, String source) throws IOException {
        IndexRequest request = new IndexRequest(indexName);
        if (null != id) {
            request.id(id);
        }
        request.source(source, XContentType.JSON);
        return restHighLevelClient.index(request, RequestOptions.DEFAULT);
    }

    /**
     * 如果文档不存在则插入，如果存在则更新
     *
     * @param indexName
     * @param id
     * @param source
     * @return
     * @throws IOException
     */
    public UpdateResponse update(String indexName, String id, String source) throws IOException {
        UpdateRequest request = new UpdateRequest(indexName, id).doc(source, XContentType.JSON).upsert(source, XContentType.JSON);
        return restHighLevelClient.update(request, RequestOptions.DEFAULT);
    }
}
