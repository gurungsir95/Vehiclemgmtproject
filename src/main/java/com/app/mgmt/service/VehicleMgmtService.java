package com.app.mgmt.service;

import java.util.UUID;
import org.springframework.stereotype.Service;
import com.app.mgmt.exception.CustomException;
import com.app.vehicle.dto.CreateVehicleDto;
import com.app.vehicle.dto.VehicleResponseDto;
@Service
public class VehicleMgmtService {
 public VehicleResponseDto createVehicle(CreateVehicleDto createVehicleDto) {
  validateCreateVehicle(createVehicleDto);
  UUID uid = UUID.fromString(createVehicleDto.toString());
  VehicleResponseDto responseDto=new VehicleResponseDto();
  responseDto.setUid(uid);
  return responseDto;
 }
 
 private void validateCreateVehicle(CreateVehicleDto createVehicleDto) {
  String transmissionType=createVehicleDto.getTransmissionType();
  if( !(transmissionType!=null && (transmissionType.equals("AUTO")|| transmissionType.equals("MANUAL")))) {
   throw new CustomException("Please send transmissionType");
  }
 }
}
