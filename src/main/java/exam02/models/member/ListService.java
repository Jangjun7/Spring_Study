package exam02.models.member;

import java.util.List;

public class ListService {
    private MemberDao memberDao;

    public void setMemberDao(MemberDao memberDao){
        this.memberDao = memberDao;
    }

    public void print(){
        List<Member> members = memberDao.getList();
        members.stream().forEach(System.out::println);
    }
}
