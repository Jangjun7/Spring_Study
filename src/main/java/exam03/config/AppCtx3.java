package exam03.config;

import exam03.models.member.JoinValidator;
import exam03.models.member.MemberDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration // 반드시 들어가야하는 애노테이션
public class AppCtx3 {
    @Bean
    public MemberDao memberDao() {
        return new MemberDao();
    }

    @Bean
    public JoinValidator joinValidator() {
        return new JoinValidator();
    }
}
