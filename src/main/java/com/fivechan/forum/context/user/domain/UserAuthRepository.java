package com.fivechan.forum.context.user.domain;

public interface UserAuthRepository {
    UserAuth findByUsername(String username);
    UserAuth findByEmail(String email);
    void save(UserAuth userAuth);
}
