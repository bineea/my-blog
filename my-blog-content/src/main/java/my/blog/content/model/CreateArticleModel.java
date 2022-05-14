package my.blog.content.model;

import lombok.Getter;
import lombok.Setter;
import my.blog.comm.base.entity.BaseEntity;
import my.blog.content.resources.entity.dict.ArticleStatus;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotBlank;
import java.util.List;

public class CreateArticleModel extends BaseEntity {

    @NotBlank
    @Getter
    @Setter
    private String userId;

    @Getter
    @Setter
    private String title;// 标题

    @Getter
    @Setter
    private String text;// 内容

    @Getter
    @Setter
    private String summany;// 摘要

    @Getter
    @Setter
    private boolean markdownEnable;// 是否启用markdown

    @Getter
    @Setter
    private MultipartFile cover;// 封面

    @Getter
    @Setter
    private List<String> categoryIds;// 类别

    @Getter
    @Setter
    private ArticleStatus articleStatus;// 状态
}
