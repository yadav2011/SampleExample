package com.test.demo.Int;

import java.util.List;

import com.test.demo.bean.Customer;

public interface IZone {

	public void customerIdsByZone(List<Customer> custList);
	public void buildDurationByZone(List<Customer> custList);
	public void customerIdsListByZone(List<Customer> customerList);
}
