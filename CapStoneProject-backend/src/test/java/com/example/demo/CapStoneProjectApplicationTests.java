
package com.example.demo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.dbOperations.HibernateSpotDBOperation;
import com.model.SpotLight;

@SpringBootTest
class CapStoneProjectApplicationTests {

	@Test
	public void testCreateProduct() {
		Date startDate = parseDate("2020-08-10");
		Date endDate = parseDate("2020-08-12");
		
		SpotLight savedSL = new SpotLight(12, "Tractor", "Special offer for Tractors", "en", "US", "key1", false,
				"https://a/b", startDate, endDate);
		HibernateSpotDBOperation hsl = new HibernateSpotDBOperation();
		int response = hsl.insertSL(savedSL);
		Assertions.assertEquals(savedSL.getId(), response); 

	}

	public Date parseDate(String date) {
		try {
			return new SimpleDateFormat("yyyy-MM-dd").parse(date);
		} catch (ParseException e) {
			return null;
		}
	}
}
