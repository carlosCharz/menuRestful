package com.wedevol.controller;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.Assert;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.wedevol.bean.Menu;
import com.wedevol.bean.MenusResponse;
import com.wedevol.dao.MenuDAO;
import com.wedevol.dao.impl.MenuDAOMockImpl;
import com.wedevol.service.MenuService;
import com.wedevol.service.impl.MenuServiceImpl;
import com.wedevol.util.Util;

@RunWith(MockitoJUnitRunner.class)
@ContextConfiguration("/servlet-context.xml")
@WebAppConfiguration
public class MenuControllerTest {

	private static final Logger logger = LoggerFactory.getLogger(MenuControllerTest.class);

	@Mock
	private MenuService menuServiceMock;

	@InjectMocks
	private MenuController menuController;

	private MockMvc mockMvc;

	private MenuDAO menuDAOMockImpl;

	@Before
	public void init() {
		mockMvc = MockMvcBuilders.standaloneSetup(menuController).build();
		menuDAOMockImpl = new MenuDAOMockImpl();
	}

	@Test
	public void getListMenus_MenusFound_ShouldReturnFoundMenus() throws Exception {

		final MenusResponse response = new MenusResponse();
		final List<Menu> menuList = menuDAOMockImpl.findAll();

		response.setCode(Util.OK_CODE);
		response.setMessage(Util.OK_MESSAGE);

		when(menuServiceMock.getMenus()).thenReturn(menuList);

		final MvcResult result = mockMvc.perform(get("/menu/list")).andExpect(status().isOk())
				.andExpect(content().contentType(Util.APPLICATION_JSON_UTF8)).andExpect(jsonPath("$.code", is(200)))
				.andExpect(jsonPath("$.message", is("OK"))).andExpect(jsonPath("$.menus", hasSize(3)))
				.andExpect(jsonPath("$.menus[0].id", is(1))).andExpect(jsonPath("$.menus[0].description", is("Menu 1")))
				.andExpect(jsonPath("$.menus[0].items", hasSize(2))).andReturn();

		logger.debug(Util.JSON_RESPONSE_LABEL + result.getResponse().getContentAsString());

		// Verify that the method is called only once
		verify(menuServiceMock, times(1)).getMenus();
		// Ensure that no other methods of our mock obj are called during test
		verifyNoMoreInteractions(menuServiceMock);
	}

	@Test
	public void sumPricesOfItems_ShouldReturnTotalPrice() {

		final MenuService menuService = new MenuServiceImpl();
		Menu menu;
		double sum;

		// Just items
		menu = menuDAOMockImpl.findById(1);
		sum = menuService.sumPricesOfItems(menu);
		Assert.assertEquals(22d, sum, 0.001);

		// Item + submenu
		menu = menuDAOMockImpl.findById(2);
		sum = menuService.sumPricesOfItems(menu);
		Assert.assertEquals(38d, sum, 0.001);

		// Item + submenu + submenu of the submenu
		menu = menuDAOMockImpl.findById(4);
		sum = menuService.sumPricesOfItems(menu);
		Assert.assertEquals(82d, sum, 0.001);
	}

}
