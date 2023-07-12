package asset.management;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class AssetManagementSystem {

	public static void main(String[] args) {
		AssetManagementSystem assetManagement = new AssetManagementSystem();
		Scanner scanner = new Scanner(System.in);
		int choice = 0;
		int vendorId = 0;
		int employeeId = 0;
		double purchasePrice = 0;
		int assetId = 0; 
		int assignAssetId = 0;
		int assignEmployeeId = 0;
		Vendor vendor = new Vendor();
		Employee employee = new Employee();
		Asset asset = new Asset();
		while (true) {
			System.out.println("Asset Management");
			System.out.println("1. Add Vendor");
			System.out.println("2. Remove Vendor");
			System.out.println("3. Display Vendor Details");
			System.out.println("4. Add Employee");
			System.out.println("5. Remove Employee");
			System.out.println("6. Display Employee Details");
			System.out.println("7. Add Asset");
			System.out.println("8. Remove Asset");
			System.out.println("9. Display Asset Details");
			System.out.println("10. Assign the assets to employee");
			System.out.println("11. Exit");
			System.out.print("Enter your choice: ");
			
			try {
				choice = scanner.nextInt();
			}catch (InputMismatchException e) {
                scanner.nextLine(); // Clear the invalid input from the scanner
                System.out.println("Invalid choice. Please enter a valid number: "+e);
                continue; // Continue the loop to ask for input again
            }
			scanner.nextLine();
			switch (choice) {
			case 1:
				System.out.print("Vendor Name: ");
				String vendorName = scanner.nextLine();
				vendor.setVendorName(vendorName);
				System.out.print("Phone No: ");
				String phoneNo = scanner.nextLine();
				vendor.setPhoneNo(phoneNo);
				System.out.print("Email: ");
				String email = scanner.nextLine();
				vendor.setEmail(email);
				System.out.print("Contact Person: ");
				String contactPerson = scanner.nextLine();
				vendor.setContactPerson(contactPerson);
				System.out.print("Address: ");
				String address = scanner.nextLine();
				vendor.setAddress(address);
				System.out.print("GSTIN Number: ");
				String gstin = scanner.nextLine();
				vendor.setGstin(gstin);
				vendor.addVendor(vendor);
				break;
			case 2:
				System.out.print("Enter vendor Id to remove: ");
				try {
			        vendorId = scanner.nextInt();
			        vendor.removeVendor(vendorId);
			    } catch (InputMismatchException e) {
			        scanner.nextLine(); // Clear the invalid input from the scanner
			        System.out.println("Invalid vendor Id. Please enter a valid number: "+e);
			    }
				break;
			case 3:
				vendor.displayVendorDetails();
				break;
			case 4:
//				System.out.println(scanner.nextLine());
				System.out.print("Enter employee name: ");
				String name = scanner.nextLine();
				employee.setName(name);
				System.out.print("Enter department: ");
				String department = scanner.nextLine();
				employee.setDepartment(department);
				System.out.print("Enter phone number: ");
				String phone = scanner.nextLine();
				employee.setPhone(phone);
				System.out.print("Enter email address: ");
				String employee_email = scanner.nextLine();
				employee.setEmail(employee_email);
				employee.addEmployee(employee);
				break;
			case 5:
				System.out.print("Enter employee ID to remove: ");
				try {
					employeeId = scanner.nextInt();
					employee.removeEmployee(employeeId);
				}catch(InputMismatchException e) {
					 scanner.nextLine(); // Clear the invalid input from the scanner
				     System.out.println("Invalid Employee Id. Please enter a valid number: "+e);
				}
				break;
			case 6:
				employee.displayEmployees();
				break;
			case 7:
				System.out.print("Enter Asset category: "); // Hardware, Software, Networking, etc...
				String category = scanner.nextLine();
				asset.setCategory(category);
				System.out.print("Enter Asset type: "); // Laptop, Mobile, Server, etc...
				String type = scanner.nextLine();
				asset.setType(type);
				System.out.print("Enter Asset name: ");
				String asset_name = scanner.nextLine();
				asset.setName(asset_name);
				System.out.print("Enter model number: ");
				String modelNumber = scanner.nextLine();
				asset.setModelNumber(modelNumber);
				System.out.print("Enter serial number: ");
				String serialNumber = scanner.nextLine();
				asset.setSerialNumber(serialNumber);
				System.out.print("Enter purchase price: ");
				try {
					purchasePrice = scanner.nextDouble();
					scanner.nextLine();
					asset.setPurchasePrice(purchasePrice);
				}catch(InputMismatchException e) {
					scanner.nextLine(); // clear the invalid input from the scanner
					System.out.println("Invalid Purchase Price. Please enter a valid price: "+e);
				}
				System.out.print("Enter purchase date: ");
				String purchaseDate = scanner.nextLine();
				asset.setPurchaseDate(purchaseDate);
				System.out.print("Enter warranty date: ");
				String warrantyDate = scanner.nextLine();
				asset.setWarrantyDate(warrantyDate);
				System.out.println("Enter purchase type: "); // Owned, rented, leased
				String purchaseType = scanner.nextLine();
				asset.setPurchaseType(purchaseType);
				System.out.print("Enter vendor Id: ");
				try {
					vendorId = scanner.nextInt();
					scanner.nextLine();
					asset.setVendorDetails(vendorId);
				}catch(InputMismatchException e) {
					scanner.nextLine(); // clear the invalid input from the scanner
					System.out.println("Invalid Vendor Id. Please Enter a valid number: "+e);
				}
				asset.addAsset(asset);
				break;
			case 8:
				System.out.print("Enter Asset ID to remove: ");
				try {
					assetId = scanner.nextInt();
					asset.removeAsset(assetId);
				}catch(InputMismatchException e) {
					scanner.nextLine(); // clear the invalid input from the scanner
					System.out.println("Invalid Asset Id. Please enter valid number: "+e);
				}
				scanner.nextLine(); // Consume newline character
				break;
			case 9:
				asset.displayAssets();
				break;
			case 10:
			    System.out.print("Enter Asset ID to assign: ");
			    try {
			    	assignAssetId = scanner.nextInt();
			    	asset.setAssignAssetId(assignAssetId);
			    	scanner.nextLine();
			    }catch(InputMismatchException e) {
			    	scanner.nextLine(); // clear the invalid input from the scanner
					System.out.println("Invalid Asset Id. Please enter valid number: "+e);
			    }
			    System.out.print("Enter Employee ID to assign: ");
			    try {
			    	assignEmployeeId = scanner.nextInt();
			    	asset.setAssignEmployeeId(assignEmployeeId);
			    	scanner.nextLine();
			    }catch(InputMismatchException e) {
			    	scanner.nextLine(); // clear the invalid input from the scanner
					System.out.println("Invalid Empliyee Id. Please enter valid number: "+e);
			    }
			    asset.assignAssetToEmployee(assignAssetId, assignEmployeeId);
			    break;
			case 11:
				System.out.println("Exiting assetManagement. Goodbye!");
				System.exit(0);
				break;
			default:
				System.out.println("Invalid choice. Please try again.");
			}
			System.out.println();
		}
	}
}

