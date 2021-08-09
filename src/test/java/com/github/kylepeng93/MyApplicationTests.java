package com.github.kylepeng93;

import com.github.kylepeng93.service.TimeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.Instant;

import static org.assertj.core.api.Assertions.assertThat;
/**
 * 测试类
 * https://kylepeng93.github.io
 *
 * @author pengkai
 * @date 2021-07-23 下午10:24
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MyApplicationTests {
    @Autowired
    private GenericApplicationContext context;

    @Test
    public void timeServiceTest() {
        var timeService = (TimeService) context.getBean("com.github.kylepeng93.service.TimeService");
        var now = timeService.getNow();
        assertThat(now.isBefore(Instant.now()));
    }

}
