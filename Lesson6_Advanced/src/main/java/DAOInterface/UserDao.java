package DAOInterface;

import Schared.AbsractCRUD;
import domain.User;

public interface UserDao extends AbsractCRUD<User>{
	public User UsergetEmail(String email);
}
