/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2019-2019. All rights reserved.
 */

package com.huawei.barry.httpclient;

import java.io.IOException;

import org.apache.http.HttpException;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHttpRequest;
import org.apache.http.protocol.HttpCoreContext;
import org.apache.http.protocol.HttpProcessor;
import org.apache.http.protocol.HttpProcessorBuilder;
import org.apache.http.protocol.RequestConnControl;
import org.apache.http.protocol.RequestContent;
import org.apache.http.protocol.RequestExpectContinue;
import org.apache.http.protocol.RequestUserAgent;
import org.apache.http.util.EntityUtils;

/**
 * 功能描述
 *
 * @author w00205937
 * @since 2019-11-21
 */
class HttpClientforUber {
    public static void main(String[] args) {
        CloseableHttpClient client = HttpClients.custom()
            .setUserAgent(
                "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/78.0.3904.97 Safari/537.36")
            .build();
        HttpProcessor httpproc = HttpProcessorBuilder.create()
            // Required protocol interceptors
            .add(new RequestContent())
            // .add(new RequestTargetHost())
            // Recommended protocol interceptors
            .add(new RequestConnControl())
            .add(new RequestUserAgent(
                "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/78.0.3904.97 Safari/537.36"))
            // Optional protocol interceptors
            .add(new RequestExpectContinue(true))
            .build();

        HttpCoreContext context = HttpCoreContext.create();
        HttpRequest request = new BasicHttpRequest("GET", "https://www.uber.com/");
        CloseableHttpResponse response = null;
        try {

            httpproc.process(request, context);
            response = client.execute(HttpHost.create("https://www.uber.com"), request, context);
            httpproc.process(response, context);
            String responseBody = EntityUtils.toString(response.getEntity(), "utf-8");
            System.out.println("---------------------------------------");
            System.out.println(response.getStatusLine());
            System.out.println(responseBody);
        } catch (HttpException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
