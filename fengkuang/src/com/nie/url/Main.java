package com.nie.url;

import java.util.Hashtable;
import java.util.Map;
import java.util.Random;

public class Main {
	
	private static Map<String, String> cache = new Hashtable<String, String>();
	private static final String str = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private static final int num = 7;
	
	public static void main(String[] args) {
		Main main = new Main();
		String inputStr = "http://www.boldseas.com";
		String encode = main.encode(inputStr);
		
		String decode = main.decode(encode);
		
		System.out.println(encode + " : " + decode);
		
    }

    // 编码

    public String encode(String longUrl) {
    	Random r = new Random();
    	int range = str.length();  
    	StringBuffer sb = new StringBuffer();
    	// 随机取指定个数的字符
        for (int i = 0; i < num; i ++) {   
            sb.append(str.charAt(r.nextInt(range)));   
        }
        
        String result = sb.toString();
        // 若存在，重新生成
        if (cache.containsKey(result.toString())) {
        	encode(longUrl);
        } else {
        	cache.put(result, longUrl);
        }
        return result;

    }

    // 解码

    public String decode(String shortUrl) {
    	if (cache.isEmpty())
    		return null;
    	
    	String result = cache.get(shortUrl);
        return result;

    }
    
    //Answer
    /*
     * 1.URL可以存储在Redis， 或者用Zookeeper来协调，保持一致性
     */
    
    /*
     * 2.为了保证URL的唯一性，需要集中管理URL，是性能瓶颈
     */
    
    /*
     * 3.通过哈希负载等方式
     */
    
    /*
     * 4.如果采用redis，qps峰值约10000/s
     */

    /*
     * 5.通过集群冗余的方式
     */

    /*
     * 6.缓存URL, 12小时
     */

    /*
     * 7.解码url的api
     */

}
