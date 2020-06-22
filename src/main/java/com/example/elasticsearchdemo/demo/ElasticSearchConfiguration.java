package com.example.elasticsearchdemo.demo;

import org.apache.commons.io.IOUtils;
import org.elasticsearch.action.admin.indices.alias.Alias;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.common.xcontent.XContentType;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;


/**
 * @author zhouguanya
 * @version Id: ElasticSearchConfiguration.java, v 0.1  2020/6/19 zhouguanya Exp $$
 */
@Component
public class ElasticSearchConfiguration {

    @Resource
    private RestHighLevelClient restHighLevelClient;

    /**
     * 创建索引
     *
     * @throws IOException
     */
    @PostConstruct
    public void createIndex() throws IOException {
        for (Index index : Index.values()) {
            String indexName = index.getName();
            if (indexExists(indexName)) {
                continue;
            }
            // 开始创建库
            CreateIndexRequest request = new CreateIndexRequest(indexName);
            //配置文件
            ClassPathResource seResource = new ClassPathResource("settings.json");
            InputStream settingsInputStream = seResource.getInputStream();
            String settingsJson = String.join("\n", IOUtils.readLines(settingsInputStream, "UTF-8"));
            settingsInputStream.close();
            //映射文件
            ClassPathResource mappingResource = new ClassPathResource("mapping/" + index + "-mapping.json");
            InputStream mappingInputStream = mappingResource.getInputStream();
            String mappingJson = String.join("\n", IOUtils.readLines(mappingInputStream, "UTF-8"));
            mappingInputStream.close();

            request.settings(settingsJson, XContentType.JSON);
            request.mapping(mappingJson, XContentType.JSON);

            //设置别名
            request.alias(new Alias(index + "_alias"));
        }

    }

    /**
     * 判断索引是否存在
     *
     * @param indexName 索引名
     * @return boolean
     * @throws IOException IO异常
     */
    public boolean indexExists(String indexName) throws IOException {
        GetIndexRequest request = new GetIndexRequest(indexName);
        return restHighLevelClient.indices().exists(request, RequestOptions.DEFAULT);
    }

}
