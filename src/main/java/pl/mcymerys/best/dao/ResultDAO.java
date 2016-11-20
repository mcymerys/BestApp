package pl.mcymerys.best.dao;

import pl.mcymerys.best.model.ResultDTO;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
public class ResultDAO {

	@PersistenceContext
	protected EntityManager em;

	public List<ResultDTO> getAuthorCategoryBookCount() {
		String sql = "SELECT NEW pl.mcymerys.best.model.ResultDTO(a.firstName, a.lastName, c.name, COUNT(b.id)) " +
				" FROM Author a, Book b, Category c JOIN b.authors ba " +
				" WHERE b.category.id = c.id AND ba.id = a.id " +
				" GROUP BY a.id, c.name";
		TypedQuery<ResultDTO> q = em.createQuery(sql, ResultDTO.class);
		return q.getResultList();
	}
}
