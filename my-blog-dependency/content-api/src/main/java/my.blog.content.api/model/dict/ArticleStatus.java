package my.blog.content.api.model.dict;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum ArticleStatus {

	TEMPORARY("未发布","暂存"){},
	NORMAL("已发布","正常"){},
	FORBIDCOMMENT("已发布","禁止评论"){},
	TOP("已发布","置顶"){},
	;

	@Getter
	private String publishValue;
	@Getter
	private String statusValue;
	
}
