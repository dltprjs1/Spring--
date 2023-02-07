package hello.hellospring;

import hello.hellospring.AOP.TimeTraceAOP;
import hello.hellospring.repository.JdbcTemplateMemberRepository;
import hello.hellospring.repository.JpaMemberRepository;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

@Configuration
public class memberConfig {
    private final MemberRepository memberRepository;

    @Autowired
    public memberConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository);
    }




   /* @Bean
    public MemberRepository memberRepository(){
        return new JdbcTemplateMemberRepository(dataSource);
        return new JpaMemberRepository(em);
    }*/
}