class Vendor {
	private int id;
	private String vendorName;
	private String phoneNo;
	private String email;
	private String contactPerson;
	private String address;
	private String gstin;
	HashMap<Integer, Vendor> vendorDetails;
	int nextVendorId;

	public Vendor(int id, String vendorName, String phoneNo, String email, String contactPerson, String address,
			String gstin) {
		this.id = id;
		this.vendorName = vendorName;
		this.phoneNo = phoneNo;
		this.email = email;
		this.contactPerson = contactPerson;
		this.address = address;
		this.gstin = gstin;
	}
	
	public Vendor() {
		vendorDetails = new HashMap<>();
		nextVendorId = 1;
		
		// Initially adding vendor details
		Vendor vendor1 = new Vendor(nextVendorId, "Vendor 1", "8676542308", "vendor1@example.com", "Admin", "Address 1", "GSTIN1");
	    vendorDetails.put(nextVendorId, vendor1);
	    nextVendorId++;
	    Vendor vendor2 = new Vendor(nextVendorId, "Vendor 2", "9876543210", "vendor2@example.com", "John", "Address 2", "GSTIN2");
	    vendorDetails.put(nextVendorId, vendor2);
	    nextVendorId++;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getVendorName() {
		return vendorName;
	}
	
	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}
	
	public String getPhoneNo() {
		return phoneNo;
	}
	
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getContactPerson() {
		return contactPerson;
	}
	
	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}
	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getGstin() {
		return gstin;
	}

	public void setGstin(String gstin) {
		this.gstin = gstin;
	}
	
	public HashMap<Integer, Vendor> getVendor() {
		return vendorDetails;
	}
	
	public void addVendor(Vendor vendor) {
		try {
			vendor.setId(nextVendorId);
			vendorDetails.put(nextVendorId, vendor);
			nextVendorId++;
			System.out.println("Vendor details added successfully. Vendor ID: " + vendor.getId());
		}catch(Exception e) {
			System.out.println("An error occurred while adding the vendor: " + e.getMessage());
		}
	}

	public void removeVendor(int vendorId) {
		try {
			if (vendorDetails.containsKey(vendorId)) {
				vendorDetails.remove(vendorId);
				System.out.println("Vendor details removed successfully.");
			} else {
				throw new VendorNotFoundException("Vendor " + vendorId + " not found.");
			}
		}catch(VendorNotFoundException e) {
			 System.out.println("An error occurred while removig the vendor: " + e.getMessage());
		}
	}

	public void displayVendorDetails() {
		try {
			if (vendorDetails.isEmpty()) {
				throw new VendorNotFoundException("No vendor details available.");
			} else {
				System.out.println("Vendor Details:");
				for (Vendor vendor : vendorDetails.values()) {
					System.out.println("Vendor ID: " + vendor.getId());
	                System.out.println("Vendor Name: " + vendor.getVendorName());
	                System.out.println("Phone No: " + vendor.getPhoneNo());
	                System.out.println("Email: " + vendor.getEmail());
	                System.out.println("Contact Person: " + vendor.getContactPerson());
	                System.out.println("Address: " + vendor.getAddress());
	                System.out.println("GSTIN Number: " + vendor.getGstin());
	                System.out.println();
				}
			}
		}catch(VendorNotFoundException e) {
			 System.out.println("An error occurred while displaying the vendor: " + e.getMessage());
		}
	}
}

