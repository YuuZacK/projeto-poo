package com.fag.infra.testdb;

import java.util.ArrayList;
import java.util.List;

import com.fag.domain.dto.UserAccount;
import com.fag.domain.repositories.IUserRepository;

public class UserTestDB implements IUserRepository {

    private List<UserAccount> users = new ArrayList<>();

    @Override
    public UserAccount createUser(UserAccount dto) {
        users.add(dto);

        return dto;
    }

    @Override
    public UserAccount findUserby(String document) {
        for (UserAccount user : users) {
            if (user.getDocument().equals(document)) {
                return user;
            }
        }

        return null;

    }

}