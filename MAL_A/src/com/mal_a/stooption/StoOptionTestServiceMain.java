package com.mal_a.stooption;

import org.apache.log4j.Logger;

public class StoOptionTestServiceMain {
	private final Logger LOG = Logger.getLogger(StoOptionTestServiceMain.class);
	
	private StoOptionService stoOptionService;
	private StoOptionVO stoOptionVO01;
	
	public StoOptionTestServiceMain() {
		stoOptionService = new StoOptionService();
		stoOptionVO01 = new StoOptionVO();
	}
	

	public static void main(String[] args) {
		StoOptionTestServiceMain testService = new StoOptionTestServiceMain();

	}

}