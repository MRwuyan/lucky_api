/*
package net.bit1.api.common.config.redis;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.redisson.config.SingleServerConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;

@Configuration
public class RedisionConfig {

    @Bean(destroyMethod="shutdown")
    public RedissonClient redisson() throws IOException {
            Config config=   Config.fromYAML(new ClassPathResource("redisson.yml").getInputStream());
        //config.useSingleServer();

        RedissonClient redisson = Redisson.create(config);
        return redisson;
    }
}
*/
