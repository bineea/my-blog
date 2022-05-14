package my.blog.account.resources.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import my.blog.account.resources.entity.dict.Male;
import my.blog.comm.base.entity.StringUUIDEntity;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "blog_user")
public class User extends StringUUIDEntity {

	public static final String DEFAULT_PWD = "123456";
	@NotNull
	@Size(max = 50, message = "{userName.error}")
	@Getter(onMethod_={@Column(name = "name")})
	@Setter
	private String name;//昵称

	@Getter(onMethod_={@Enumerated(EnumType.STRING),@Column(name = "male")})
	@Setter
	private Male male;

	@NotNull
	@Email
	@Getter(onMethod_={@Column(name = "email")})
	@Setter
	private String email;//唯一

	@NotNull
	@Size(max = 20, message = "登录名长度不能超过20")
	@Getter(onMethod_={@Column(name = "login_name")})
	@Setter
	private String loginName;//账号（字母+数字）唯一

	@JsonIgnore
	@Getter(onMethod_={@Column(name = "pass_wd")})
	@Setter
	private String passwd;

	@Getter(onMethod_={@Enumerated(EnumType.STRING),@Column(name = "status")})
	@Setter
	private UserStatus status = UserStatus.NORMAL;

	@Getter(onMethod_={@ManyToOne, @JoinColumn(name = "role_id")})
	@Setter
	private Role role;
//	@JsonIgnore
//	private Blob profilePicture; //头像（昵称首字母或数字图片）

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
