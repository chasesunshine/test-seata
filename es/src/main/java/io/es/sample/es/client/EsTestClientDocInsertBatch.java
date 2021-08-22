package io.es.sample.es.client;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.es.sample.es.entity.User;
import org.apache.http.HttpHost;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;

import java.io.IOException;

public class EsTestClientDocInsertBatch {
    public static void main(String[] args) throws IOException {
        //创建ES客户端
        RestHighLevelClient client = new RestHighLevelClient(
                RestClient.builder(new HttpHost("localhost", 9200, "http")));

        //批量插入数据
        BulkRequest request = new BulkRequest();
        request.add( new IndexRequest().index("user").id("1001").source(XContentType.JSON,"name", "zhangsan","age",30,"sex","男") );
        request.add( new IndexRequest().index("user").id("1002").source(XContentType.JSON, "name", "lisi","age",30,"sex","男") );
        request.add( new IndexRequest().index("user").id("1003").source(XContentType.JSON, "name", "wangwu","age",40,"sex","男") );
        request.add( new IndexRequest().index("user").id("1004").source(XContentType.JSON, "name", "wangwu1","age",40,"sex","女") );
        request.add( new IndexRequest().index("user").id("1005").source(XContentType.JSON, "name", "wangwu2","age",50,"sex","女") );
        request.add( new IndexRequest().index("user").id("1006").source(XContentType.JSON, "name", "wangwu3","age",50,"sex","女") );

        //客户端发送请求，获取响应对象
        BulkResponse response = client.bulk(request, RequestOptions.DEFAULT);

        //打印结果信息
        System.out.println("took:" + response.getTook());
        System.out.println("items:" + response.getItems());

        client.close();
    }
}
