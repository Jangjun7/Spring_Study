package exam04.models.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class ListService {
    private MemberDao memberDao;
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yy.mm.dd");

    //@Autowired(required = false) // 의존 자동 주입 (required = false : 의존하고 있는 객체가 스프링 컨테이너에 없으면 호출 X)
    @Autowired
    public void setFormatter(@Nullable DateTimeFormatter formatter) { // @Nullable : 이 값을 null로 처리
        this.formatter = formatter;
    }

    @Autowired
    public void setMemberDao(MemberDao memberDao){
        this.memberDao = memberDao;
    }

    public void print(){
        List<Member> members = memberDao.getList();
        members.stream().map(this::toConvert).forEach(System.out::println);
    }

    private Member toConvert(Member member) {
        if(formatter!=null) {
            member.setRegDtStr(formatter.format(member.getRegDt()));
        }

        return member;
    }
}
