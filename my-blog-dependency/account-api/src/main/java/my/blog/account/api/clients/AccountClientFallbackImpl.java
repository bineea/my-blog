package my.blog.account.api.clients;

import my.blog.account.api.model.UserModel;
import org.springframework.stereotype.Component;

@Component
public class AccountClientFallbackImpl implements AccountClient {

    @Override
    public UserModel findUserById(String userId) {
        return new UserModel();
    }
}
