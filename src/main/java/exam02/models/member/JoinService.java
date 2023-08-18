package exam02.models.member;

public class JoinService {

    private MemberDao memberDao;
    private JoinValidator validator;

    public JoinService(MemberDao memberDao, JoinValidator validator){
        this.memberDao = memberDao;
        this.validator = validator;
    }

    public void join(Member member) {
        validator.check(member);

        memberDao.register(member);
    }

}
