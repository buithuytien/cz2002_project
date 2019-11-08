package staff.movie.crud;

import base.AbstractCRUD;
import staff.movie.entity.Movie;

public class MovieCRUD<T extends Movie> extends AbstractCRUD<T> {
	public MovieCRUD(Class<T> clazz) {
		this.dataList = new ArrayList<T>();
		this.dataClazz = clazz;
		this.read();
	}
}
