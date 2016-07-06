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
		Menu sm1;
		Item i1, i2;

		try {
			// Menu with 2 items but zero submenus
			Menu m1 = new Menu(1, "Menu 1", true);
			i1 = new Item(1, "Item 1", "Description of Menu 1 - Item 1", 10d, "$", 4);
			i1.setPhoto(null);
			i1.setDays(Arrays.asList(WeekDay.MONDAY, WeekDay.TUESDAY));
			i1.setDateFrom(sdf.parse("10/04/2016"));
			i1.setDateTo(sdf.parse("10/05/2016"));
			i1.setHourFrom("20:00");
			i1.setHourTo("23:00");
			i2 = new Item(2, "Item 2", "Description of Menu 1- Item 2", 12d, "$", 5);
			i2.setPhoto(null);
			i2.setDays(Arrays.asList(WeekDay.WEDNESDAY, WeekDay.THURSDAY));
			i2.setDateFrom(sdf.parse("15/04/2016"));
			i2.setDateTo(sdf.parse("15/05/2016"));
			i2.setHourFrom("10:00");
			i2.setHourTo("15:00");
			m1.setItems(Arrays.asList(i1, i2));
			m1.setSubmenus(null);
			menus.add(m1);

			// Menu with 1 item and 1 submenu (with 1 item and zero submenus)
			Menu m2 = new Menu(2, "Menu 2", true);
			i1 = new Item(1, "Item 1", "Description of Menu 2 -Item 1", 15d, "$", 4);
			i1.setPhoto(null);
			i1.setDays(Arrays.asList(WeekDay.FRIDAY, WeekDay.SATURDAY, WeekDay.SUNDAY));
			i1.setDateFrom(sdf.parse("12/06/2016"));
			i1.setDateTo(sdf.parse("12/07/2016"));
			i1.setHourFrom("20:00");
			i1.setHourTo("23:00");
			m2.setItems(Arrays.asList(i1));

			sm1 = new Menu(3, "Menu 2 - SubMenu 1", true);
			i1 = new Item(1, "Menu 2 - SubMenu 1 - Item 1", "Description of Menu 2 - SubMenu 1 - Item 1", 23d, "$", 3);
			i1.setPhoto(null);
			i1.setDays(Arrays.asList(WeekDay.FRIDAY, WeekDay.SATURDAY));
			i1.setDateFrom(sdf.parse("14/09/2016"));
			i1.setDateTo(sdf.parse("14/09/2016"));
			i1.setHourFrom("17:00");
			i1.setHourTo("24:00");
			sm1.setItems(Arrays.asList(i1));
			sm1.setSubmenus(null);
			m2.setSubmenus(Arrays.asList(sm1));
			menus.add(m2);

			// Menu with 1 item and 2 submenu (1st: 1 item and zero submenus and
			// 2nd: 1 item and 1 submenu)
			Menu m3 = new Menu(4, "Menu 3", true);
			i1 = new Item(1, "Item 1", "Description of Menu 3 - Item 1", 18d, "$", 2);
			i1.setPhoto(null);
			i1.setDays(Arrays.asList(WeekDay.FRIDAY, WeekDay.SATURDAY, WeekDay.SUNDAY));
			i1.setDateFrom(sdf.parse("09/02/2016"));
			i1.setDateTo(sdf.parse("09/04/2016"));
			i1.setHourFrom("15:00");
			i1.setHourTo("19:00");
			m3.setItems(Arrays.asList(i1));

			sm1 = new Menu(5, "SubMenu 1", true);
			i1 = new Item(1, "Item 1", "Description of Menu 3 - SubMenu 1 - Item 1.", 27d, "$", 2);
			i1.setPhoto(null);
			i1.setDays(Arrays.asList(WeekDay.FRIDAY));
			i1.setDateFrom(sdf.parse("19/01/2016"));
			i1.setDateTo(sdf.parse("19/02/2016"));
			i1.setHourFrom("17:00");
			i1.setHourTo("20:00");
			sm1.setItems(Arrays.asList(i1));
			sm1.setSubmenus(null);

			Menu sm2 = new Menu(6, "SubMenu 2", true);
			i1 = new Item(1, "SubMenu 2 - Item 1", "Description of Menu 3 - SubMenu 2 - Item 1.", 27d, "$", 2);
			i1.setPhoto(null);
			i1.setDays(Arrays.asList(WeekDay.FRIDAY));
			i1.setDateFrom(sdf.parse("19/01/2016"));
			i1.setDateTo(sdf.parse("19/02/2016"));
			i1.setHourFrom("17:00");
			i1.setHourTo("20:00");
			sm2.setItems(Arrays.asList(i1));
			Menu sm1a = new Menu(7, "SubMenu2 - SubMenu a", true);
			i1 = new Item(1, "Item 1", "Description of Menu 3 - SubMenu2 - SubMenu a - Item 1", 10d, "$", 4);
			i1.setPhoto(null);
			i1.setDays(Arrays.asList(WeekDay.MONDAY, WeekDay.TUESDAY));
			i1.setDateFrom(sdf.parse("10/04/2016"));
			i1.setDateTo(sdf.parse("10/05/2016"));
			i1.setHourFrom("20:00");
			i1.setHourTo("23:00");
			sm1a.setItems(Arrays.asList(i1));
			sm1a.setSubmenus(null);
			sm2.setSubmenus(Arrays.asList(sm1a));

			m3.setSubmenus(Arrays.asList(sm1, sm2));
			menus.add(m3);
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
