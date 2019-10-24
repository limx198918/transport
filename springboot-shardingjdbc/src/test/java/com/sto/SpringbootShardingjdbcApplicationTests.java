package com.sto;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.sto.dao.OrderDao;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootShardingjdbcApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Autowired
    private OrderDao orderDao;
	
	@Test
    public void insert() throws Exception {
        for(int i=0; i<10; i++) {
        	orderDao.insertOrder("orderno:" + i, 1L);
        }
    }
	
	
	@Test
    public void query() throws Exception {
        List<Map> orders = orderDao.queryOrder(394109039279079425L,1L);
        System.out.println(orders);
    }
	
	
	@Test
    public void queryList() throws Exception {
		List<Long> ids = new ArrayList<Long>();
		ids.add(394109039279079425L);
		ids.add(394109040264740864L);
        List<Map> orders = orderDao.queryList(ids,1L);
        System.out.println(orders);
    }
}
