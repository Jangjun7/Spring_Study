package exam06.models.member;

import exam04.config.ManualBean;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
@ManualBean
public class MemberDao { // memberDao
    private static Map<String, Member> members = new HashMap<>();

    public void register(Member member) {
        members.put(member.getUserId(), member);
    }

    public List<Member> getList(){
        return new ArrayList<Member>(members.values());
    }
}
