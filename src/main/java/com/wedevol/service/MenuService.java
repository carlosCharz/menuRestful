package com.wedevol.service;

import java.util.List;

import com.wedevol.bean.Menu;
import com.wedevol.exception.ErrorException;

/*
 * MenuService Interface
 */

public interface MenuService {

	public List<Menu> getMenus() throws Exception;

	public Menu getMenu(Integer id) throws ErrorException;

	public void createMenu(Menu menu) throws ErrorException;

	public void updateMenu(Menu menu) throws ErrorException;

	public void deleteMenu(int id) throws ErrorException;

}
