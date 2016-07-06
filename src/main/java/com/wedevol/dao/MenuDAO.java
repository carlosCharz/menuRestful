package com.wedevol.dao;

import java.util.List;

import com.wedevol.bean.Menu;

/*
 * MenuDAO Interface
 */

public interface MenuDAO {

	public List<Menu> findAll();

	public Menu findById(int id);

	public Menu findByName(String name);

	public boolean insertMenu(Menu menu);

	public boolean updateMenu(Menu menu);

	public boolean deleteMenu(int id);

}
