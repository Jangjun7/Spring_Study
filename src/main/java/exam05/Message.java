package exam05;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Message implements InitializingBean, DisposableBean {
    public void send(String message){
        System.out.println("보낸 메세지 : " + message);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("afterPropertiesSet!!"); // 초기화 단계
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("Destroy!!"); // 소멸 단계 전
    }
}
