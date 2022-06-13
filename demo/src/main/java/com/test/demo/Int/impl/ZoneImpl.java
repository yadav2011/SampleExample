package com.test.demo.Int.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.test.demo.utils.AppUtils;
import com.test.demo.Int.IZone;
import com.test.demo.bean.Customer;

public class ZoneImpl implements IZone {

	@Override
	public void customerIdsByZone(List<Customer> customerList) {
		
		Map<String, Set<Long>> zoneMap = customerIdsMapByZone(customerList);
		if (AppUtils.IsMapEmptyOrNull(zoneMap)) {
			Set<String> zoneSet = zoneMap.keySet();
			for (String zone : zoneSet) {
				System.out.println("The number of unique customerId for each geozone " + zone + "is "
						+ (zoneMap.get(zone) != null ? zoneMap.get(zone).size() : 0));
			}
		}else {
			System.out.println("No customers available for zones");
		}
	
	}
	
	@Override
	public void customerIdsListByZone(List<Customer> customerList) {
		
		Map<String, Set<Long>> zoneMap = customerIdsMapByZone(customerList);
		if (AppUtils.IsMapEmptyOrNull(zoneMap)) {
			Set<String> zoneSet = zoneMap.keySet();
			for (String zone : zoneSet) {
				System.out.println("The number of unique customerId for each geozone " + zone + "is "+ zoneMap.get(zone));
			}
		}else {
			System.out.println("No customers available for zones");
		}
	
	}

	@Override
	public void buildDurationByZone(List<Customer> customerList) {
		HashMap<String, List<Long>> zoneMap = new HashMap<String, List<Long>>();
		for (Customer cust : customerList) {
			if (zoneMap.get(cust.getGeozone()) != null) {
				List<Long> customerSet = zoneMap.get(cust.getGeozone());
				customerSet.add(cust.getBuildduration());
				zoneMap.put(cust.getGeozone(), customerSet);
			} else {
				List<Long> customerSet = new ArrayList<Long>();

				customerSet.add(cust.getBuildduration());
				zoneMap.put(cust.getGeozone(), customerSet);
			}
		}
		
		if(AppUtils.IsMapEmptyOrNull(zoneMap)) {
			Set<String> zone = zoneMap.keySet();
			for (String geozone : zone) {
				System.out.println("The average buildduration for each geozone " + geozone + " is "
						+ (zoneMap.get(geozone).stream().mapToLong((x) -> (Long)x).summaryStatistics().getAverage()));
			}
		} else {
			System.out.println("No buildduration available for zones");
		}
	}

	protected Map<String, Set<Long>> customerIdsMapByZone(List<Customer> customerList) {

		HashMap<String, Set<Long>> zoneMap = new HashMap<String, Set<Long>>();
		for (Customer cust : customerList) {
			if (zoneMap.get(cust.getGeozone()) != null) {
				Set<Long> customerSet = zoneMap.get(cust.getGeozone());
				customerSet.add(cust.getCustomerId());
				zoneMap.put(cust.getGeozone(), customerSet);
			} else {
				Set<Long> customerSet = new HashSet<Long>();

				customerSet.add(cust.getCustomerId());
				zoneMap.put(cust.getGeozone(), customerSet);
			}
		}
		return zoneMap;
	}

}
