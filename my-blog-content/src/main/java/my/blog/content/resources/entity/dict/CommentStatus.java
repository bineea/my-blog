package my.blog.content.resources.entity.dict;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum CommentStatus {
	
	NORMAL("正常"){},
	DELETE("删除"){},
	;

	@Getter
	private String value;

}
