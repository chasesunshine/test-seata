package io.es.sample.es.client;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.client.indices.GetIndexResponse;

import java.io.IOException;

public class EsTestClientIndexSearch {
    public static void main(String[] args) throws IOException {
        //创建ES客户端
        RestHighLevelClient client = new RestHighLevelClient(
                RestClient.builder(new HttpHost("localhost", 9200, "http")));

        //查询索引
        GetIndexRequest request = new GetIndexRequest("user");
        GetIndexResponse getIndexResponse = client.indices().get(request, RequestOptions.DEFAULT);

        //响应状态
        System.out.println("aliases:"+getIndexResponse.getAliases());
        System.out.println("mappings:"+getIndexResponse.getMappings());
        System.out.println("settings:"+getIndexResponse.getSettings());

        client.close();
    }
}
