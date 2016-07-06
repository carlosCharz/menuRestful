package com.wedevol.dao.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.wedevol.bean.Item;
import com.wedevol.bean.Menu;
import com.wedevol.bean.WeekDay;
import com.wedevol.dao.MenuDAO;
import com.wedevol.util.Util;

/*
 * MenuDAOMockImpl: mock class for the menu DAO (until we code the real DAO)
 */

@Repository
public class MenuDAOMockImpl implements MenuDAO {

	// List is working as a database
	private List<Menu> menus;

	public MenuDAOMockImpl() {
		menus = new ArrayList<Menu>();
		SimpleDateFormat sdf = new SimpleDateFormat(Util.DATE_FORMAT);

		try {
			// Menu with 2 items but zero submenus
			Menu m1 = new Menu(1, "Menu 1", true);
			Item i1 = new Item(1, "Item 1", "Description of Item 1", 10d, "$", 4);
			i1.setPhoto(null);
			i1.setDays(Arrays.asList(WeekDay.MONDAY, WeekDay.TUESDAY));

			i1.setDateFrom(sdf.parse("10/04/2016"));
			i1.setDateTo(sdf.parse("10/05/2016"));
			i1.setHourFrom("20:00");
			i1.setHourTo("23:00");
			Item i2 = new Item(2, "Item 2", "Description of Item 2", 12d, "$", 5);
			i2.setPhoto(null);
			i2.setDays(Arrays.asList(WeekDay.WEDNESDAY, WeekDay.THURSDAY));
			i2.setDateFrom(sdf.parse("15/04/2016"));
			i2.setDateTo(sdf.parse("15/05/2016"));
			i2.setHourFrom("10:00");
			i2.setHourTo("15:00");
			m1.setItems(Arrays.asList(i1, i2));
			m1.setSubmenus(null);
			menus.add(m1);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<Menu> findAll() {
		return menus;
	}

	@Override
	public Menu findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Menu findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean insertMenu(Menu menu) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateMenu(Menu menu) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteMenu(int id) {
		// TODO Auto-generated method stub
		return false;
	}

}