class Employee {
	private int id;
	private String name;
	private String department;
	private String phone;
	private String email;
	private boolean isActive;
	private HashMap<Integer, Employee> employeeDetails;
	private int nextEmployeeId;
	
	public Employee() {
		employeeDetails = new HashMap<>();
		nextEmployeeId = 1;
		
		//Initially adding employee details
		Employee employee1 = new Employee(nextEmployeeId, "Employee 1", "HR", "8776679909", "employee1@gmail.com");
		employeeDetails.put(nextEmployeeId, employee1);
		nextEmployeeId++;
		Employee employee2 = new Employee(nextEmployeeId, "Employee 2", "Development", "9863455266", "employee2@gmail.com");
		employeeDetails.put(nextEmployeeId, employee2);
		nextEmployeeId++;
	}

	public Employee(int id, String name, String department, String phone, String email) {
		this.id = id;
		this.name = name;
		this.department = department;
		this.phone = phone;
		this.email = email;
		this.isActive = true;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	
	public HashMap<Integer, Employee> getEmployee() {
		return employeeDetails;
	}
	
	public void addEmployee(Employee employee) {
		try {
			employee.setId(nextEmployeeId);
//			Employee employee = new Employee(nextEmployeeId, name, department, phone, email);
			employeeDetails.put(nextEmployeeId, employee);
			nextEmployeeId++;
			System.out.println("Employee added successfully. Employee ID: " + employee.getId());
		}catch(Exception e) {
			 System.out.println("An error occurred while adding the employee: " + e.getMessage());
		}
	}

	public void removeEmployee(int employeeId) {
		try {
			if (employeeDetails.containsKey(employeeId)) {
				employeeDetails.remove(employeeId);
				System.out.println("Employee with ID " + employeeId + " has been removed.");
			} else {
				throw new EmployeeNotFoundException("Employee with ID " + employeeId + " not found.");
			}
		}catch(EmployeeNotFoundException e) {
			System.out.println("An error occurred while removing the employee: " + e.getMessage());
		}
	}

	public void displayEmployees() {
		try {
			if (employeeDetails.isEmpty()) {
				throw new EmployeeNotFoundException("Employee database is empty.");
			} else {
				System.out.println("Employee Database:");
				for (Employee employee : employeeDetails.values()) {
					System.out.println("Employee ID: " + employee.getId());
	                System.out.println("Name: " + employee.getName());
	                System.out.println("Department: " + employee.getDepartment());
	                System.out.println("Phone: " + employee.getPhone());
	                System.out.println("Email: " + employee.getEmail());
	                System.out.println("Active: " + employee.isActive());
	                System.out.println();
				}
			}
		}catch(EmployeeNotFoundException e) {
			System.out.println("An error occurred while displaying the employee details: " + e.getMessage());
		}
	}
}

class Asset {
	private int id;
	private String category;
	private String type;
	private String name;
	private String modelNumber;
	private String serialNumber;
	private double purchasePrice;
	private String purchaseDate;
	private String warrantyDate;
	private String purchaseType;
	private int vendorId;
	private String status;
	private Employee employeeId;
	private HashMap<Integer, Asset> assetDetails;
	private int nextAssetId;
	private int assignAssetId;
	private int assignEmployeeId;
	
