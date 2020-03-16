package test;

import com.exhk.robot.order.Robot3KlineApp;
import com.exhk.robot.order.service.LuckyService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes ={Robot3KlineApp.class}, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TestLuckyService {
    @Autowired
    LuckyService luckyService;
    @Test
    public void testCj(){
        Integer cj = luckyService.cj(1);

    }
}
