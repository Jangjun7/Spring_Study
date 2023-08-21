package exam06.models.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class ListService {
    private final MemberDao memberDao;

    public void print(){
        List<Member> members = memberDao.getList();
        members.stream().forEach(System.out::println);
    }

}
