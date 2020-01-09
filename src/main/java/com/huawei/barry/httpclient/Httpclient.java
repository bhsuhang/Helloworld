
package com.huawei.barry.httpclient;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.cookie.BasicClientCookie;
import org.apache.http.util.EntityUtils;

public class Httpclient<params> {

    static String url =
        "http://v.10pinping.com/api/captchar.vote.png.php?authType=10&rnd=58490112314959746&id=1123149&outb=0";
    // static String url = "http://wwww.baidu.com";

    private static BasicCookieStore cookieStore = new BasicCookieStore();

    public static void main(String[] args) throws IOException {

        RequestConfig requestConfig =
            RequestConfig.custom().setConnectTimeout(5000).setConnectionRequestTimeout(1000).build();

        cookieStore.addCookie(
            new BasicClientCookie("UM_distinctid", "16c564e67882f-0d8f7d60a30284-235b4c30-448e0-16c564e678947"));
        cookieStore.addCookie(new BasicClientCookie("myb_openinfo",
            "%257B%2522uid%2522%253A%252215110554%2522%252C%2522token%2522%253A%252257afc28db43ae7cb0d5e4b9ae95c041e%2522%257D; Hm_lvt_54a0788fec161f0476e41c6a89cf9520=1564816075,1566484178"));
        cookieStore
            .addCookie(new BasicClientCookie("Hm_lvt_54a0788fec161f0476e41c6a89cf9520", "1564816075,1566484178"));
        cookieStore.addCookie(new BasicClientCookie("Hm_lpvt_54a0788fec161f0476e41c6a89cf9520", "1566542208"));

        // 创建httpClient对象
        CloseableHttpClient httpclient = HttpClients.custom().setDefaultCookieStore(cookieStore).build();

        HttpGet getMethod = new HttpGet(url);

        getMethod.setHeader("Connection", "keep-alive");
        getMethod.setHeader("User-Agent",
            "Mozilla/5.0 (Linux; Android 9; LYA-AL00 Build/HUAWEILYA-AL00; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/66.0.3359.126 MQQBrowser/6.2 TBS/044807 Mobile Safari/537.36 MMWEBID/4235 MicroMessenger/7.0.6.1460(0x27000634) Process/tools NetType/WIFI Language/zh_CN");
        getMethod.setHeader("Accept", "image/webp,image/wxpic,image/sharpp,image/apng,image/tpg,image/*,*/*;q=0.8");
        getMethod.setHeader("Referer",
            "http://m.10pinping.com/v/p.php?s=c0f6c4d71353941d&b=e1ab5ea5052ee618&fx=62&from=groupmessage");
        getMethod.setHeader("Accept-Encoding", "gzip, deflate");
        getMethod.setHeader("Accept-Language", "zh-CN,en-GB;q=0.9,en-US;q=0.8");

        HttpResponse response = httpclient.execute(getMethod);

        HttpEntity repEntity = response.getEntity();
        String content = EntityUtils.toString(repEntity, "UTF-8");
        System.out.println(content);
        //
        // byte[] buffer = new byte[response.getEntity().getContent().available()];
        // response.getEntity().getContent().read(buffer);
        //
        // System.out.println(response.getStatusLine());
        // System.out.println(new String(buffer));

    }
}
