package com.example.shortmessage.util;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.URLDecoder;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.SimpleHttpConnectionManager;
import org.apache.commons.httpclient.URI;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.params.HttpClientParams;

/**
 *   param:  url 应用地址，类似于http://ip:port/msg/
 *   param:  un 账号
 *   param:  pw 密码
 *   param:  phone 手机号码，多个号码使用","分割
 *   param:  msg 短信内容
 *   param:  ex 扩展码
 *   param:  rd 是否需要状态报告，需要true，不需要false
 *   return: 返回值定义参见HTTP协议文档
 *   throws: Exception
 *
 * @Author mjj
 * @Date 16:38 2021/11/18
 * @Param
 * @return
 **/

//https://www.feige.cn/devs/guide4.html 接口文档
//定义发送方法
public class HttpSender {
    public static String batchSend(String url, String un, String pw, String phone, String msg,
                                   String rd, String ex) throws Exception {
        HttpClient client = new HttpClient(new HttpClientParams(), new SimpleHttpConnectionManager(true));
        GetMethod method = new GetMethod();
        try {
            URI base = new URI(url, false);
            method.setURI(new URI(base, "HttpBatchSendSM", false));
            method.setQueryString(new NameValuePair[] {
                    new NameValuePair("account", un),
                    new NameValuePair("pswd", pw),
                    new NameValuePair("mobile", phone),
                    new NameValuePair("needstatus", rd),
                    new NameValuePair("msg", msg),
                    new NameValuePair("extno", ex),
            });
            int result = client.executeMethod(method);
            if (result == HttpStatus.SC_OK) {
                InputStream in = method.getResponseBodyAsStream();
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                byte[] buffer = new byte[1024];
                int len = 0;
                while ((len = in.read(buffer)) != -1) {
                    baos.write(buffer, 0, len);
                }
                return URLDecoder.decode(baos.toString(), "UTF-8");
            } else {
                throw new Exception("HTTP ERROR Status: " + method.getStatusCode() + ":" + method.getStatusText());
            }
        } finally {
            method.releaseConnection();
        }
    }
}




//测试 调用HttpSender方法发送
class HttpSenderTest {
    public static void main(String[] args) {
        String url = "http://116.62.212.142/msg/HttpSendSM";// 应用地址
        String un = "13917186462";// 账号
        String pw = "mjj13917186462";// 密码
        String phone = "13917186462";// 手机号码，多个号码使用","分割
        String msg = "【麦讯通】您好，你的验证码是123456";// 短信内容
        String rd = "1";// 是否需要状态报告，需要true，不需要false
        String ex = null;// 扩展码

        try {
            String returnString = HttpSender.batchSend(url, un, pw, phone, msg, rd, ex);
            System.out.println(returnString);
            // TODO 处理返回值,参见HTTP协议文档
        } catch (Exception e) {
            // TODO 处理异常
            e.printStackTrace();
        }
    }
}

