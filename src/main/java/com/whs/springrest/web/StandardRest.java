package com.whs.springrest.web;

import java.util.concurrent.ConcurrentHashMap;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 标准rest服务
 * @author haiswang
 *
 */
@RestController
@RequestMapping("/standard")
public class StandardRest {
    
    /**
     * 资源信息
     */
    private ConcurrentHashMap<String, String> resources = new ConcurrentHashMap<String, String>();
    
    /**
     * GET是用来获取资源的
     * @param key
     * @return
     */
    @RequestMapping(value="/get/{key}" , method=RequestMethod.GET)
    public String getResource(@PathVariable String key) {
        System.out.println("Get Resource ,Key : " + key);
        String result = resources.get(key);
        return null==result ? "unknow key" : result;
    }
    
    /**
     * POST是用来新建资源的(也可以用来更新)
     * @param key
     * @param value
     * @return
     */
    @RequestMapping(value="/post/{key}/{value}" , method=RequestMethod.POST)
    public String postResource(@PathVariable String key, @PathVariable String value) {
        System.out.println("Post Resource ,Key : " + key);
        resources.put(key, value);
        return "Success!!!";
    }
    
    /**
     * PUT是用来更新资源的
     * @param key
     * @param value
     * @return
     */
    @RequestMapping(value="/put/{key}/{value}" , method=RequestMethod.PUT)
    public String putResource(@PathVariable String key, @PathVariable String value) {
        System.out.println("Put Resource ,Key : " + key);
        resources.put(key, value);
        return "Success!!!";
    }
    
    /**
     * DELETE是用来删除资源的
     * @param key
     * @return
     */
    @RequestMapping(value="/delete/{key}" , method=RequestMethod.DELETE)
    public String deleteResource(@PathVariable String key) {
        System.out.println("Delete Resource ,Key : " + key);
        resources.remove(key);
        return "Success!!!";
    }
}
