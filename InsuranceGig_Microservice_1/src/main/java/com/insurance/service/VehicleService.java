package com.insurance.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insurance.domain.Vehicle;
import com.insurance.repository.VehicleRepository;

@Service
public class VehicleService {

	@Autowired VehicleRepository vehicleRepository;
	
	public List<Vehicle> findAll() {
		return vehicleRepository.findAll();
	}

	public Vehicle save(Vehicle v) {
		Vehicle vehicle = vehicleRepository.save(v);
		return vehicle;
	}

	public Vehicle findVehicleById(long vehicleId) {
		Optional<Vehicle> vehicle = vehicleRepository.findById(vehicleId);
		if(vehicle.isPresent()) {
			return vehicle.get();
		} else {
			return null;
		}
	}

	public Vehicle findVehicleByUsername(String username) {
		Vehicle vehicle = vehicleRepository.findByUsername(username);
		
		return vehicle;
	}
	
	public void deleteVehicleById(long vehicleId) {
		vehicleRepository.deleteById(vehicleId);
		
	}
}
