package Schared;

import java.util.List;

public interface AbsractCRUD<T> {

	public T create(T t);

	public	 T read_by_id(Integer id);

	public	T update(T t);

	public	void delete(Integer id);
	
	public	List<T> read_all();

}
