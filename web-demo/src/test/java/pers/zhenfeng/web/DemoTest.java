package pers.zhenfeng.web;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.api.support.membermodification.MemberModifier;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.springframework.boot.ApplicationArguments;
import org.springframework.context.event.ApplicationEventMulticaster;
import pers.zhenfeng.web.config.BeanUtil;
import pers.zhenfeng.web.controller.DemoController;
import pers.zhenfeng.web.mapper.User;
import pers.zhenfeng.web.mapper.UserMapper;

/**
 * @author Grow-Worm
 * @date 2020/05/21
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({DemoController.class, UserMapper.class})
public class DemoTest {

    private DemoController demoController;

    @Mock
    private UserMapper userMapper;

    @Mock
    private ApplicationArguments arguments;

    @Before
    public void setup() throws Exception {
        MockitoAnnotations.initMocks(this);
        demoController = new DemoController();
        MemberModifier.field(DemoController.class, "userMapper").set(demoController, userMapper);
    }

    @Test
    public void DemoDetailTest() {
        User user = new User();
        user.setId(1);
        user.setUsername("wonder");
        user.setPassword("123456");

        Mockito.when(userMapper.getUser(Mockito.anyString())).thenReturn(user);

        Mockito.when(arguments.getSourceArgs()).thenReturn(null);

        String detail = demoController.getDemoDetail("123", "456");

        System.out.println("DemoTest.DemoDetailTest");
    }

}
