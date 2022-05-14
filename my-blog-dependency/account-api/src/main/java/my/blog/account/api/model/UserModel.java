package my.blog.account.api.model;

import lombok.Getter;
import lombok.Setter;
import my.blog.account.api.model.dict.Male;

import javax.validation.constraints.Email;

public class UserModel {
    @Getter
    @Setter
    private String id;

    @Getter
    @Setter
    private String name;//昵称

    @Getter
    @Setter
    private Male male;

    @Email
    @Getter
    @Setter
    private String email;//唯一

    @Getter
    @Setter
    private String loginName;//账号（字母+数字）唯一

    @Getter
    @Setter
    private UserStatus status = UserStatus.NORMAL;

    @Getter
    @Setter
    private RoleModel role;

    public enum UserStatus {
        NORMAL("正常") {
        },
        INVALID("禁用") {
        };

        private String value;

        private UserStatus(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

    }
}
