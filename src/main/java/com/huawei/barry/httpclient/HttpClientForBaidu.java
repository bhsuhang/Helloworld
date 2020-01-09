/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2019-2019. All rights reserved.
 */

package com.huawei.barry.httpclient;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.apache.http.HttpHost;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.client.utils.URIUtils;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

/**
 * 功能描述
 *
 * @author w00205937
 * @since 2019-11-20
 */
class HttpClientForBaidu {
    public static void main(String[] args) throws IOException {
        // CloseableHttpClient client = HttpClients.createDefault();
        CloseableHttpClient client = HttpClients.custom()
            .setUserAgent(
                "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/78.0.3904.97 Safari/537.36")
            .build();
        try {
            HttpGet httpGet = new HttpGet("https://www.youtube.com");

            System.out.println(httpGet.getRequestLine());
            httpGet.addHeader("accept",
                "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3");
            // httpGet.addHeader("connection", "Keep-Alive");
            httpGet.addHeader("user-agent",
                "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/78.0.3904.97 Safari/537.36");
            httpGet.addHeader("accept-language", "en-GB,en;q=0.9,en-GB;q=0.8,en;q=0.7");
            httpGet.addHeader("locale", "en-GB");
            // httpGet.setHeader("accept-language", "en-GB,en;q=0.9,en-GB;q=0.8,en;q=0.7");

            // CloseableHttpResponse response = client.execute(httpGet);
            // String responseBody = EntityUtils.toString(response.getEntity(), "utf-8");

            HttpClientContext context = HttpClientContext.create();
            CloseableHttpResponse response = client.execute(httpGet, context);
            String responseBody = EntityUtils.toString(response.getEntity(), "utf-8");
            try {
                HttpHost target = context.getTargetHost();
                List<URI> redirectLocations = context.getRedirectLocations();
                URI location = URIUtils.resolve(httpGet.getURI(), target, redirectLocations);

                System.out.println("Final HTTP location: " + location.toASCIIString());
                // Expected to be an absolute URI
            } finally {
                response.close();
            }

            System.out.println("---------------------------------------");
            System.out.println(response.getStatusLine());
            System.out.println(responseBody);
            // parseResutString(responseBody);
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        } finally {
            client.close();
        }
    }
}
