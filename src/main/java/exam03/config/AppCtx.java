package exam03.config;

import exam03.models.member.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
public class AppCtx {
    @Bean // 스프링 관련 객체임을 알려주는 애노테이션
    public MemberDao memberDao(){
        return new MemberDao();
    }

    @Bean
    public JoinValidator joinValidator(){
        return new JoinValidator();
    }

    @Bean
    public JoinService joinService(){
        return new JoinService(memberDao(), joinValidator());
    }

    @Bean
    public ListService listService(){
        ListService listService = new ListService();
        listService.setMemberDao(memberDao());

        return listService;
    }
}
