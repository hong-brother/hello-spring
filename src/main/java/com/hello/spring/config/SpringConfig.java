package com.hello.spring.config;

import com.hello.spring.repository.JdbcMemberRepository;
import com.hello.spring.repository.MemberRepository;
import com.hello.spring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {

    private final DataSource dataSource;

    @Autowired
    public SpringConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        // 1. Spring 내에 메모리를 DB로 입력하는 방법
        // return new MemoryMemberRepository();
        // 2. JDBC를 이용하는 방법
        return new JdbcMemberRepository(dataSource);
    }
}
