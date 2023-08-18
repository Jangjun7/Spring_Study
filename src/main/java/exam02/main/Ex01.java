package exam02.main;

import exam02.models.member.JoinService;
import exam02.models.member.ListService;
import exam02.models.member.Member;
import exam02.models.member.ServiceManager;

import java.time.LocalDateTime;

public class Ex01 {
    public static void main(String[] args) {
        JoinService joinService = ServiceManager.getInstance().joinService();
        ListService listService = ServiceManager.getInstance().listService();

        Member member = new Member();
        member.setUserId("user01");
        member.setUserPw("123456");
        member.setUserNm("사용자01");
        member.setRegDt(LocalDateTime.now());

        joinService.join(member);

        listService.print();

    }
}
