package com.whs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * 原生态纯Java对象的Http请求
 * @author haiswang
 *
 */
public class SimpleClient {

    /**
     * @param args
     */
    public static void main(String[] args) {
        
        BufferedReader br = null;
        HttpURLConnection httpConnection = null;
        
        try {
            URL url = new URL("http://127.0.0.1:8080/standard/get/name");
            httpConnection = (HttpURLConnection)url.openConnection();
            
            //发起GET请求,JDK文档有支持情况
            httpConnection.setRequestMethod("GET");
            //设置读取
            httpConnection.setReadTimeout(5 * 1000);
            httpConnection.connect();
            
            
            int responseCode = httpConnection.getResponseCode();
            //
            if(HttpURLConnection.HTTP_OK == responseCode) {
                InputStream is = httpConnection.getInputStream();
                br = new BufferedReader(new InputStreamReader(is));
                String tmp = null;
                while(null!=(tmp=br.readLine())) {
                    System.out.println(tmp);
                }
            } else {
                System.out.println("Error code : " + responseCode);
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(null!=br) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            
            if(null!=httpConnection) {
                httpConnection.disconnect();
            }
        }
        
    }

}
