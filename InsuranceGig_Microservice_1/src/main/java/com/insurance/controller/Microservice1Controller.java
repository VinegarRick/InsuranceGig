package com.insurance.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.insurance.domain.Application;
import com.insurance.domain.Claim;
import com.insurance.domain.ClaimImage;
import com.insurance.domain.DriversLicense;
import com.insurance.domain.Payment;
import com.insurance.domain.PaymentInfo;
import com.insurance.domain.Plan;
import com.insurance.domain.PlanTemplate;
import com.insurance.domain.Policy;
import com.insurance.domain.Vehicle;
import com.insurance.service.ApplicationService;
import com.insurance.service.ClaimImageService;
import com.insurance.service.ClaimService;
import com.insurance.service.DriversLicenseService;
import com.insurance.service.PaymentInfoService;
import com.insurance.service.PaymentService;
import com.insurance.service.PlanService;
import com.insurance.service.PlanTemplateService;
import com.insurance.service.PolicyService;
import com.insurance.service.VehicleService;
import com.insurance.service.VehicleTemplateService;

@RestController
public class Microservice1Controller {

	@Autowired ApplicationService applicationService;
	@Autowired PaymentInfoService paymentInfoService;
	@Autowired DriversLicenseService driversLicenseService;
	@Autowired VehicleService vehicleService;
	@Autowired VehicleTemplateService vehicleTemplateService;
	@Autowired PlanTemplateService planTemplateService;
	@Autowired PlanService planService;
	@Autowired PolicyService policyService;
	@Autowired PaymentService paymentService;
	@Autowired ClaimService claimService;
	@Autowired ClaimImageService claimImageService;
	
	@PostMapping(value="/saveApplication")
	public Application saveApplication(@RequestBody Application application) {
		System.out.println("saving application...");
		
		Application existingApplication = applicationService.findApplicationByUsername(application.getUsername());
		if (existingApplication != null) {
			if (existingApplication.getStatus().equals("pending") || existingApplication.getStatus().equals("approved")) {
				return existingApplication;
			} else {
				existingApplication.setStatus("pending");
				existingApplication.setFirstName(application.getFirstName());
				existingApplication.setLastName(application.getLastName());
				existingApplication.setAddressLine(application.getAddressLine());
				existingApplication.setCity(application.getCity());
				existingApplication.setCounty(application.getCounty());
				existingApplication.setZipcode(application.getZipcode());
				existingApplication.setDateOfBirth(application.getDateOfBirth());
				existingApplication.setGender(application.getGender());
				existingApplication.setLicenseNo(application.getLicenseNo());
				existingApplication.setSsn(application.getSsn());
				existingApplication.setVin(application.getVin());
				existingApplication.setCarYear(application.getCarYear());
				existingApplication.setCarMake(application.getCarMake());
				existingApplication.setCarModel(application.getCarModel());
				existingApplication.setCarMileage(application.getCarMileage());
				existingApplication.setPlans(application.getPlans());
				
				return applicationService.save(existingApplication);
			}
		} else {
			return applicationService.save(application);
		}
	}
	
	@PostMapping(value="/savePaymentInfo")
	public PaymentInfo savePaymentInfo(@RequestBody PaymentInfo paymentInfo) {
		System.out.println("saving payment info...");
		
		return paymentInfoService.save(paymentInfo);
	}
	
