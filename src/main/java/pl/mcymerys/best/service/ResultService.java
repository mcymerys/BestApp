package pl.mcymerys.best.service;

import pl.mcymerys.best.dao.ResultDAO;
import pl.mcymerys.best.model.ResultDTO;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class ResultService {

	@EJB
	ResultDAO resultDAO;

	public List<ResultDTO> getResultJson(){
		List<ResultDTO> authorsCategoryBookCount = resultDAO.getAuthorCategoryBookCount();
		return authorsCategoryBookCount;
	}
}
