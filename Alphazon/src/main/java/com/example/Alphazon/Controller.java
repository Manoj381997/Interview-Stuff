package com.example.Alphazon;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@org.springframework.stereotype.Controller
public class Controller {
	private List<Restaurant> restaurantList = new ArrayList<>();
	private List<Order> orderList = new ArrayList<>();
	
	@GetMapping("/")
	public String home() {
		return "home";
	}
	
	@GetMapping("/upload")
	public String upload() {
		return "upload";
	}
	
	@PostMapping("/import")
	public ModelAndView updateData(@RequestParam("file") MultipartFile myFile) throws IOException {
	    updateDataFromExcel(myFile);
	    ModelAndView mv = listAll();
	    return mv;
	}
	
	@GetMapping("/restaurants")
	public ModelAndView listAll() {
		ModelAndView mv = new ModelAndView();
	    mv.addObject("list", restaurantList);
	    if (restaurantList.size() == 0) mv.addObject("isPresent", false);
	    else mv.addObject("isPresent", true);
	    mv.setViewName("restaurants");
	    return mv;
	}
	
	@PostMapping("/addOrders")
	public ModelAndView addOrders(@RequestParam("name") String restName) {
		Restaurant restaurant = getRestaurant(restName);
		ModelAndView mv = new ModelAndView();
		
		if (restaurant == null) return mv;
		
		mv.addObject("restaurant", restaurant);
		mv.setViewName("order");
		return mv;
	}
	
	private Restaurant getRestaurant(String restName) {		
		for (Restaurant rest: restaurantList) {
			if (rest.getName().equals(restName)) {
				return rest;
			}
		}
		return null;
	}
	
	@PostMapping("/submitOrder")
	public ModelAndView submitOrder(@RequestParam("quantity") int quantity, @RequestParam("name") String name) {
		Restaurant restaurant = getRestaurant(name);
		ModelAndView mv = new ModelAndView();
		mv.addObject("isInvalid", true);
		mv.setViewName("success");
		
		if (restaurant.getQuantity() < 0) return mv;
		
		for (int i = 0; i < restaurantList.size(); i++) {
			if (restaurantList.get(i).getName().equals(restaurant.getName())) {
				int remaining = restaurantList.get(i).getQuantity() - quantity;
				if (remaining < 0) return mv;
				else {
//					System.out.println((Integer.valueOf(restaurant.getPrice().split("\\s+")[0])));
//					System.out.println(new Date());
					Order order = new Order();
					order.setName(restaurant.getName());
					order.setDishName(restaurant.getDishName());
					order.setPrice((Integer.valueOf(restaurant.getPrice().split(" ")[0])) * quantity);
					order.setQuantity(quantity);
					order.setDate(new Date());
					orderList.add(order);
					restaurantList.get(i).setQuantity(remaining);
					break;
				}
			}
		}
		
		mv.addObject("isInvalid", false);
		return mv;
	}
	
	@GetMapping("/history")
	public ModelAndView getOrderHistory() {
		ModelAndView mv = new ModelAndView();
		Collections.reverse(orderList);
		mv.addObject("orders", orderList);
		if (orderList.size() > 0) mv.addObject("isHistoryPresent", true);
		else mv.addObject("isHistoryPresent", false);
		mv.setViewName("orderHistory");
		return mv;
	}
	
	public void updateDataFromExcel(MultipartFile myFile) {
		
		XSSFWorkbook workbook;
		XSSFSheet worksheet = null;
		try {
			workbook = new XSSFWorkbook(myFile.getInputStream());
			worksheet = workbook.getSheetAt(0);
		    workbook.close();
		}
		catch(IOException ex) {
			System.out.println();
		}
	    restaurantList.clear();
	    for(int i = 1; i < worksheet.getPhysicalNumberOfRows(); i++) {
	    	Restaurant restaurant = new Restaurant();
	        XSSFRow row = worksheet.getRow(i);
	            
	        restaurant.setDishName(row.getCell(0).getStringCellValue());
	        restaurant.setQuantity((int)row.getCell(1).getNumericCellValue());
	        restaurant.setPrice(row.getCell(2).getStringCellValue());
	        restaurant.setName(row.getCell(3).getStringCellValue());
	        restaurantList.add(restaurant);   
	    }
	}
}
