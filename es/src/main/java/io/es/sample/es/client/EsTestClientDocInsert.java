package io.es.sample.es.client;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.es.sample.es.entity.User;
import org.apache.http.HttpHost;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.client.indices.GetIndexResponse;
import org.elasticsearch.common.xcontent.XContentType;

import java.io.IOException;

public class EsTestClientDocInsert {
    public static void main(String[] args) throws IOException {
        //创建ES客户端
        RestHighLevelClient client = new RestHighLevelClient(
                RestClient.builder(new HttpHost("localhost", 9200, "http")));

        //插入数据
        IndexRequest indexRequest = new IndexRequest();
        indexRequest.index("user").id("1001");

        User user = User.builder().name("zhangsan").age(30).sex("男").build();
        // 添加文档数据，数据格式为 JSON 格式
        ObjectMapper objectMapper = new ObjectMapper();
        String userJson = objectMapper.writeValueAsString(user);
        indexRequest.source(userJson, XContentType.JSON);

        // 客户端发送请求，获取响应对象
        IndexResponse response = client.index(indexRequest, RequestOptions.DEFAULT);

        //打印结果信息
        System.out.println("_index:" + response.getIndex());
        System.out.println("_id:" + response.getId());
        System.out.println("_result:" + response.getResult());

        client.close();
    }
}
