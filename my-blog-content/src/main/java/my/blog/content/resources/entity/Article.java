package my.blog.content.resources.entity;

import lombok.Getter;
import lombok.Setter;
import my.blog.comm.base.entity.StringUUIDEntity;
import my.blog.content.resources.entity.dict.ArticleStatus;

import javax.persistence.*;
import java.sql.Blob;
import java.time.LocalDateTime;

@Entity
@Table(name = "blog_article")
public class Article extends StringUUIDEntity {

    @Getter(onMethod_={@Column(name = "user_id")})
    @Setter
    private String userId;// 作者ID
    @Getter(onMethod_={@Column(name = "title")})
    @Setter
    private String title;// 标题
    @Getter(onMethod_={@Column(name = "text")})
    @Setter
    private String text;// 内容
    @Getter(onMethod_={@Column(name = "summany")})
    @Setter
    private String summany;// 摘要
    @Getter(onMethod_={@Column(name = "markdown_enable")})
    @Setter
    private Boolean markdownEnable = false;// 是否启用markdown
    @Getter(onMethod_={@Column(name = "cover")})
    @Setter
    private Blob cover;// 封面
    @Getter(onMethod_={@Enumerated(EnumType.STRING), @Column(name = "article_status")})
    @Setter
    private ArticleStatus articleStatus;// 文章状态
    @Getter(onMethod_={@Column(name = "vote_up")})
    @Setter
    private Integer voteUp = 0;// “顶”的数量
    @Getter(onMethod_={@Column(name = "comment_count")})
    @Setter
    private Integer commentCount = 0;// 评论数量
    @Getter(onMethod_={@Column(name = "view_count")})
    @Setter
    private Integer viewCount = 0;// 访问量
    @Getter(onMethod_={@Column(name = "create_time")})
    @Setter
    private LocalDateTime createTime;// 创建时间
    @Getter(onMethod_={@Column(name = "update_time")})
    @Setter
    private LocalDateTime updateTime;// 更新时间

}
