package pl.mcymerys.best.view;

import pl.mcymerys.best.model.ResultDTO;
import pl.mcymerys.best.service.DataService;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import java.util.List;

@ManagedBean(name = "dataView")
@ViewScoped
public class DataView {

	private List<ResultDTO> RESTResult;

	@ManagedProperty("#{dataService}")
	private DataService dataService;

	@PostConstruct
	public void init() {
		RESTResult = dataService.getDataFromREST();
	}

	public List<ResultDTO> getRESTResult() {
		return RESTResult;
	}

	public void setDataService(DataService dataService) {
		this.dataService = dataService;
	}
}
