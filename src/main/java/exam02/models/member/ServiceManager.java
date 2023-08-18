package exam02.models.member;

public class ServiceManager {

    private static ServiceManager instance;

    public ServiceManager(){}

    public static ServiceManager getInstance(){
        if(instance == null){
            instance = new ServiceManager();
        }
        return instance;
    }

    public MemberDao memberDao(){
        return new MemberDao();
    }

    public JoinValidator joinValidator(){
        return new JoinValidator();
    }

    public JoinService joinService(){
        return new JoinService(memberDao(), joinValidator());
    }

    public ListService listService(){
        ListService service = new ListService();
        service.setMemberDao(memberDao());

        return service;
    }
}
