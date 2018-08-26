package demo01.model;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/3/1 14:55.
 */
public class RedisModel implements Serializable {
    private String key;//redis中的key
    private Object value;//姓名

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }
}