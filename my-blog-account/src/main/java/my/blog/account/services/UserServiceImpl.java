package my.blog.account.services;

import my.blog.account.resources.entity.User;
import my.blog.account.resources.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends AbstractService implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public User findById(String userId) {
        return userRepo.findById(userId).orElse(null);
    }

}
