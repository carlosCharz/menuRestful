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
import org.springframework.web.bind.annotation.ResponseBody;

import com.wedevol.bean.Menu;
import com.wedevol.bean.MenuResponse;
import com.wedevol.bean.MenusResponse;
import com.wedevol.bean.StateResponse;
import com.wedevol.service.MenuService;
import com.wedevol.util.Util;

/*
 * MenuController: main menu rest api
 */

@Controller
@RequestMapping("/menu")
public class MenuController {

	private static final Logger logger = LoggerFactory.getLogger(MenuController.class);

	@Autowired
	private MenuService menuService;

	/* Get list of menus */
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

	/* Get a menu */
	/*
	 * http://localhost:8080/menuRestful/menu/1
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
	public @ResponseBody MenuResponse getMenu(@PathVariable("id") Integer id) {

		/* TODO */
		return new MenuResponse();
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