package my.blog.account.api.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class RoleModel {
    @Getter
    @Setter
    private String id;
    @Getter
    @Setter
    private String name;

    @NotNull
    @Min(value=1)
    @Max(value=999)
    @Getter
    @Setter
    private Integer list;// 排序

    @Getter
    @Setter
    private String info;

    @Getter
    @Setter
    private boolean system;// 是否系统自带
}
