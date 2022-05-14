CREATE TABLE `blog_article` (
`id`  varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`user_id`  varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户id' ,
`title`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '标题' ,
`text`  longtext CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '内容' ,
`summany`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '摘要' ,
`markdown_enable`  tinyint(4) NOT NULL COMMENT '是否启用markdown' ,
`cover`  longblob NULL COMMENT '封面' ,
`article_status`  varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '文章状态' ,
`vote_up`  int(11) NOT NULL COMMENT '“顶”的数量' ,
`comment_count`  int(11) NOT NULL COMMENT '评论数量' ,
`view_count`  int(11) NOT NULL COMMENT '访问量' ,
`create_time`  datetime NOT NULL COMMENT '创建时间' ,
`update_time`  datetime NOT NULL COMMENT '更新时间' ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci COMMENT='文章表';