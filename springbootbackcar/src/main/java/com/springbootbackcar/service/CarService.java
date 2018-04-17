package com.springbootbackcar.service;

import com.springbootbackcar.domain.Car;
import com.springbootbackcar.mapper.CarMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class CarService {

    @Autowired
    private CarMapper carMapper;

    /**
     * 查询所有 | 条件查询
     * @param name
     * @param beginDate
     * @param endDate
     * @return
     */
    public List<Car> find(String name,Date beginDate,Date endDate){
        return carMapper.findByParam(name,beginDate,endDate);
    }

    public Car findById(Integer id){
        return carMapper.findById(id);
    }

    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public Integer addCar(Car car){
        return carMapper.addCar(car);
    }

    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public Integer modifyCar(Car car){
        return carMapper.modifyCar(car);
    }

    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public Integer removeCar(Integer id){
        return carMapper.removeCar(id);
    }
}
