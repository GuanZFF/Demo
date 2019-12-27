package pers.zhenfeng.web.controller;

import com.alibaba.fastjson.JSON;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.boot.ApplicationArguments;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.ApplicationEventMulticaster;
import org.springframework.stereotype.Controller;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import pers.zhenfeng.web.config.AppConfig;
import pers.zhenfeng.web.config.BeanUtil;
import pers.zhenfeng.web.config.ThreadLocalUtil;
import pers.zhenfeng.web.mapper.User;
import pers.zhenfeng.web.mapper.UserMapper;
import pers.zhenfeng.web.model.OOMDemo;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

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


}
