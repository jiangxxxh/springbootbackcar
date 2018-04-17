package com.springbootbackcar;

import com.springbootbackcar.domain.Car;
import com.springbootbackcar.mapper.CarMapper;
import com.springbootbackcar.service.CarService;
import org.apache.catalina.core.ApplicationContext;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

    @Autowired
    private CarMapper carMapper;


    @Test
    public void findAll() {
        String name = "";
        Date beginDate = null;
        Date endDate = null;
        List<Car> cars = carMapper.findByParam(name,beginDate,endDate);
        for(Car c:cars){
            System.out.println(c);
        }
        System.out.println(32>>3);
    }

}
