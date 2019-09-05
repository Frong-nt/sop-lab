package com.example.vehicleshop;




import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@RestController
@EnableAutoConfiguration
//@RequestMapping(value = "hello")
public class VehicleShopApplication {
	
	ArrayList<Car> cars = new ArrayList<Car>();
	
    public static void main(String[] args) {
        SpringApplication.run(VehicleShopApplication.class, args);
    }
    
    
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResponseEntity<Car> create(@RequestBody Car car) {
    		this.cars.add(car);
    return new ResponseEntity<Car>(car, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/get/{id}")
    public ResponseEntity<Car> get(@PathVariable("id") int id) {
    return new ResponseEntity<Car>(this.cars.get(id), HttpStatus.OK);
    }
    
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public ResponseEntity<Car> update(@PathVariable("id")int id, @RequestBody Car car) {
    	this.cars.get(id).setColor(car.color);
    	this.cars.get(id).setDisplacement(car.displacement);
    	this.cars.get(id).setSpeed(car.speed);
    	this.cars.get(id).setSunroof(car.hasSunroof());
    	this.cars.get(id).setType(car.getType());
    
    return new ResponseEntity<Car>(car, HttpStatus.OK);
    }
    
    
    @RequestMapping(value = "/delete/{id}")
    public ResponseEntity<List<Car>> delete(@PathVariable("id") int id) {
    	this.cars.remove(id);
    return new ResponseEntity<List<Car>>(this.cars, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/list")
    public ResponseEntity<List<Car>> getAll() {
    return new ResponseEntity<List<Car>>(this.cars, HttpStatus.OK);
    }
    
//    @RequestMapping(value="/{firstName}/{lastName}",
//    		method = RequestMethod.GET)
//    public String hello(@PathVariable("firstName") String firstName,
//    		@PathVariable("lastName") String lastName) {
//    	return String.format("{\"message\":\"Hello %s %s\"}", firstName,lastName);
//
//    }
    
//    @RequestMapping(value = "/", method = RequestMethod.POST)
//    public String hello(@RequestBody Object object) {
//    return String.format("{\"payload\":\"%s\"}", object);
//    }

}
