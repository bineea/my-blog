package my.blog.account.services;

import my.blog.account.resources.entity.User;

public interface UserService {

    User findById(String userId);
}
