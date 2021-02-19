package com.codetogether.CodeTogether.service;

import com.codetogether.CodeTogether.domain.User;

import java.util.List;
import java.util.Optional;

public class UserService {
    //private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final Repository repository;

    public UserService(Repository repository) {
        this.Repository = repository;
    }

    public String save(User user) {
        //중복 검
        //db 저장.
        return user.intraId;
    }
}
