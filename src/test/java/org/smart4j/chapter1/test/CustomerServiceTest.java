package org.smart4j.chapter1.test;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.smart4j.chapter1.helper.DatabaseHelper;
import org.smart4j.chapter1.model.Customer;
import org.smart4j.chapter1.service.CustomerService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lomoye on 2017/5/12.
 * ^_^
 */
public class CustomerServiceTest {
    private final CustomerService customerService;

    public CustomerServiceTest() {
        customerService = new CustomerService();
    }


    @Before
    public void init() {
        DatabaseHelper.executeSqlFile("sql/customer.sql");
    }

    /**
     * 获取客户列表
     */
    @Test
    public void getCustomerListTest() {
        List<Customer> customers = customerService.getCustomerList();
        Assert.assertEquals(2, customers.size());
    }

    /**
     * 获取客户
     */
    @Test
    public void getCustomerTest() {
        Long id = 1L;
        Customer customer = customerService.getCustomer(id);
        Assert.assertNotNull(customer);
    }

    /**
     * 创建客户
     */
    @Test
    public void createCustomerTest() {
        Map<String, Object> fieldMap = new HashMap<>();
        fieldMap.put("name", "customer100");
        fieldMap.put("contact", "John");
        fieldMap.put("telephone", "18812342345");

        boolean result = customerService.createCustomer(fieldMap);
        Assert.assertTrue(result);
    }

    /**
     * 更新客户
     */
    @Test
    public void updateCustomerTest() {
        Long id = 1L;
        Map<String, Object> fieldMap = new HashMap<>();
        fieldMap.put("contact", "Eric");

        boolean result = customerService.updateCustomer(id, fieldMap);
        Assert.assertTrue(result);
    }

    /**
     * 删除客户
     */
    @Test
    public void deleteCustomerTest() {
        Long id = 1L;

        boolean result = customerService.deleteCustomer(id);
        Assert.assertTrue(result);
    }
}
