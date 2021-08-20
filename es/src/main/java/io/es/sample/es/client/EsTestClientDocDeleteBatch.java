package io.es.sample.es.client;

import org.apache.http.HttpHost;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;

import java.io.IOException;

public class EsTestClientDocDeleteBatch {
    public static void main(String[] args) throws IOException {
        //创建ES客户端
        RestHighLevelClient client = new RestHighLevelClient(
                RestClient.builder(new HttpHost("localhost", 9200, "http")));

        //批量删除数据
        BulkRequest request = new BulkRequest();
        request.add( new DeleteRequest().index("user").id("1001") );
        request.add( new DeleteRequest().index("user").id("1002") );
        request.add( new DeleteRequest().index("user").id("1003") );

        //客户端发送请求，获取响应对象
        BulkResponse response = client.bulk(request, RequestOptions.DEFAULT);

        //打印结果信息
        System.out.println("took:" + response.getTook());
        System.out.println("items:" + response.getItems());

        client.close();
    }
}
