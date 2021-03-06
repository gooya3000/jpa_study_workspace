package jpabook.japshop.service;

import jpabook.japshop.domain.Member;
import jpabook.japshop.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@Transactional
public class MemberServiceTest {

        @Autowired
        MemberService memberService;
        @Autowired
        MemberRepository memberRepository;

        @Test
        public void 회원가입() throws Exception {
            //given
            Member member = new Member();
            member.setName("kim");
            //when
            Long saveId = memberService.join(member);
            //then
            assertEquals(member, memberRepository.findOne(saveId));
        }
        
        @Test
        public void 중복회원예외() throws Exception {
            //given
            
            //when
            //then
        }
}
