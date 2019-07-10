package com.techchefs.hibernateapp.aws;

import org.hibernate.Transaction;

import com.techchefs.hibernateapp.cache.NewEmployeeInfoBean;

public class HibernateProgrameForAws {

	public static void main(String[] args) {
		
		Transaction txn = null;
		NewEmployeeInfoBean bean =new NewEmployeeInfoBean();
		bean.setId(16);
		bean.setName("AMT");
	}

}
