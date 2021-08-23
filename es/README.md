# ES学习文档
    尚硅谷大数据全套视频教程
    下载链接：https://pan.baidu.com/s/18Feqa_63640xPB0fYJ8Ttg，提取码：9bnr
    学习路线及下载导航：http://www.atguigu.com/bigdata_video.shtml#bigdata
    
    B站直达在线看：https://space.bilibili.com/302417610
    围观尚硅谷大数据课程：http://www.atguigu.com/bigdata
# ES官网
    https://www.elastic.co/cn/


#个人测试
    启动：C:\AllSoftWare\WorkSoftWare\elasticsearch-7.8.0-windows-x86_64\elasticsearch-7.8.0\bin\elasticsearch.bat
    地址：http://localhost:9200
    
    ##P8
        创建索引：在 Postman 中，向 ES 服务器发 PUT 请求 ：http://127.0.0.1:9200/shopping
        查看索引：在 Postman 中，向 ES 服务器发 GET 请求 ：http://127.0.0.1:9200/shopping
    #P9
        查看所有索引：在 Postman 中，向 ES 服务器发 GET 请求 ：http://127.0.0.1:9200/_cat/indices?v
        删除索引：在 Postman 中，向 ES 服务器发 DELETE 请求 ：http://127.0.0.1:9200/shopping
    #P10
        创建文档：在 Postman 中，向 ES 服务器发 POST 请求 ：http://127.0.0.1:9200/shopping/_doc
             请求体内容为：
             {
              "title":"小米手机",
              "category":"小米",
              "images":"http://www.gulixueyuan.com/xm.jpg",
              "price":3999.00
             }
        如果想要自定义唯一性标识，需要在创建时指定：http://127.0.0.1:9200/shopping/_doc/1
             结果：
             {
                 "_index"【索引】: "shopping",
                 "_type"【 类型-文档 】: "_doc",
                 "_id"【唯一标识】: "Xhsa2ncBlvF_7lxyCE9G", #可以类比为 MySQL 中的主键，随机生成
                 "_version"【版本】: 1,
                 "result"【结果】: "created", #这里的 create 表示创建成功
                 "_shards"【分片】: {
                 "total"【分片 - 总数】: 2,
                 "successful"【分片 - 成功】: 1,
                 "failed"【分片 - 失败】: 0
             },
             "_seq_no": 0,
             "_primary_term": 1
             }
    #P11
        查看文档：在 Postman 中，向 ES 服务器发 GET 请求 ：http://127.0.0.1:9200/shopping/_doc/1
        查看全部：http://127.0.0.1:9200/shopping/_search
    #P12
        修改文档：在 Postman 中，向 ES 服务器发 POST 请求 ：http://127.0.0.1:9200/shopping/_doc/1
            请求体内容为:
            {
             "title":"华为手机",
             "category":"华为",
             "images":"http://www.gulixueyuan.com/hw.jpg",
             "price":4999.00
            }
        修改字段：在 Postman 中，向 ES 服务器发 POST 请求 ：http://127.0.0.1:9200/shopping/_update/1
            请求体内容为：
            { 
             "doc": {
             "price":3000.00
             } 
            }
        删除文档：在 Postman 中，向 ES 服务器发 DELETE 请求 ：http://127.0.0.1:9200/shopping/_doc/1
    #P13
         条件查询数据：http://127.0.0.1:9200/shopping/_search
            请求体内容为：
            {
                "query":{
                    "match":{
                        "category":"小米"
                    }
                }
            }
        条件删除文档：向 ES 服务器发 POST 请求 ：http://127.0.0.1:9200/shopping/_delete_by_query
            请求体内容为：
            {
                 "query":{
                     "match":{
                        "price":4000.00
                     }
                 }
            }
    #P14
        must = and 
        should = or
    #P15
        "match_phrase" 完全匹配查询
        "match" 拆分匹配查询
    #P17
        1.先创建索引：put请求  http://127.0.0.1:9200/user
        2.创建结构信息（创建映射）：在 Postman 中，向 ES 服务器发 PUT 请求 ：http://127.0.0.1:9200/student/_mapping
            请求体内容为：
            {
                 "properties": {
                     "name":{
                         "type": "text",
                         "index": true
                     },
                     "sex":{
                         "type": "text",
                         "index": false
                     },
                     "age":{
                         "type": "long",
                         "index": false
                     }
                 }
            }
    #P18
        //创建ES客户端
        RestHighLevelClient client = new RestHighLevelClient(RestClient.builder(new HttpHost("localhost", 9200, "http")));
        client.close();
    #P19
        EsTestClientIndexCreate ——> 创建索引
    #P20
        EsTestClientIndexSearch ——> 查询索引
        EsTestClientIndexDelete ——> 删除索引
    #P21
        EsTestClientDocInsert ——> 插入文档
        EsTestClientDocUpdate ——> 修改文档
    #P22
        EsTestClientDocGet ——> get查询文档
        EsTestClientDocDelete ——> 删除文档
    #P23
        EsTestClientDocInsertBatch ——> 批量插入文档
        EsTestClientDocDeleteBatch ——> 批量删除文档
    #P24
        EsTestClientDocQuery ——> 查询所有索引数据
    #P25
        EsTestClientDocQuery ——> 条件查询所有索引数据
        EsTestClientDocQuery ——> 分页查询所有索引数据
        EsTestClientDocQuery ——> 排序查询所有索引数据
        EsTestClientDocQuery ——> 过滤字段查询所有索引数据
    #P26
        EsTestClientDocQuery ——> 组合查询查询所有索引数据
        EsTestClientDocQuery ——> 范围查询查询所有索引数据t
    #P27
        EsTestClientDocQuery ——> 模糊查询查询所有索引数据
        EsTestClientDocQuery ——> 高亮查询查询所有索引数据
    #P28
        EsTestClientDocQuery ——> 聚合查询查询所有索引数据
        EsTestClientDocQuery ——> 分组统计查询所有索引数据
    #P29 
        
        
        
        

