package com.springbootbackcar.mapper;

import com.springbootbackcar.domain.Car;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface CarMapper {

    List<Car> findByParam(@Param("name")String name,
                      @Param("beginDate")Date beginDate,
                      @Param("endDate")Date endDate);

    @Select("select id,name,price,create_date createDate from car where id=#{id}")
    Car findById(Integer id);

    @Insert("insert into car (name,price,create_date) values (#{name},#{price},#{createDate})")
    Integer addCar(Car car);

    @Update("update car set name=#{name},price=#{price},create_date=#{createDate} where id=#{id}")
    Integer modifyCar(Car car);

    @Delete("delete from car where id=#{id}")
    Integer removeCar(Integer id);
}