    @PostMapping(value="/saveDriversLicense")
    public DriversLicense saveDriversLicense(@RequestParam("driversLicense") MultipartFile driversLicense, @RequestParam("licenseNumber") String licenseNumber, @RequestParam("expirationDate") String expirationDate, @RequestParam("username") String username) {
        System.out.println("in /saveDriversLicense of microservice");
    	
    	try {
            byte[] driversLicenseData = driversLicense.getBytes();
            DriversLicense driversLicenseEntity = new DriversLicense();
            driversLicenseEntity.setDriversLicense(driversLicenseData);
            driversLicenseEntity.setLicenseNumber(licenseNumber);
            
            LocalDate parsedExpirationDate = LocalDate.parse(expirationDate);
            
            driversLicenseEntity.setExpirationDate(parsedExpirationDate);
            driversLicenseEntity.setUsername(username);
            
            DriversLicense savedLicense = driversLicenseService.save(driversLicenseEntity);
            
            return savedLicense;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
	
    @GetMapping(value="/findDriversLicenseByUsername/{username}")
    public DriversLicense findDriversLicenseByUsername(@PathVariable String username) {
    	return driversLicenseService.findDriversLicenseByUsername(username);
    }
    
    @GetMapping(value="/findPaymentInfoByUsername/{username}")
    public PaymentInfo findPaymentInfoByUsername(@PathVariable String username) {
    	return paymentInfoService.findPaymentInfoByUsername(username);
    }
    
	@GetMapping(value="/findApplicationByUsername/{username}")
	public Application findApplicationByUsername(@PathVariable String username) {
		System.out.println("fetching application...");
		
		return applicationService.findApplicationByUsername(username);
	}
	
	@GetMapping(value="/findApplicationById/{applicationId}")
	public ResponseEntity<?> findApplicationById(@PathVariable Long applicationId) {
		System.out.println("fetching application...");
		
		Application existingApplication = applicationService.findApplicationById(applicationId);
		
		if (existingApplication != null) {
			return new ResponseEntity<>(existingApplication, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping(value="/findAllApplications")
	public List<Application> findAllApplications() {
		return applicationService.findAll();
	}
	
	@PostMapping(value="/updateApplicationStatus")
	public ResponseEntity<?> updateApplicationStatus(@RequestBody Map<String, String> payload) {
	    System.out.println("Received a request to update application status.");
	    System.out.println("Payload: " + payload.toString());

	    String applicationIdString = payload.get("applicationId");
	    String status = payload.get("status");

	    try {
	        Long applicationId = Long.parseLong(applicationIdString);

	        Application existingApplication = applicationService.findApplicationById(applicationId);
	        if (existingApplication != null) {
	            existingApplication.setStatus(status);
	            Application updatedApplication = applicationService.save(existingApplication);
	            return new ResponseEntity<>(updatedApplication, HttpStatus.OK);
	        }
	    } catch (NumberFormatException e) {
	        System.err.println("Error parsing applicationId: " + e.getMessage());
	    }

	    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@PostMapping(value="/saveVehicle")
	public ResponseEntity<?> updateVehicle(@RequestBody Vehicle vehicle) {
		Vehicle myVehicle = vehicleService.save(vehicle);
		
		if (myVehicle != null) {
			return new ResponseEntity<>(myVehicle, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping(value="/getCarMakes")
	public ResponseEntity<?> getCarMakes() {
		List<String> carMakes = vehicleTemplateService.getCarMakes();
		
		if (!carMakes.isEmpty()) {
			return new ResponseEntity<>(carMakes, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping(value="/getCarModelsByMake/{make}")
	public ResponseEntity<?> getCarModelsByMake(@PathVariable String make) {
		List<String> carModels = vehicleTemplateService.getCarModelsByMake(make);
		
		if (!carModels.isEmpty()) {
			return new ResponseEntity<>(carModels, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping(value="/savePolicy")
	public ResponseEntity<?> savePolicy(@RequestBody Map<String, String> payload) {
		System.out.println("in savePolicy of microservice controller");
		String username = payload.get("username");
		String plans = payload.get("plans");
		String dobString = payload.get("dob");
						
		Vehicle vehicle = vehicleService.findVehicleByUsername(username);
		double carValuation = calculateCarValuation(vehicle);
		
		int personAge = 18;
		try {
	        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	        Date dob = dateFormat.parse(dobString);
	
	        Calendar dobCalendar = Calendar.getInstance();
	        dobCalendar.setTime(dob);
	
	        Calendar currentCalendar = Calendar.getInstance();
	
	        personAge = currentCalendar.get(Calendar.YEAR) - dobCalendar.get(Calendar.YEAR);
		} catch (ParseException e) {
			System.out.println("Invalid date format: " + e.getMessage());
		}
				
		String[] coverages = plans.split(",\\s*");

		Policy policy = new Policy();
		policy.setUsername(username);
		policy.setStatus("inactive");
		policy.setVehicle(vehicle);
		policy.setTotalPremium(0.0);
		Policy savedPolicy = policyService.save(policy);
				
		List<Plan> plansList = new ArrayList<>();
		double premiumSum = 0.0;
		for (String coverage : coverages) {	
			Plan plan = new Plan();
			plan.setUsername(username);
			PlanTemplate planTemplate = planTemplateService.findPlanTemplateByName(coverage);
			plan.setName(planTemplate.getName());
			plan.setPlantemplate(planTemplate);
			plan.setPolicy(savedPolicy);
			plan.setNumClaims(0);
			
			double premiumCalculation = 0.0;
			
			if (coverage.equals("medical") || coverage.equals("roadside")) {
				premiumCalculation = planTemplate.getBasePremium();
			} else {
				premiumCalculation = planTemplate.getBasePremium() + (carValuation / 1000) + (30 - personAge);
			}
			
			premiumSum += premiumCalculation;
			plan.setPremium(premiumCalculation);
			
			Plan savedPlan = planService.save(plan);
			plansList.add(savedPlan);
		}
		savedPolicy.setPlans(plansList);
		savedPolicy.setTotalPremium(premiumSum);
				
		Policy retPolicy = policyService.save(savedPolicy);
						
		return new ResponseEntity<>(retPolicy, HttpStatus.OK);
	}
	
	double calculateCarValuation(Vehicle vehicle) {
		int carYear = Integer.parseInt(vehicle.getYear());
		int currYear = Year.now().getValue();
		int carMileage = vehicle.getMileage();
		int baseValuation = vehicleTemplateService.getBaseValuation(vehicle.getMake(), vehicle.getModel());
				
		double annualDepreciationRate = 15.0;
		double mileageDepreciationRate = 0.001;
		
		int carAge = currYear - carYear;
		double depreciatedValue = baseValuation;
        for (int i = 0; i < carAge; i++) {
            depreciatedValue *= (1 - annualDepreciationRate / 100);
        }
        
        double mileageDepreciation = carMileage * mileageDepreciationRate;
        double carValuation = depreciatedValue - mileageDepreciation;
        
        System.out.println("Car Valuation: " + carValuation);
        
        return carValuation;
	}
	
	@GetMapping(value="/findPolicyByUsername/{username}")
	public ResponseEntity<?> findPolicyByUsername(@PathVariable String username) {
		Policy policy = policyService.findPolicyByUsername(username);
		
		if (policy != null) {
			return new ResponseEntity<>(policy, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping(value="/savePayment")
	public ResponseEntity<?> savePayment(@RequestBody Payment payment) {
		System.out.println("saving payment...");
		Payment myPayment = paymentService.save(payment);
		
		if (myPayment != null) {			
			Policy policy = policyService.findPolicyByUsername(payment.getUsername());
			policy.setStatus("active");
			
			LocalDate endDate = policy.getEndDate();
			if (endDate == null) endDate = payment.getScheduledDate();
			
			LocalDate updatedDate = endDate.plusDays(30);
			policy.setEndDate(updatedDate);
			
			if (policy.getStartDate() == null) policy.setStartDate(payment.getScheduledDate());
			
			policyService.save(policy);
			
			return new ResponseEntity<>(myPayment, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping(value="/fileClaim")
	public ResponseEntity<?> fileClaim(@RequestParam("claimImages") MultipartFile[] claimImages, @RequestParam("accidentDate") String accidentDate, @RequestParam("accidentLocation") String accidentLocation, @RequestParam("repairPrice") double repairPrice, @RequestParam("description") String description, @RequestParam("username") String username) throws IOException {
		System.out.println("in fileClaim of microservice controller");
		
		LocalDate parsedAccidentDate = LocalDate.parse(accidentDate);
		
	    Claim claim = new Claim();
	    claim.setAccidentDate(parsedAccidentDate);
	    claim.setAccidentLocation(accidentLocation);
	    claim.setRepairPrice(repairPrice);
	    claim.setDescription(description);
	    claim.setStatus("pending"); 
	    claim.setImages(new ArrayList<>()); 
	    
	    for (MultipartFile claimImage : claimImages) {
	        ClaimImage image = new ClaimImage();
	        image.setFilename(claimImage.getOriginalFilename());
	        image.setData(claimImage.getBytes());
	        ClaimImage savedImage = claimImageService.save(image);
	        claim.getImages().add(savedImage);
	    }
	    
	    Vehicle vehicle = vehicleService.findVehicleByUsername(username);
	    claim.setVehicle(vehicle);
	    
	    Claim savedClaim = claimService.save(claim);
	    
	    if (savedClaim != null) {
	    	return new ResponseEntity<>(savedClaim, HttpStatus.OK);
	    } else {
	    	return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	}
	
	@GetMapping(value="/findAllClaims")
	public ResponseEntity<?> findAllClaims() {
		List<Claim> claims = claimService.findAll();
		
		if (!claims.isEmpty()) {
			return new ResponseEntity<>(claims, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping(value="/findClaimById/{id}")
	public ResponseEntity<?> findClaimById(@PathVariable Long id) {
		System.out.println("in findClaimById in microservice application");
		Claim claim = claimService.findClaimById(id);
		
		if (claim != null) {
			return new ResponseEntity<>(claim, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping(value="/updateClaimStatus")
	public ResponseEntity<?> updateClaimStatus(@RequestBody Map<String, String> payload) {
		System.out.println("in updateClaimStatus of microservice application");
		
		String claimIdString = payload.get("id");
		String status = payload.get("status");
		
	    try {
	        Long claimId = Long.parseLong(claimIdString);

	        Claim existingClaim = claimService.findClaimById(claimId);
	        if (existingClaim != null) {
	            existingClaim.setStatus(status);
	            Claim updatedClaim = claimService.save(existingClaim);
	            return new ResponseEntity<>(updatedClaim, HttpStatus.OK);
	        }
	    } catch (NumberFormatException e) {
	        System.err.println("Error parsing claimId: " + e.getMessage());
	    }

	    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
}

/*

	@PostMapping(value="/updateApplicationStatus")
	public ResponseEntity<?> updateApplicationStatus(@RequestBody Map<String, String> payload) {
	    System.out.println("Received a request to update application status.");
	    System.out.println("Payload: " + payload.toString());

	    String applicationIdString = payload.get("applicationId");
	    String status = payload.get("status");

	    try {
	        Long applicationId = Long.parseLong(applicationIdString);

	        Application existingApplication = applicationService.findApplicationById(applicationId);
	        if (existingApplication != null) {
	            existingApplication.setStatus(status);
	            Application updatedApplication = applicationService.save(existingApplication);
	            return new ResponseEntity<>(updatedApplication, HttpStatus.OK);
	        }
	    } catch (NumberFormatException e) {
	        System.err.println("Error parsing applicationId: " + e.getMessage());
	    }

	    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

*/