//package com.demo.bankProject;
////
////import jakarta.persistence.Column;
////import jakarta.persistence.Entity;
////import jakarta.persistence.Table;
////
////@Entity
////@Table
////public class Customer {
////
////	@id
////	int id;
////	
////	@id
////	int accno;
////	
////     @Column
////	String name;
////	
////	@Column
////	String address;
////	
////	@Column
////	String email;
////	
////	@Column
////	String phone;
////
////	public Customer(int accno, String name, String address, String email, String phone) {
////		super();
////		this.accno = accno;
////		this.name = name;
////		this.address = address;
////		this.email = email;
////		this.phone = phone;
////	}
////
////	public int getAccno() {
////		return accno;
////	}
////
////	public void setAccno(int accno) {
////		this.accno = accno;
////	}
////
////	public String getName() {
////		return name;
////	}
////
////	public void setName(String name) {
////		this.name = name;
////	}
////
////	public String getAddress() {
////		return address;
////	}
////
////	public void setAddress(String address) {
////		this.address = address;
////	}
////
////	public String getEmail() {
////		return email;
////	}
////
////	public void setEmail(String email) {
////		this.email = email;
////	}
////
////	public String getPhone() {
////		return phone;
////	}
////
////	public void setPhone(String phone) {
////		this.phone = phone;
////	}
////	
////	
////	
////}
////
////
////
//
/*
 * package com.demo.bankProject;
 * 
 * import jakarta.persistence.Column; import jakarta.persistence.Entity; import
 * jakarta.persistence.Id; import jakarta.persistence.Table;
 * 
 * @Entity
 * 
 * @Table(name = "Customer") public class Customer {
 * 
 * @Id private int id;
 * 
 * @Column private int accno;
 * 
 * @Column private String name;
 * 
 * @Column private String address;
 * 
 * @Column private String email;
 * 
 * @Column private String phone;
 * 
 * // Default constructor (required by Hibernate) public Customer() {}
 * 
 * // Parameterized constructor public Customer(int id, int accno, String name,
 * String address, String email, String phone) { this.id = id; this.accno =
 * accno; this.name = name; this.address = address; this.email = email;
 * this.phone = phone; }
 * 
 * // Getters and setters (required for Hibernate) public int getId() { return
 * id; }
 * 
 * public void setId(int id) { this.id = id; }
 * 
 * public int getAccno() { return accno; }
 * 
 * public void setAccno(int accno) { this.accno = accno; }
 * 
 * public String getName() { return name; }
 * 
 * public void setName(String name) { this.name = name; }
 * 
 * public String getAddress() { return address; }
 * 
 * public void setAddress(String address) { this.address = address; }
 * 
 * public String getEmail() { return email; }
 * 
 * public void setEmail(String email) { this.email = email; }
 * 
 * public String getPhone() { return phone; }
 * 
 * public void setPhone(String phone) { this.phone = phone; } }
 * 
 */

package com.demo.bankProject;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Customer {
    @Id
    private int id;
    private int accno;
    @Column
    private String name;
    @Column
    private String address;
    @Column
    private String email;
    @Column
    private String phone;

    // Default Constructor
    public Customer() {}

    // Constructor
    public Customer(int id, int accno, String name, String address, String email, String phone) {
        this.id = id;
        this.accno = accno;
        this.name = name;
        this.address = address;
        this.email = email;
        this.phone = phone;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAccno() {
        return accno;
    }

    public void setAccno(int accno) {
        this.accno = accno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

	@Override
	public String toString() {
		return "Customer [name=" + name + ", address=" + address + ", email=" + email + ", phone=" + phone + "]";
	}
}


