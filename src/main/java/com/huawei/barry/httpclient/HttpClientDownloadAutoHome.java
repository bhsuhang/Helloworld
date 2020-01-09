/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2019-2019. All rights reserved.
 */

package com.huawei.barry.httpclient;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

/**
 * 功能描述
 *
 * @author w00205937
 * @since 2019-09-27
 */
public class HttpClientDownloadAutoHome {
    public static void main(String[] args) throws IOException {
        CloseableHttpClient client = HttpClients.createDefault();
        try {
            HttpGet httpGet = new HttpGet("http://aladdin.autohome.com.cn/360_seriesInfo/seriesInfopathlist.json");
            System.out.println(httpGet.getRequestLine());
            CloseableHttpResponse response = client.execute(httpGet);
            String responseBody = EntityUtils.toString(response.getEntity(), "utf-8");
            System.out.println("---------------------------------------");
            System.out.println(responseBody);
            parseResutString(responseBody);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            client.close();
        }
    }

    private static void parseResutString(String responseBody) throws IOException {
        responseBody = responseBody.substring(1, responseBody.length() - 1);
        responseBody = responseBody.replaceAll("\"", "");
        String[] links = responseBody.split(",");
        CloseableHttpClient client = HttpClients.createDefault();
        for (int i = 0; i < links.length; i++) {
            HttpGet httpGet = new HttpGet(links[i]);
            String fileName = links[i].substring(links[i].lastIndexOf("/") + 1, links[i].length());
            CloseableHttpResponse response = client.execute(httpGet);
            response.getEntity()
                .writeTo(
                    new FileOutputStream("D:\\Onebox\\work\\14 应用市场\\09 设计文档\\06 搜索\\汽车之家推送数据20191106\\" + fileName));
            // String reponse = EntityUtils.toString(response.getEntity(), "utf-8");
        }
    }
}
