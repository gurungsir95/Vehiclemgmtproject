package com.app.mgmt.controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.app.mgmt.service.VehicleMgmtService;
import com.app.vehicle.dto.CreateVehicleDto;
import com.app.vehicle.dto.VehicleResponseDto;

@RestController
@RequestMapping(path = "/vehicle-api")
public class VehicleMgmtController {
 
 VehicleMgmtService vehicleMgmtService;
 Logger logger = LoggerFactory.getLogger(VehicleMgmtController.class);
 @PostMapping(path="/v1/vehicles/vehicle")
 public  ResponseEntity<VehicleResponseDto> createVechicle(@RequestBody CreateVehicleDto createVehicleDto) throws Exception {
  logger.info("Request for createVehicle:"+createVehicleDto.toString());
  ResponseEntity<VehicleResponseDto> response=null;
  VehicleResponseDto vehicleResponseDto=null;
  vehicleResponseDto=vehicleMgmtService.createVehicle(createVehicleDto);
  response = new ResponseEntity<>(vehicleResponseDto, HttpStatus.OK);
  return response;
 }

}
