package exam02.models.member;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Member {
    private String userId; // 아이디
    private String userPw; // 비밀번호
    private String userNm; // 사용자명
    private LocalDateTime regDt; // 가입 일자
}
