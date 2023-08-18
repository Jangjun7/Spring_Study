package exam03.config;

import exam03.models.member.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import java.time.format.DateTimeFormatter;

@Configuration
@Import(AppCtx3.class) // AppCtx3을 추가
public class AppCtx2 {

    @Bean // 스프링의 객체임을 알려주는 애노테이션 (스프링 컨테이너에 추가)
    public JoinService joinService() {
        return new JoinService();
    }

    @Bean
    public ListService listService() {
        return new ListService();
    }

    //@Bean
    public DateTimeFormatter dateTimeFormatter(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.mm.dd HH:mm");

        return formatter;
    }
}
