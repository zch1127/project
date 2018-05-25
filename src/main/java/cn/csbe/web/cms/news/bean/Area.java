package cn.csbe.web.cms.news.bean;

import java.io.Serializable;

/**
 * 地址表
 * @author sx
 *
 */
public class Area implements Serializable  {
	
	private Integer id;
	private Integer parent_id;
	private String name;
	private String path_route;
	private String area_region_id;
	private String create_date;
	@Override
	public String toString() {
		return "Area [id=" + id + ", parent_id=" + parent_id + ", name=" + name
				+ ", path_route=" + path_route + ", area_region_id="
				+ area_region_id + ", create_date=" + create_date + "]";
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getParent_id() {
		return parent_id;
	}
	public void setParent_id(Integer parent_id) {
		this.parent_id = parent_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPath_route() {
		return path_route;
	}
	public void setPath_route(String path_route) {
		this.path_route = path_route;
	}
	public String getArea_region_id() {
		return area_region_id;
	}
	public void setArea_region_id(String area_region_id) {
		this.area_region_id = area_region_id;
	}
	public String getCreate_date() {
		return create_date;
	}
	public void setCreate_date(String create_date) {
		this.create_date = create_date;
	}
	public Area(Integer id, Integer parent_id, String name, String path_route,
			String area_region_id, String create_date) {
		super();
		this.id = id;
		this.parent_id = parent_id;
		this.name = name;
		this.path_route = path_route;
		this.area_region_id = area_region_id;
		this.create_date = create_date;
	}
	public Area() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
