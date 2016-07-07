package com.wedevol.service.impl;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wedevol.bean.Item;
import com.wedevol.bean.Menu;
import com.wedevol.dao.MenuDAO;
import com.wedevol.exception.ErrorException;
import com.wedevol.exception.MenuNotFoundException;
import com.wedevol.exception.MenuServerErrorException;
import com.wedevol.service.MenuService;
import com.wedevol.util.Util;

/*
 * MenuServiceImpl
 */

@Service
public class MenuServiceImpl implements MenuService {

	private static final Logger logger = LoggerFactory.getLogger(MenuServiceImpl.class);

	@Autowired
	private MenuDAO menuDAO;

	@Override
	public List<Menu> getMenus() throws Exception {
		logger.debug("Calling the MenuServiceImpl.getMenus() method to test the profiler!");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			//TODO
		}
		return menuDAO.findAll();
	}

	@Override
	public List<Item> getItems(final Integer id, final String orderby, final Boolean asc) throws ErrorException {
		final List<Item> items;
		try {
			final Menu menu = menuDAO.findById(Integer.valueOf(id));
			if (menu == null) {
				throw new MenuNotFoundException();
			} else {
				items = menu.getItems();
				if (items == null) {
					throw new MenuNotFoundException();
				} else {
					if (orderby.equals(Util.ORDER_BY_PRICE)) {
						Collections.sort(items, new Comparator<Item>() {
							@Override
							public int compare(Item i1, Item i2) {
								if (asc) {
									return Double.compare(i1.getPrice(), i2.getPrice());
								} else {
									return Double.compare(i2.getPrice(), i1.getPrice());
								}
							}
						});
					} else {
						Collections.sort(items, new Comparator<Item>() {
							@Override
							public int compare(Item i1, Item i2) {
								if (asc) {
									return i1.getRanking() - i2.getRanking();
								} else {
									return i2.getRanking() - i1.getRanking();
								}
							}
						});
					}
				}
				return items;
			}
		} catch (MenuNotFoundException e) {
			throw new MenuNotFoundException();
		} catch (Exception e) {
			throw new MenuServerErrorException();
		}
	}

	/*
	 * Get the sum of the prices of the items of a menu (included of the
	 * submenus) (Question 4)
	 */
	@Override
	public double sumPricesOfItems(final Menu menu) {
		double total = 0d;
		if (menu == null) {
			return 0d;
		} else {
			for (Item item : menu.getItems()) {
				total += item.getPrice();
			}
			if (menu.getSubmenus() != null) {
				for (Menu sm : menu.getSubmenus()) {
					total += sumPricesOfItems(sm);
				}
			}
			return total;
		}
	}

	/*
	 * Get the quantity of active submenus of a menu (Question 5)
	 */
	@Override
	public int getQtyActiveSubmenus(final Menu menu) {
		int counter = 0;
		StringBuilder sb = new StringBuilder();
		if (menu == null) {
			return 0;
		} else {
			if (menu.getSubmenus() != null) {
				for (Menu sm : menu.getSubmenus()) {
					// To log all the submenus names (Question 6)
					sb.append(menu.getDecription()).append(Util.EMPTY_SPACE);
					if (sm.isActive()) {
						counter += 1;
					}
				}
				logger.debug(Util.SUBMENUS_LABEL + sb.toString());
			}
			return counter;
		}
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
