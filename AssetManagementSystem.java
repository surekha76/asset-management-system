package asset.management;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class AssetManagementSystem {
	private HashMap<Integer, Vendor> vendorDetails;
	private int nextVendorId;
	private HashMap<Integer, Employee> employeeDetails;
	private int nextEmployeeId;
	private HashMap<Integer, Asset> assetDetails;
	private int nextAssetId;

	public AssetManagementSystem() {
		// Initializing vendor hashMap
		vendorDetails = new HashMap<>();
		nextVendorId = 1;
		
		// Initially adding vendor details
		Vendor vendor1 = new Vendor(nextVendorId, "Vendor 1", "8676542308", "vendor1@example.com", "Admin", "Address 1", "GSTIN1");
	    vendorDetails.put(nextVendorId, vendor1);
	    nextVendorId++;
	    Vendor vendor2 = new Vendor(nextVendorId, "Vendor 2", "9876543210", "vendor2@example.com", "John", "Address 2", "GSTIN2");
	    vendorDetails.put(nextVendorId, vendor2);
	    nextVendorId++;
	    
	    // Initializing employee hashMap
		employeeDetails = new HashMap<>();
		nextEmployeeId = 1;
		assetDetails = new HashMap<>();
		nextAssetId = 1;
		
		//Initially adding employee details
		Employee employee1 = new Employee(nextEmployeeId, "Employee 1", "HR", "8776679909", "employee1@gmail.com");
		employeeDetails.put(nextEmployeeId, employee1);
		nextEmployeeId++;
		Employee employee2 = new Employee(nextEmployeeId, "Employee 2", "Development", "9863455266", "employee2@gmail.com");
		employeeDetails.put(nextEmployeeId, employee2);
		nextEmployeeId++;
		
		// Initializing asset hashMap
		assetDetails = new HashMap<>();
		nextAssetId = 1;
		
		//Initially adding asset details
		Asset asset1 = new Asset(nextAssetId, "Hardware", "Laptop", "Asset 1", "15735", "37356", 100000, "10-05-2020", "08-06-2022", "Rental", vendor1);
		assetDetails.put(nextAssetId, asset1);
		nextAssetId++;
		Asset asset2 = new Asset(nextAssetId, "Hardware", "mobile", "Asset 2", "54543", "9875", 15000, "24-02-2021", "02-07-2025", "Owned", vendor2);
		assetDetails.put(nextAssetId, asset2);
		nextAssetId++;
	}

	public void addVendor(String vendorName, String phoneNo, String email, String contactPerson, String address,
			String gstin) {
		try {
			Vendor vendor = new Vendor(nextVendorId, vendorName, phoneNo, email, contactPerson, address, gstin);
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
					System.out.println(vendor);
				}
			}
		}catch(VendorNotFoundException e) {
			 System.out.println("An error occurred while displaying the vendor: " + e.getMessage());
		}
	}

	public void addEmployee(String name, String department, String phone, String email) {
		try {
			Employee employee = new Employee(nextEmployeeId, name, department, phone, email);
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
					System.out.println(employee);
				}
			}
		}catch(EmployeeNotFoundException e) {
			System.out.println("An error occurred while displaying the employee details: " + e.getMessage());
		}
	}

	public void addAsset(String category, String type, String name, String modelNumber, String serialNumber,
			double purchasePrice, String purchaseDate, String warrantyDate, String purchaseType, int vendorId) {
		try {
            if (vendorDetails.containsKey(vendorId)) {
                Vendor vendor = vendorDetails.get(vendorId);
                Asset asset = new Asset(nextAssetId, category, type, name, modelNumber, serialNumber, purchasePrice,
                                        purchaseDate, warrantyDate, purchaseType, vendor);
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
			    	 System.out.println(asset);
			         if (asset.getEmployee() != null) {
			        	 System.out.println("Assigned to: " + asset.getEmployee().getName());
			         } else {
			             System.out.println("Not assigned to any employee");
			         }
			      }
			  }
		}catch(AssetNotFoundException e) {
			System.out.println("An error occurred while displaying the asset details: " + e.getMessage());
		}
	}
	
	public void assignAssetToEmployee(int assetId, int employeeId) {
	    try {
            if (assetDetails.containsKey(assetId)) {
                Asset asset = assetDetails.get(assetId);
                if (employeeDetails.containsKey(employeeId)) {
                    Employee employee = employeeDetails.get(employeeId);
                    asset.setEmployee(employee);
                    System.out.println("Asset ID " + assetId + " assigned to employee ID " + employeeId);
                } else {
                    throw new EmployeeNotFoundException("Employee ID not found");
                }
            } else {
                throw new AssetNotFoundException("Asset ID not found");
            }
        } catch (AssetNotFoundException | EmployeeNotFoundException e) {
            System.out.println("An error occurred while assigning the asset: " + e.getMessage());
        }
	}


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
				System.out.print("Phone No: ");
				String phoneNo = scanner.nextLine();
				System.out.print("Email: ");
				String email = scanner.nextLine();
				System.out.print("Contact Person: ");
				String contactPerson = scanner.nextLine();
				System.out.print("Address: ");
				String address = scanner.nextLine();
				System.out.print("GSTIN Number: ");
				String gstin = scanner.nextLine();
				assetManagement.addVendor(vendorName, phoneNo, email, contactPerson, address, gstin);
				break;
			case 2:
				System.out.print("Enter vendor Id to remove: ");
				try {
			        vendorId = scanner.nextInt();
			        assetManagement.removeVendor(vendorId);
			    } catch (InputMismatchException e) {
			        scanner.nextLine(); // Clear the invalid input from the scanner
			        System.out.println("Invalid vendor Id. Please enter a valid number: "+e);
			    }
				break;
			case 3:
				assetManagement.displayVendorDetails();
				break;
			case 4:
