package pers.zhenfeng.web.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.context.MessageSource;
import org.springframework.context.event.ApplicationEventMulticaster;
import org.springframework.stereotype.Controller;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import pers.zhenfeng.web.config.AppConfig;
import pers.zhenfeng.web.config.BeanUtil;
import pers.zhenfeng.web.config.ThreadLocalUtil;
import pers.zhenfeng.web.mapper.User;
import pers.zhenfeng.web.mapper.UserMapper;
import pers.zhenfeng.web.model.OOMDemo;
import redis.clients.jedis.Jedis;
import sun.misc.Signal;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;

/**
 * @author Grow-Worm
 * @date 2019/12/13
 */
@Controller
@RequestMapping("/demo")
public class DemoController {

    @Resource
    private MessageSource messageSource;
    @Resource
    private ApplicationArguments arguments;

    @Resource
    private UserMapper userMapper;

    @RequestMapping("index")
    public String getIndex() {
        return "Index";
    }

    @RequestMapping("detail")
    @ResponseBody
    public String getDemoDetail(@RequestParam("username") String username, @RequestParam("password") String password) {

        List<User> users = userMapper.queryUser();

        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        userMapper.insertUser(user);

        String[] sourceArgs = arguments.getSourceArgs();

        if (sourceArgs != null && sourceArgs.length > 0) {
            cpuExe(Integer.valueOf(sourceArgs[0]));
            System.out.println("CPu执行完成");
        } else {
            System.out.println("CONTROLLER 执行");
        }

        BeanUtil.getBean(ApplicationEventMulticaster.class).multicastEvent(new AppConfig.MyEvent("123"));

        return messageSource.getMessage("username", null, "", ThreadLocalUtil.getLocale());
    }

    @RequestMapping("oom")
    @ResponseBody
    public String produceOOM(Integer count) {
        if (ObjectUtils.isEmpty(count) || count <= 0) {
            return "参数错误";
        }

        oom(count);

        return "success";
    }

    @Value("${redis.host}")
    private String host;

    @Value("${redis.port}")
    private Integer port;

    @RequestMapping("redis")
    @ResponseBody
    public String redisProduce(String keyIndex, Integer count) {

        Jedis jedis = new Jedis(host, port);
        jedis.auth("guanzf");

        for (int i = 0; i < count; i++) {
            String randomValue = UUID.randomUUID().toString();

            jedis.set(keyIndex + i, randomValue);
        }

        System.out.println("complete!!!");

        return "SUCCESS";
    }

    @RequestMapping("redis-key")
    @ResponseBody
    public String getRedis(String keyIndex, Integer count) {
        Jedis jedis = new Jedis(host, port);

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < count; i++) {
            result.append(jedis.get(keyIndex + i)).append("  ");
        }

        System.out.println("complete!!!");

        return result.toString();
    }

    @RequestMapping("IP")
    @ResponseBody
    public String getIp(HttpServletRequest request, HttpServletResponse response) {
        System.out.println(request);
        return "test";
    }

    @RequestMapping("/insert/user")
    @ResponseBody
    public String patchInsertUser(Integer count) {
        while (count > 0) {

            User user = new User();
            user.setUsername(UUID.randomUUID().toString());
            user.setPassword(UUID.randomUUID().toString());

            userMapper.insertUser(user);

            count--;
        }

        return "SUCCESS";
    }


    private void cpuExe(Integer count) {
        for (int i = 0; i < count; i++) {
            long timeInMillis = Calendar.getInstance().getTimeInMillis();
            long l = timeInMillis * timeInMillis * timeInMillis;
            long l1 = timeInMillis / count;
        }

    }

    private void oom(Integer count) {

        List<OOMDemo> oom = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            OOMDemo oomDemo = new OOMDemo();
            oom.add(oomDemo);
        }

        System.out.println(oom.size());
    }

    @RequestMapping("user")
    @ResponseBody
    public User getUser(String username) {
        if (StringUtils.isEmpty(username)) {
            return null;
        }
        return userMapper.getUser(username);
    }

    @RequestMapping(value = "/post", method = RequestMethod.POST)
    @ResponseBody
    public String postTest(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("test");
        return "SUCCESS";
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    @ResponseBody
    public String postTest(User user) {
        System.out.println(user.toString());
        return "SUCCESS";
    }

}
