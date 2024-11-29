package com.fag.domain.repositories;

import com.fag.domain.dto.UserAccount;

public interface IUserRepository {
    UserAccount createUser(UserAccount dto);

    UserAccount findUserby(String document);
}
