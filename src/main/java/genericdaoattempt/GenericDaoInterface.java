package genericdaoattempt;

import java.io.Serializable;
import java.util.List;

public interface GenericDaoInterface<T, Id extends Serializable> {

	public void create(T model);
	
	public void update(T model);
	
	public T get(Id id);

	public List<T> getAll();
	
	public void delete(T entity);
	
	public void deleteAll();	
}
