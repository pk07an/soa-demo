package com.meila.common.http;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpResponseException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public final class HttpUtils {
    /**
     * 单例实现
     */
    private static HttpUtils instance = new HttpUtils();

    private CloseableHttpClient httpClient = HttpClients.createDefault();

    public static HttpUtils getInstance() {
        return instance;
    }

    public JSONObject post(String url, JSONObject req) {
        // 添加时间戳
        req.put("time", System.currentTimeMillis());

        JSONObject resp;
        HttpPost httpPost = new HttpPost(url);
        HttpEntity entity = new StringEntity(req.toJSONString(), ContentType.APPLICATION_JSON);
        httpPost.setEntity(entity);

        ResponseHandler<JSONObject> responseHandler = getRespHandler();
        try {
            resp = httpClient.execute(httpPost, responseHandler);
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            return resp;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public JSONObject post(String url, JSONObject req, Map<String, String> headerMap) {
        // 添加时间戳
        req.put("time", System.currentTimeMillis());

        JSONObject resp;
        HttpPost httpPost = new HttpPost(url);
        for (Map.Entry<String, String> entry : headerMap.entrySet()) {
            httpPost.setHeader(entry.getKey(), entry.getValue());
        }
        HttpEntity entity = new StringEntity(req.toJSONString(), ContentType.APPLICATION_JSON);
        httpPost.setEntity(entity);

        ResponseHandler<JSONObject> responseHandler = getRespHandler();
        try {
            resp = httpClient.execute(httpPost, responseHandler);
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            return resp;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public JSONObject get(String url) {
        JSONObject resp;
        HttpGet httpGet = new HttpGet(url);

        ResponseHandler<JSONObject> responseHandler = getRespHandler();
        try {
            resp = httpClient.execute(httpGet, responseHandler);
            return resp;

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private ResponseHandler<JSONObject> getRespHandler() {
        return new ResponseHandler<JSONObject>() {
            @Override
            public JSONObject handleResponse(HttpResponse response) throws ClientProtocolException, IOException {
                StatusLine statusLine = response.getStatusLine();
                HttpEntity entity = response.getEntity();
                if (statusLine.getStatusCode() >= 300) {
                    throw new HttpResponseException(statusLine.getStatusCode(), statusLine.getReasonPhrase());
                }
                if (entity == null) {
                    throw new ClientProtocolException("Response contains no content");
                }
                ContentType contentType = ContentType.getOrDefault(entity);
                Charset charset = contentType.getCharset();
                Reader reader = new InputStreamReader(entity.getContent(), charset);
                StringBuilder builder = new StringBuilder();
                int temp = 0;
                while (-1 != (temp = reader.read())) {
                    builder.append((char) temp);
                }
                reader.close();
                String result = builder.toString();
                return JSON.parseObject(result);
            }
        };
    }
}
