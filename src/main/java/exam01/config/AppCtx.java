package exam01.config;

import exam01.Greeter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration // 설정
public class AppCtx {
    @Bean // 스프링이 관리할 객체
    public Greeter greeter() {
        return new Greeter();
    }
}