package article.controllers;

import java.util.HashMap;
import java.util.Map;

public class ModelAndView { // 같은 형식으로 넘기기 위한 Class
	// 경로와 넘겨질 데이터를 가지고 있는 객체
	private String viewName;
	private Map<String, Object> model = new HashMap<>();

	public Map<String, Object> getModel() {
		return model;
	}

	public void addObject(String key, Object obj) {
		this.model.put(key, obj);
	}

	public String getViewName() {
		return viewName;
	}

	public void setViewName(String viewName) {
		this.viewName = viewName;
	}

	public ModelAndView() {

	}

	public ModelAndView(String viewName) {
		this.viewName = viewName;
	}

	public ModelAndView(String viewName, String key, Object obj) {
		this.viewName = viewName;
		model.put(key, obj);
	}

	@Override
	public String toString() {
		return "ModelAndView [model=" + model + ", viewName=" + viewName + "]";
	}

}
