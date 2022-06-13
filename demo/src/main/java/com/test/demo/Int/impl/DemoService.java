package com.test.demo.Int.impl;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.test.demo.Int.IContract;
import com.test.demo.Int.IDemoService;
import com.test.demo.Int.IZone;
import com.test.demo.bean.Customer;
import com.test.demo.utils.AppUtils;

public class DemoService implements IDemoService {

	@Autowired
	private IZone getZone;
	@Autowired
	private IContract getContract;

	@Override
	public void runService() {

		List<Customer> customerList = null;
		boolean continueFlag = true;
		BufferedReader br = null;
		try {
		while (continueFlag) {
			System.out.println("Please enter data");
			System.out.println();
			br = new BufferedReader(new InputStreamReader(System.in));
			customerList = populateCustList(br);
			System.out.println(" ");

			getContract.customerIdsByContractId(customerList);
			getZone.customerIdsByZone(customerList);
			getZone.buildDurationByZone(customerList);
			getZone.customerIdsListByZone(customerList);

			continueFlag = false;
			System.out.print("Do you want  enter another set of data for report then please enter Yes otherwise No");
			br = new BufferedReader(new InputStreamReader(System.in));
			if (br.readLine().equalsIgnoreCase("Yes")) {
				continueFlag = true;
			}
		}
		}catch (Exception e) {
			System.out.println("Exception occured::"+e.getMessage());
		}

	}

	protected static List<Customer> populateCustList(BufferedReader br) throws Exception {

		List<Customer> customersList = new ArrayList<Customer>();
		String lines = null;
		while ((lines = br.readLine()) != null && lines.length() != 0) {
			if (lines != null && !lines.isEmpty()) {

				String rows[] = lines.split("\\n");
				if (rows != null && rows.length > 0) {
					for (int index = 0; index < rows.length; index++) {

						String row[] = rows[index].split(",");
						if (row != null) {
							Customer customer = new Customer();
							customer.setCustomerId(AppUtils.convertLong(row[0]));
							customer.setContractId(AppUtils.convertLong(row[1]));
							customer.setBuildduration(AppUtils.convertLong(row[5]));
							customer.setGeozone(row[2]);
							customer.setProjectcode(row[4]);
							customer.setTeamcode(row[3]);
							customersList.add(customer);
						}

					}

				}

			}
		}

		return customersList;
	}
}
