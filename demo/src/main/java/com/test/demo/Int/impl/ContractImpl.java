package com.test.demo.Int.impl;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.test.demo.utils.AppUtils;
import com.test.demo.Int.IContract;
import com.test.demo.bean.Customer;

public class ContractImpl implements IContract{

	@Override
	public void customerIdsByContractId(List<Customer> customerList) {
		
		HashMap<Long, Set<Long>> contractIdsMap = new HashMap<Long, Set<Long>>();
		for (Customer cust : customerList) {
			if (contractIdsMap.get(cust.getContractId()) != null) {
				Set <Long>customerSet = contractIdsMap.get(cust.getContractId());
				customerSet.add(cust.getCustomerId());
				contractIdsMap.put(cust.getContractId(), customerSet);
			} else {
				Set<Long> customerSet = new HashSet<Long>();
				customerSet.add(cust.getCustomerId());
				contractIdsMap.put(cust.getContractId(), customerSet);
			}
		}
		if(AppUtils.IsMapEmptyOrNull(contractIdsMap)) {
			Set<Long> contractSet = contractIdsMap.keySet();
			for (Long contractId : contractSet) {
				System.out.println("The number of unique customerId for each contractId " + contractId + "is "
						+ (contractIdsMap.get(contractId) != null ? contractIdsMap.get(contractId).size() : 0));
			}
		}else {
			System.out.println("No customers available for contracts");
		}
	}

}
