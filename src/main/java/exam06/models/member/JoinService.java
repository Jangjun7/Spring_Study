package exam06.models.member;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class JoinService {
    @Autowired
    private final MemberDao memberDao;

    @NonNull
    private JoinValidator validator;

    public JoinService(MemberDao memberDao, JoinValidator validator){
        this.memberDao = memberDao;
        this.validator = validator;
    }

    public void join(Member member) {
        // MemberDao memberDao = opt.get();

        validator.check(member);

        memberDao.register(member);
    }

}
