package vo.user;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRoleVo {
	
	private String user_num;
	
	private String user_role;

	public String getUser_num() {
		return user_num;
	}

}
