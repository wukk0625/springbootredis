package demo01.controller;

import demo01.model.RedisModel;
import demo01.model.User;
import demo01.serviceimpl.RedisServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2017/3/1 14:55.
 */
@RestController
public class TestController {
    @Autowired
    private RedisServiceImpl service;

    //添加
    @RequestMapping(value = "/add")
    public void test() {
        System.out.println("start.....");
        RedisModel redisModel = new RedisModel();
        redisModel.setKey("u1");
        User user = new User();
        user.setAge(12);
        user.setName("jack");
        redisModel.setValue(user);
        service.put(redisModel.getKey(), redisModel, -1);
        System.out.println("add success end...");
    }

    //查询所有对象
    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public Object getAll() {
        return service.getAll();
    }

    //查询所有key
    @RequestMapping(value = "/getKeys", method = RequestMethod.GET)
    public Object getKeys() {
        return service.getKeys();
    }

    //根据key查询
    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public Object get() {
        RedisModel redisModel = new RedisModel();
        redisModel.setKey("name");
        return service.get(redisModel.getKey());
    }

    //删除
    @RequestMapping(value = "/remove", method = RequestMethod.GET)
    public void remove() {
        RedisModel redisModel = new RedisModel();
        redisModel.setKey("name");
        service.remove(redisModel.getKey());
    }

    //判断key是否存在
    @RequestMapping(value = "/isKeyExists", method = RequestMethod.GET)
    public void isKeyExists() {
        RedisModel redisModel = new RedisModel();
        redisModel.setKey("name");
        boolean flag = service.isKeyExists(redisModel.getKey());
        System.out.println("zhangsanKey01 是否存在: " + flag);
    }

    //查询当前缓存的数量
    @RequestMapping(value = "/count", method = RequestMethod.GET)
    public Object count() {
        return service.count();
    }

    //清空所有key
    @RequestMapping(value = "/empty", method = RequestMethod.GET)
    public void empty() {
        service.empty();
    }

}