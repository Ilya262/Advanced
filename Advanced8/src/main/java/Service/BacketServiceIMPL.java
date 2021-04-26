package Service;

import java.util.List;

import DAO.BacketDaoIMPL;
import Domain.Backet;
import ServiceInterface.BacketService;

public class BacketServiceIMPL implements BacketService{

	
BacketDaoIMPL backetdao;
static BacketService backetService;
public BacketServiceIMPL() {

	backetdao = new BacketDaoIMPL();
}

@Override
public Backet create(Backet backet) {
	
	return backetdao.create(backet);
}

@Override
public Backet read_by_id(Integer id) {
	
	return backetdao.read_by_id(id);
}

@Override
public Backet update(Backet backet) {

	return backetdao.update(backet);
}

@Override
public void delete(Integer id) {

	backetdao.delete(id);
}

@Override
public List<Backet> read_all() {
	
	return backetdao.read_all();
}



public static BacketService getBacketServiceImpl() {
	if(backetService==null) {
		
		backetService=new BacketServiceIMPL();
	}
	return backetService;
}
	
}
