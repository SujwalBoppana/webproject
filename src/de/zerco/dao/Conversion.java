package de.zerco.dao;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Conversion {
	

	public static String formatter(String nextAuctionDate, String nextAuctionTime) {
		if (Utility.isBlankWithVarArguments(nextAuctionDate, nextAuctionTime)) return null;
		LocalDateTime date = null;
		LocalTime time = null;
		try {
			 date = LocalDateTime.parse(nextAuctionDate);
			 time = LocalTime.parse(nextAuctionTime);
		} catch (Exception e) {
			e.printStackTrace();
		}
		DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		return date.with(time).format(timeFormat);
	}

	public static void main(String[] args) {
		String nextAuctionDate = "2023-01-20T00:00:00";
		String nextAuctionTime = "15:50";
		System.out.println(formatter(nextAuctionDate, nextAuctionTime));
	}
}
