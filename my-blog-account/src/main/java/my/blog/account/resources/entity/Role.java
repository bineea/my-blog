package my.blog.account.resources.entity;

import lombok.Getter;
import lombok.Setter;
import my.blog.comm.base.entity.StringUUIDEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "blog_role")
public class Role extends StringUUIDEntity
{
	public static final String DEFAULT_ID = "default";

	@NotNull
	@Size(max = 30)
	@Getter(onMethod_={@Column(nullable = false, length = 100, unique = true, name = "name")})
	@Setter
	private String name;

	@NotNull
	@Min(value=1)
	@Max(value=999)
	@Getter(onMethod_={@Column(nullable = false, name = "list")})
	@Setter
	private Integer list;// 排序

	@Getter(onMethod_={@Column(length = 255, name = "info")})
	@Setter
	private String info;

	@Getter(onMethod_={@Column(nullable = false, name = "system")})
	@Setter
	private boolean system;// 是否系统自带
}
