package com.springbootbackcar.controller;

import com.springbootbackcar.domain.Car;
import com.springbootbackcar.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.List;

@Controller
public class CarController {

    @Autowired
    private CarService carService;

    @RequestMapping(value = "/car_list",method = RequestMethod.GET)
    public ModelAndView getCars(@RequestParam(value = "name",required = false)String name,
                                @RequestParam(value = "beginDate",required = false)
                                        @DateTimeFormat(pattern = "yyyy-MM-dd") Date beginDate,
                                @RequestParam(value = "endDate",required = false)
                                    @DateTimeFormat(pattern = "yyyy-MM-dd")Date endDate){
        ModelAndView mv = new ModelAndView("carlist");
        System.out.println(name+" "+beginDate+" "+endDate);
        List<Car> cars = carService.find(name,beginDate,endDate);
        mv.addObject("cars",cars);
        return mv;
    }

    @RequestMapping(value = "/removeCar/{id}",method = RequestMethod.GET)
    public String removeCar(@PathVariable(value = "id",required = true)Integer id){
        Integer count = 0;
        count = carService.removeCar(id);

        return "redirect:/car_list";
    }

    @RequestMapping(value = "/modifyCar/{id}",method = RequestMethod.GET)
    public ModelAndView findById(@PathVariable(value = "id",required = false)Integer id){
        ModelAndView mv = new ModelAndView("caredit");
        Car car = carService.findById(id);
        System.out.println(car);
        mv.addObject("car",car);

        return mv;
    }

    @RequestMapping(value = "/saveCar",method = RequestMethod.POST)
    public String save(Car car){
        System.out.println("savecar:"+car);
        Integer count = 0;
        if(car.getId()!=null && car.getId()>0){
            count = carService.modifyCar(car);
        }else{
            count = carService.addCar(car);
        }
        return "redirect:/car_list";
    }

    @RequestMapping(value = "/carEdit",method = RequestMethod.GET)
    public String carEdit(){
        return "caredit";
    }
}
