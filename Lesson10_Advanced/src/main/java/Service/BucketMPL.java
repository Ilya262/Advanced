package Service;

import java.util.List;

import DAO.BucketDAO;
import ServiceInterface.BucketService;
import domain.Bucket;

public class BucketMPL implements BucketService{

	private static BucketService bucketService;
private BucketDAO bucketdao;


public static BucketService getbucketService() {
	
	if(bucketService==null) {
		
		bucketService=new BucketMPL();
		
	}
	return bucketService;
	
}


private BucketMPL() {

	bucketdao = new BucketDAO();
}

@Override
public Bucket create(Bucket backet) {
	
	return bucketdao.create(backet);
}

@Override
public Bucket read_by_id(Integer id) {
	
	return bucketdao.read_by_id(id);
}

@Override
public Bucket update(Bucket backet) {

	return bucketdao.update(backet);
}

@Override
public void delete(Integer id) {

	bucketdao.delete(id);
}

@Override
public List<Bucket> read_all() {
	
	return bucketdao.read_all();
}


	
}
