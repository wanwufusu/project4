package com.stylefeng.guns.user.utils;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

@Component
public class JedisAdapter implements InitializingBean {

    JedisPool pool;

    @Override
    public void afterPropertiesSet() throws Exception {
        //jedis = new Jedis("localhost");
        pool = new JedisPool("182.61.60.156",6379);
    }

    public Jedis getJedis(){
        return pool.getResource();
    }

    public String get(String key) {
        Jedis jedis = null;
        try {
            jedis = pool.getResource();
            return jedis.get(key);
        } catch (Exception e) {
            return null;
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }

    public void set(String key, String value) {
       Jedis jedis = null;
        try {
            jedis = pool.getResource();
            jedis.set(key, value);
        } catch (Exception e) {
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }

    public void setex(String key,int time, String value) {
        Jedis jedis = null;
        try {
            jedis = pool.getResource();
            jedis.setex(key,time,value);
        } catch (Exception e) {
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }


    public Long del(String key) {
        Jedis jedis = null;
        try {
            jedis = pool.getResource();
            return jedis.del(key);
        } catch (Exception e) {
            return null;
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }
    public String hget(String key,String field) {
        Jedis jedis = null;
        try {
            jedis = pool.getResource();
            return jedis.hget(key,field);
        } catch (Exception e) {
            return null;
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }

    public void hset(String key,String field, String value) {
        Jedis jedis = null;
        try {
            jedis = pool.getResource();
            jedis.hset(key, field,value);
        } catch (Exception e) {
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }

    public Long hdel(String key,String field) {
        Jedis jedis = null;
        try {
            jedis = pool.getResource();
            return jedis.hdel(key,field);
        } catch (Exception e) {
            return null;
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }

}