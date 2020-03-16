/*
package test;

import net.bit1.api.CommomWebApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.redisson.Redisson;
import org.redisson.api.*;
import org.redisson.config.Config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes ={CommomWebApplication.class}, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TestRedissionService {


    @Autowired
    private RedissonClient redisson;
    @Test
    public void redisson() {
        String user_id="1";
        String key=user_id+"_key";
        //获取锁
        RLock lock = redisson.getLock(key);
        lock.lock();
        //执行具体逻辑...
        RBucket<Object> bucket = redisson.getBucket("a");
        bucket.set("bb");
        lock.unlock();
    }
}
*/
