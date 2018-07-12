package com.test.invoice.adapter;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.test.inv.adapter.util.SignatureUtil;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AdapterApplicationTests {

	protected final Logger logger = LoggerFactory.getLogger(getClass());
	
	@Test
	public void contextLoads() {
		System.out.println("****************************************************");
	}

}
