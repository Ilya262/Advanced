package ServiceInterface;

import Domain.User;
import Schared.AbsractCRUD;

public interface UserService  extends AbsractCRUD<User>{
	public User UsergetEmail(String email);
}
