package com.hello.spring.config;

import com.hello.spring.repository.JdbcMemberRepository;
import com.hello.spring.repository.JdbcTemplateMemberRepository;
import com.hello.spring.repository.JpaMemberRepository;
import com.hello.spring.repository.MemberRepository;
import com.hello.spring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

@Configuration
public class SpringConfig {

    // private final DataSource dataSource;
    //4. JPA를 이용하는 방법
    // private final EntityManager em;

    //4. JPA를 이용하는 방법
    /* @Autowired
    public SpringConfig(DataSource dataSource, EntityManager em) {
        this.dataSource = dataSource;
        this.em = em;
    }*/

    private final MemberRepository memberRepository;

    @Autowired
    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository);
    }

    // @Bean
    // public MemberRepository memberRepository() {
        // 1. Spring 내에 메모리를 DB로 입력하는 방법
        // return new MemoryMemberRepository();
        // 2. JDBC를 이용하는 방법
        //return new JdbcMemberRepository(dataSource);
        // 3. JDBC Template 이용하는 방법
        //return new JdbcTemplateMemberRepository(dataSource);
        // 4. JPA를 이용하는 방법
        // return new JpaMemberRepository(em);
    // }
}
