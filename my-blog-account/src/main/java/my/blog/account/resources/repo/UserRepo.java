package my.blog.account.resources.repo;

import my.blog.account.resources.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface UserRepo extends JpaRepository<User, String>, JpaSpecificationExecutor<User> {

}
