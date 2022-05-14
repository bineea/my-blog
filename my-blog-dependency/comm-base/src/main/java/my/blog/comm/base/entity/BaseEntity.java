package my.blog.comm.base.entity;

import my.blog.comm.base.tools.JsonTools;

import java.io.IOException;

public abstract class BaseEntity {

	public final String toJson() {
		return toJson(false);
	}
	
	public final String toJson(boolean format) {
		
		try {
			String jsonStr = JsonTools.entityToJson(this);
			return format ? JsonTools.formatJson(jsonStr) : jsonStr;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
}
