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
        

        
        
    