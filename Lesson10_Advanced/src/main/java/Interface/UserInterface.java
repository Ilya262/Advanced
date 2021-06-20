package Interface;

import Schared.AbsractCRUD;
import domain.User;

public interface UserInterface extends AbsractCRUD<User>{

	User getUserEmail(String email);

}
