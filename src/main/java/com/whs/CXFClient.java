package com.whs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

import javax.ws.rs.core.Response;

import org.apache.cxf.jaxrs.client.WebClient;

public class CXFClient {

    /**
     * @param args
     */
    public static void main(String[] args) {
        
        WebClient client = WebClient.create("http://127.0.0.1:8080/standard/get/name");
        Response response = null;
        response = client.get();
        
        int status = response.getStatus();
        
        InputStream is = null;
        BufferedReader br = null;
        if(HttpURLConnection.HTTP_OK == status) {
            is = (InputStream)response.getEntity();
            br = new BufferedReader(new InputStreamReader(is));
            String tmpLine = null;
            try {
                while(null!=(tmpLine=br.readLine())) {
                    System.out.println(tmpLine);
                }
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
            }
        } else {
            System.out.println("Error Code : " + status);
        }
        
    }

}
