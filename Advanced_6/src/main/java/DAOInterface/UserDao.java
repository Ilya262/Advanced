package DAOInterface;

import Domain.User;
import Schared.AbsractCRUD;

public interface UserDao extends AbsractCRUD<User>{
	public User UsergetEmail(String email);
}
