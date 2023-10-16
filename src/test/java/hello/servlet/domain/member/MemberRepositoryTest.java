package hello.servlet.domain.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

public class MemberRepositoryTest {
    MemberRepository memberRepository = MemberRepository.getInstance();

    @AfterEach
    void afterEach(){
        memberRepository.clearStore();
    }

    @Test
    void save(){
        Member member1 = new Member("member1",1);

        Member saved = memberRepository.save(member1);

        Member result = memberRepository.findById(saved.getId());
        Assertions.assertThat(result).isEqualTo(saved);
    }

    @Test
    void findAll(){
        Member member1 = new Member("member1",1);
        Member member2 = new Member("member2",2);

        Member m1 = memberRepository.save(member1);
        Member m2 = memberRepository.save(member1);

        Assertions.assertThat(memberRepository.findALl().size()).isEqualTo(2);
        Assertions.assertThat(memberRepository.findALl()).contains(m1,m2);
    }
}
