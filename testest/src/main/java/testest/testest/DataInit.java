package testest.testest;

import testest.testest.entity.Member;
import testest.testest.entity.MemberStatus;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import testest.testest.repository.MemberRepository;

import javax.annotation.PostConstruct;

@Component
@Slf4j
@RequiredArgsConstructor
public class DataInit {

    private final MemberRepository memberRepository;

    @PostConstruct
    void init(){
        Member member1 = new Member();
        member1.setName("이태민");
        member1.setMemberStatus(MemberStatus.ADMIN);
        member1.setNumber("010-1234-1234");
        member1.setPassword("1234");
        memberRepository.save(member1);
    }
}
