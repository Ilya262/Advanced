package ServiceInterface;

import Schared.AbsractCRUD;
import domain.User;

public interface UserService  extends AbsractCRUD<User>{
	public User UsergetEmail(String email);
}