	public Asset() {
		assetDetails = new HashMap<>();
		nextAssetId = 1;
		
		//Initially adding asset details
		Asset asset1 = new Asset(nextAssetId, "Hardware", "Laptop", "Asset 1", "15735", "37356", 100000, "10-05-2020", "08-06-2022", "Rental", 1);
		assetDetails.put(nextAssetId, asset1);
		nextAssetId++;
		Asset asset2 = new Asset(nextAssetId, "Hardware", "mobile", "Asset 2", "54543", "9875", 15000, "24-02-2021", "02-07-2025", "Owned", 2);
		assetDetails.put(nextAssetId, asset2);
		nextAssetId++;
	}

	public Asset(int id, String category, String type, String name, String modelNumber, String serialNumber,
			double purchasePrice, String purchaseDate, String warrantyDate, String purchaseType, int vendorId) {
		this.id = id;
		this.category = category;
		this.type = type;
		this.name = name;
		this.modelNumber = modelNumber;
		this.serialNumber = serialNumber;
		this.purchasePrice = purchasePrice;
		this.purchaseDate = purchaseDate;
		this.warrantyDate = warrantyDate;
		this.purchaseType = purchaseType;
		this.vendorId = vendorId;
		this.status = "Not assinged";
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getModelNumber() {
		return modelNumber;
	}

	public void setModelNumber(String modelNumber) {
		this.modelNumber = modelNumber;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public double getPurchasePrice() {
		return purchasePrice;
	}

	public void setPurchasePrice(double purchasePrice) {
		this.purchasePrice = purchasePrice;
	}

	public String getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(String purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public String getWarrantyDate() {
		return warrantyDate;
	}

	public void setWarrantyDate(String warrantyDate) {
		this.warrantyDate = warrantyDate;
	}

	public String getPurchaseType() {
		return purchaseType;
	}

	public void setPurchaseType(String purchaseType) {
		this.purchaseType = purchaseType;
	}

	public int getVendorDetails() {
		return vendorId;
	}

	public void setVendorDetails(int vendorId) {
		this.vendorId = vendorId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Employee getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Employee employeeId) {
		this.employeeId = employeeId;
	}
	
	public void setAssignEmployeeId(int assignEmployeeId) {
		this.assignEmployeeId = assignEmployeeId;
	}

	public void setAssignAssetId(int assignAssetId) {
		this.assignAssetId = assignAssetId;
	}
	
	public void addAsset(Asset asset) {
		try {
			Vendor vendor = new Vendor();
            if (vendor.vendorDetails.containsKey(vendorId)) {
            	System.out.println(vendor.vendorDetails.get(vendorId));
                assetDetails.put(nextAssetId, asset);
                nextAssetId++;
                System.out.println("Asset added successfully. Asset ID: " + asset.getId());
            } else {
                throw new VendorNotFoundException("Vendor not found");
            }
        } catch (VendorNotFoundException e) {
            System.out.println("An error occurred while adding the asset: " + e.getMessage());
        }
	}

	public void removeAsset(int assetId) {
		try {
			if (assetDetails.containsKey(assetId)) {
				assetDetails.remove(assetId);
				System.out.println("Asset ID " + assetId + " has been removed.");
			} else {
				throw new AssetNotFoundException("Asset ID " + assetId + " not found.");
			}
		}catch(AssetNotFoundException e) {
			 System.out.println("An error occurred while removing the asset: " + e.getMessage());
		}
	}
	
	public void displayAssets() {
		try {
			 if (assetDetails.isEmpty()) {
				 throw new AssetNotFoundException("Asset database is empty.");
			 }
			 else {
				 System.out.println("Asset Database:");
			     for (Asset asset : assetDetails.values()) {
			    	 System.out.println("Asset ID: " + asset.getId());
		                System.out.println("Category: " + asset.getCategory());
		                System.out.println("Type: " + asset.getType());
		                System.out.println("Name: " + asset.getName());
		                System.out.println("Model Number: " + asset.getModelNumber());
		                System.out.println("Serial Number: " + asset.getSerialNumber());
		                System.out.println("Purchase Price: " + asset.getPurchasePrice());
		                System.out.println("Purchase Date: " + asset.getPurchaseDate());
		                System.out.println("Warranty Date: " + asset.getWarrantyDate());
		                System.out.println("Purchase Type: " + asset.getPurchaseType());
		                Vendor v = new Vendor();
		                Vendor vendorDetails = v.getVendor().get(asset.getVendorDetails());
		                System.out.println("Vendor Name: " + vendorDetails.getVendorName());
		                if (asset.getEmployeeId() != null) {
		                    System.out.println("Assigned to: " + asset.getEmployeeId().getName());
		                } else {
		                    System.out.println("Not assigned to any employee");
		                }
		                System.out.println();
			      }
			  }
		}catch(AssetNotFoundException e) {
			System.out.println("An error occurred while displaying the asset details: " + e.getMessage());
		}
	}
	public void assignAssetToEmployee(int assetId, int employeeId) {
	    try {
            if (assetDetails.containsKey(this.assignAssetId)) {
                Asset asset = assetDetails.get(this.assignAssetId);
                Employee employee = new Employee();
                HashMap<Integer, Employee> employeeDetails = employee.getEmployee();
                if (employeeDetails.containsKey(this.assignEmployeeId)) {
                    Employee emp = employeeDetails.get(this.assignEmployeeId);
                    asset.setEmployeeId(emp);
                    System.out.println("Asset ID " + assetId + " assigned to employee ID " + employeeId);
                } else {
                    throw new EmployeeNotFoundException("Employee ID not found");
                }
            } else {
                throw new AssetNotFoundException("Asset ID not found");
            }
        } catch (AssetNotFoundException e) {
            System.out.println("An error occurred while assigning the asset: " + e.getMessage());
        } catch (EmployeeNotFoundException e) {
        	System.out.println("An error occurred while assigning the asset: " + e.getMessage());
        } catch (Exception e) {
        	System.out.println("An error occurred while assigning the asset: " + e.getMessage());
        }
	}
}
class VendorNotFoundException extends Exception {
    public VendorNotFoundException(String message) {
        super(message);
    }
}

class AssetNotFoundException extends Exception {
    public AssetNotFoundException(String message) {
        super(message);
    }
}

class EmployeeNotFoundException extends Exception {
    public EmployeeNotFoundException(String message) {
        super(message);
    }
}