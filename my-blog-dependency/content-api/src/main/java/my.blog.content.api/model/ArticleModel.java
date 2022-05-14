package my.blog.content.api.model;

import lombok.Getter;
import lombok.Setter;
import my.blog.content.api.model.dict.ArticleStatus;

import java.sql.Blob;
import java.time.LocalDateTime;

public class ArticleModel {

    @Getter
    @Setter
    private String id;// 唯一标识
    @Getter
    @Setter
    private String userId;// 作者ID
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
    private Boolean markdownEnable = false;// 是否启用markdown
    @Getter
    @Setter
    private Blob cover;// 封面
    @Getter
    @Setter
    private ArticleStatus articleStatus;// 文章状态
    @Getter
    @Setter
    private Integer voteUp = 0;// “顶”的数量
    @Getter
    @Setter
    private Integer commentCount = 0;// 评论数量
    @Getter
    @Setter
    private Integer viewCount = 0;// 访问量
    @Getter
    @Setter
    private LocalDateTime createTime;// 创建时间
    @Getter
    @Setter
    private LocalDateTime updateTime;// 更新时间
}
