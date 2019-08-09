package com.jf.xuan.common.util;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Maps;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Component;

import java.net.URLEncoder;
import java.util.Map;

/**
 * httpclient辅助类
 *
 * @author Junfeng
 */
@Component
public class HttpClientUtil {

    /**
     * get请求
     *
     * @param url     请求地址
     * @param params  参数
     * @param headers 头
     * @return 服务端返回信息
     * @throws Exception 异常信息
     */
    public Map<String, Object> get(String url, Map<String, Object> params, Map<String, String> headers)
            throws Exception {
        try (CloseableHttpClient httpclient = HttpClients.createDefault()) {

            // 参数处理
            if (null != params && !params.isEmpty()) {
                StringBuilder stringBuilder = new StringBuilder();
                for (Map.Entry<String, Object> entry : params.entrySet()) {
                    String key = entry.getKey();
                    Object value = entry.getValue();
                    stringBuilder.append("&").append(key).append("=").append(URLEncoder.encode(String.valueOf(value), "UTF-8"));
                }
                String questionMark = "?";
                if (url.contains(questionMark)) {
                    url += stringBuilder.substring(1);
                } else {
                    url += "?" + stringBuilder.substring(1);
                }
            }

            HttpGet httpGet = new HttpGet(url);

            // 头处理
            if (null != headers && !headers.isEmpty()) {
                for (Map.Entry<String, String> entry : headers.entrySet()) {
                    String key = entry.getKey();
                    String value = entry.getValue();
                    httpGet.setHeader(key, value);
                }
            }

            ResponseHandler<Map<String, Object>> responseHandler = response -> {
                Map<String, Object> resultMap = Maps.newHashMapWithExpectedSize(2);
                resultMap.put("status", response.getStatusLine().getStatusCode());
                HttpEntity entity = response.getEntity();
                resultMap.put("responseTxt", entity != null ? EntityUtils.toString(entity) : null);
                return resultMap;
            };

            return httpclient.execute(httpGet, responseHandler);
        }
    }

    /**
     * post请求
     *
     * @param url     请求地址
     * @param params  参数
     * @param headers 头
     * @return 服务端返回信息
     * @throws Exception 异常信息
     */
    public Map<String, Object> post(String url, Map<String, Object> params, Map<String, String> headers)
            throws Exception {
        return post(url, JSON.toJSONString(params), headers);
    }

    /**
     * post请求
     *
     * @param url     请求地址
     * @param params  参数
     * @param headers 头
     * @return 服务端返回信息
     * @throws Exception 异常信息
     */
    public Map<String, Object> post(String url, String params, Map<String, String> headers) throws Exception {
        try (CloseableHttpClient httpclient = HttpClients.createDefault()) {
            HttpPost httpPost = new HttpPost(url);

            // 参数处理
            if (StringUtils.isNotBlank(params)) {
                StringEntity stringEntity = new StringEntity(params, "UTF-8");
                httpPost.setEntity(stringEntity);
            }

            // 头处理
            if (null != headers && !headers.isEmpty()) {
                for (Map.Entry<String, String> entry : headers.entrySet()) {
                    String key = entry.getKey();
                    String value = entry.getValue();
                    httpPost.setHeader(key, value);
                }
            }

            ResponseHandler<Map<String, Object>> responseHandler = response -> {
                Map<String, Object> resultMap = Maps.newHashMapWithExpectedSize(2);
                resultMap.put("status", response.getStatusLine().getStatusCode());
                HttpEntity entity = response.getEntity();
                resultMap.put("responseTxt", entity != null ? EntityUtils.toString(entity) : null);
                return resultMap;
            };
            return httpclient.execute(httpPost, responseHandler);
        }
    }

    /**
     * delete请求
     *
     * @param url     请求url
     * @param headers 头
     * @return 服务器返回信息
     * @throws Exception 异常信息
     */
    public Map<String, Object> delete(String url, Map<String, String> headers) throws Exception {
        try (CloseableHttpClient httpclient = HttpClients.createDefault()) {
            HttpDelete httpDelete = new HttpDelete(url);

            // 头处理
            if (null != headers && !headers.isEmpty()) {
                for (Map.Entry<String, String> entry : headers.entrySet()) {
                    String key = entry.getKey();
                    String value = entry.getValue();
                    httpDelete.setHeader(key, value);
                }
            }

            ResponseHandler<Map<String, Object>> responseHandler = response -> {
                Map<String, Object> resultMap = Maps.newHashMapWithExpectedSize(2);
                resultMap.put("status", response.getStatusLine().getStatusCode());
                HttpEntity entity = response.getEntity();
                resultMap.put("responseTxt", entity != null ? EntityUtils.toString(entity) : null);
                return resultMap;
            };
            return httpclient.execute(httpDelete, responseHandler);
        }
    }

    /**
     * put请求
     *
     * @param url     请求地址
     * @param params  参数
     * @param headers 头
     * @return 服务器返回信息
     * @throws Exception 异常
     */
    public Map<String, Object> put(String url, Map<String, Object> params, Map<String, String> headers)
            throws Exception {
        try (CloseableHttpClient httpclient = HttpClients.createDefault()) {
            HttpPut httpPut = new HttpPut(url);

            // 参数处理
            if (null != params && !params.isEmpty()) {
                StringEntity stringEntity = new StringEntity(JSON.toJSONString(params), "UTF-8");
                httpPut.setEntity(stringEntity);
            }

            // 头处理
            if (null != headers && !headers.isEmpty()) {
                for (Map.Entry<String, String> entry : headers.entrySet()) {
                    String key = entry.getKey();
                    String value = entry.getValue();
                    httpPut.setHeader(key, value);
                }
            }

            ResponseHandler<Map<String, Object>> responseHandler = response -> {
                Map<String, Object> resultMap = Maps.newHashMapWithExpectedSize(2);
                resultMap.put("status", response.getStatusLine().getStatusCode());
                HttpEntity entity = response.getEntity();
                resultMap.put("responseTxt", entity != null ? EntityUtils.toString(entity) : null);
                return resultMap;
            };
            return httpclient.execute(httpPut, responseHandler);
        }
    }

}
