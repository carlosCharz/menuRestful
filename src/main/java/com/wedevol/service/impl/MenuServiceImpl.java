package com.wedevol.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wedevol.bean.Menu;
import com.wedevol.dao.MenuDAO;
import com.wedevol.exception.ErrorException;
import com.wedevol.exception.MenuNotFoundException;
import com.wedevol.exception.MenuServerErrorException;
import com.wedevol.service.MenuService;

/*
 * MenuServiceImpl
 */

@Service
public class MenuServiceImpl implements MenuService {

	@Autowired
	private MenuDAO menuDAO;

	@Override
	public List<Menu> getMenus() throws Exception {
		return menuDAO.findAll();
	}

	@Override
	public Menu getMenu(Integer id) throws ErrorException {
		try {
			final Menu menu = menuDAO.findById(Integer.valueOf(id));
			if (menu == null) {
				throw new MenuNotFoundException();
			} else {
				return menu;
			}
		} catch (MenuNotFoundException e) {
			throw new MenuNotFoundException();
		} catch (Exception e) {
			throw new MenuServerErrorException();
		}
	}

	@Override
	public void createMenu(final Menu menu) throws ErrorException {
		// TODO
	}

	@Override
	public void updateMenu(final Menu menu) throws ErrorException {
		// TODO
	}

	@Override
	public void deleteMenu(int id) throws ErrorException {
		// TODO
	}

}
