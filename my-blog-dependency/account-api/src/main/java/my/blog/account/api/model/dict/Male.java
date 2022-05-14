package my.blog.account.api.model.dict;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum Male {
	MALE("男") {},
	FEMAIL("女") {},
	NEUTER("要你管") {};

	@Getter
	private String value;
}