//				System.out.println(scanner.nextLine());
				System.out.print("Enter employee name: ");
				String name = scanner.nextLine();
				System.out.print("Enter department: ");
				String department = scanner.nextLine();
				System.out.print("Enter phone number: ");
				String phone = scanner.nextLine();
				System.out.print("Enter email address: ");
				String employee_email = scanner.nextLine();
				assetManagement.addEmployee(name, department, phone, employee_email);
				break;
			case 5:
				System.out.print("Enter employee ID to remove: ");
				try {
					employeeId = scanner.nextInt();
					assetManagement.removeEmployee(employeeId);
				}catch(InputMismatchException e) {
					 scanner.nextLine(); // Clear the invalid input from the scanner
				     System.out.println("Invalid Employee Id. Please enter a valid number: "+e);
				}
				break;
			case 6:
				assetManagement.displayEmployees();
				break;
			case 7:
				System.out.print("Enter Asset category: "); // Hardware, Software, Networking, etc...
				String category = scanner.nextLine();
				System.out.print("Enter Asset type: "); // Laptop, Mobile, Server, etc...
				String type = scanner.nextLine();
				System.out.print("Enter Asset name: ");
				String asset_name = scanner.nextLine();
				System.out.print("Enter model number: ");
				String modelNumber = scanner.nextLine();
				System.out.print("Enter serial number: ");
				String serialNumber = scanner.nextLine();
				System.out.print("Enter purchase price: ");
				try {
					purchasePrice = scanner.nextDouble();
					scanner.nextLine();
				}catch(InputMismatchException e) {
					scanner.nextLine(); // clear the invalid input from the scanner
					System.out.println("Invalid Purchase Price. Please enter a valid price: "+e);
				}
				System.out.print("Enter purchase date: ");
				String purchaseDate = scanner.nextLine();
				System.out.print("Enter warranty date: ");
				String warrantyDate = scanner.nextLine();
				System.out.println("Enter purchase type: "); // Owned, rented, leased
				String purchaseType = scanner.nextLine();
				System.out.print("Enter vendor Id: ");
				try {
					vendorId = scanner.nextInt();
					scanner.nextLine();
				}catch(InputMismatchException e) {
					scanner.nextLine(); // clear the invalid input from the scanner
					System.out.println("Invalid Vendor Id. Please Enter a valid number: "+e);
				}
				assetManagement.addAsset(category, type, asset_name, modelNumber, serialNumber, purchasePrice, purchaseDate,
						warrantyDate, purchaseType, vendorId);
				break;
			case 8:
				System.out.print("Enter Asset ID to remove: ");
				try {
					assetId = scanner.nextInt();
					assetManagement.removeAsset(assetId);
				}catch(InputMismatchException e) {
					scanner.nextLine(); // clear the invalid input from the scanner
					System.out.println("Invalid Asset Id. Please enter valid number: "+e);
				}
				scanner.nextLine(); // Consume newline character
				break;
			case 9:
				assetManagement.displayAssets();
				break;
			case 10:
			    System.out.print("Enter Asset ID to assign: ");
			    try {
			    	assignAssetId = scanner.nextInt();
			    	scanner.nextLine();
			    }catch(InputMismatchException e) {
			    	scanner.nextLine(); // clear the invalid input from the scanner
					System.out.println("Invalid Asset Id. Please enter valid number: "+e);
			    }
			    System.out.print("Enter Employee ID to assign: ");
			    try {
			    	assignEmployeeId = scanner.nextInt();
			    	scanner.nextLine();
			    }catch(InputMismatchException e) {
			    	scanner.nextLine(); // clear the invalid input from the scanner
					System.out.println("Invalid Empliyee Id. Please enter valid number: "+e);
			    }
			    assetManagement.assignAssetToEmployee(assignAssetId, assignEmployeeId);
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

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Vendor Id: " + id + "\n" + "Vendor Name: " + vendorName + "\n" + "Phone No: " + phoneNo + "\n"
				+ "Email: " + email + "\n" + "Contact Person: " + contactPerson + "\n" + "Address: " + address + "\n"
				+ "GSTIN Number: " + gstin + "\n";
	}
}

class Employee {
	private int id;
	private String name;
	private String department;
	private String phone;
	private String email;
	private boolean isActive;

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
	
	public String getName() {
		return name;
	}
	@Override
	public String toString() {
		return "Employee ID: " + id + "\nName: " + name + "\nDepartment: " + department + "\nPhone: " + phone
				+ "\nEmail: " + email + "\nActive: " + isActive + "\n";
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
	private Vendor vendorDetails;
	private String status;
	private Employee employeeId;
	    
	public Asset(int id, String category, String type, String name, String modelNumber, String serialNumber,
			double purchasePrice, String purchaseDate, String warrantyDate, String purchaseType, Vendor vendor) {
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
		this.vendorDetails = vendor;
		this.status = "Not assinged";
	}

	public int getId() {
		return id;
	}
	
	public Vendor getVendorId() {
		return vendorDetails;
	}
	public void setEmployee(Employee employee) {
	    this.employeeId = employee;
	}    
	public Employee getEmployee() {
	    return employeeId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Asset ID: " + id + "\nCategory: " + category + "\nType: " + type + "\nName: " + name
				+ "\nModel Number: " + modelNumber + "\nSerial Number: " + serialNumber + "\nPurchase Price: "
				+ purchasePrice + "\nPurchase Date: " + purchaseDate + "\nWarranty Date: " + warrantyDate + "\nPurchase Type: " + purchaseType + "\nVendor Details: \n" + vendorDetails;
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