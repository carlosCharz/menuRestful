package com.wedevol.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wedevol.bean.Item;
import com.wedevol.bean.ItemsResponse;
import com.wedevol.bean.Menu;
import com.wedevol.bean.MenuResponse;
import com.wedevol.bean.MenusResponse;
import com.wedevol.bean.StateResponse;
import com.wedevol.exception.ErrorException;
import com.wedevol.service.MenuService;
import com.wedevol.util.Util;

/*
 * MenuController: main menu rest api (Question 1)
 */

@Controller
@RequestMapping("/menu")
public class MenuController {

	private static final Logger logger = LoggerFactory.getLogger(MenuController.class);

	@Autowired
	private MenuService menuService;

	/* Get list of menus (Question 2) */
	/*
	 * http://localhost:8080/menuRestful/menu/list
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
	public @ResponseBody MenusResponse getListMenus() {

		final MenusResponse response = new MenusResponse();
		List<Menu> list;

		try {
			list = menuService.getMenus();
			response.setMenus(list);
			response.setCode(Util.OK_CODE);
			response.setMessage(Util.OK_MESSAGE);
			logger.debug(Util.OK_LABEL + list);
		} catch (Exception e) {
			response.setMenus(null);
			response.setCode(Util.SERVER_ERROR_CODE);
			response.setMessage(e.getMessage());
			logger.error(Util.ERROR_LABEL + e.getMessage());
		}
		return response;
	}

	/* Get a menu items ordered by price or ranking (Question 3) */
	/*
	 * http://localhost:8080/menuRestful/menu/1/items?orderby=price&asc=true
	 */
	@RequestMapping(value = "/{id}/items", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
	public @ResponseBody ItemsResponse getItemsGroupedBy(@PathVariable("id") Integer id,
			@RequestParam(value = "orderby", defaultValue = "price", required = true) String orderby,
			@RequestParam(value = "asc", defaultValue = "true", required = true) Boolean asc) {

		ItemsResponse response = new ItemsResponse();
		List<Item> items;

		try {
			items = menuService.getItems(id, orderby, asc);
			response.setItems(items);
			response.setCode(Util.OK_CODE);
			response.setMessage(Util.OK_MESSAGE);
			logger.debug(Util.OK_LABEL + items);
		} catch (ErrorException e) {
			response.setItems(null);
			response.setCode(e.getCode());
			response.setMessage(e.getMessage());
			logger.error(Util.ERROR_LABEL + e.getMessage());
		}
		return response;
	}

	/* Get a menu */
	/*
	 * http://localhost:8080/menuRestful/menu/1
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
	public @ResponseBody MenuResponse getMenu(@PathVariable("id") Integer id) {

		MenuResponse response = new MenuResponse();
		Menu menu;

		try {
			menu = menuService.getMenu(id);
			response.setMenu(menu);
			response.setCode(Util.OK_CODE);
			response.setMessage(Util.OK_MESSAGE);
			logger.debug(Util.OK_LABEL + menu);
		} catch (ErrorException e) {
			response.setMenu(null);
			response.setCode(e.getCode());
			response.setMessage(e.getMessage());
			logger.error(Util.ERROR_LABEL + e.getMessage());
		}
		return response;
	}

	/* Create a menu */
	/*
	 * http://localhost:8080/menuRestful/menu/create
	 */
	@RequestMapping(value = "/create", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	public @ResponseBody StateResponse createMenu(@RequestBody Menu request) {

		/* TODO */
		return new StateResponse();

	}

	/* Update a menu */
	/*
	 * http://localhost:8080/menuRestful/menu/6
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, produces = "application/json; charset=utf-8")
	public @ResponseBody StateResponse updateMenu(@PathVariable("id") int id, @RequestBody Menu request) {

		/* TODO */
		return new StateResponse();

	}

	/* Delete a menu */
	/*
	 * http://localhost:8080/menuRestful/menu/6
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "application/json; charset=utf-8")
	public @ResponseBody StateResponse deleteMenu(@PathVariable("id") int id) {

		/* TODO */
		return new StateResponse();
	}
}
