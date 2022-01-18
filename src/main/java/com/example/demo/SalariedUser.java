package com.example.demo;

class SalariedUser extends User{
    private int basic = 0;
    private int da = 0; // dearness allowance
    
    private int hra = 0;
    private boolean onRent = true;
    private boolean livingInMetro;
    private int totalRentPaid = 0;
    
    private int lta = 0; // leave travel allowance
    private int incomeEarnedFromOtherSources = 0;
    private int invUnder80c = 0;
    private int npsInv = 0;
    private int savingsAccInterest = 0;
    private int intOnEduLoan = 0;
    private int intToHomeLoan = 0;
    private int medicalInsurancePremiumBills = 0;
    private int donationUnder80G = 0;
    
    public SalariedUser() {}

	public SalariedUser(String name, int basic, int hra, int lta) {
		super(name);
		this.basic = basic;
		this.hra = hra;
		this.lta = lta;
	}

	
	
	@Override
	public String toString() {
		return "SalariedUser [basic=" + basic + ", da=" + da + ", hra=" + hra + ", onRent=" + onRent
				+ ", livingInMetro=" + livingInMetro + ", totalRentPaid=" + totalRentPaid + ", lta=" + lta
				+ ", incomeEarnedFromOtherSources=" + incomeEarnedFromOtherSources + ", invUnder80c=" + invUnder80c
				+ ", npsInv=" + npsInv + ", savingsAccInterest=" + savingsAccInterest + ", intOnEduLoan=" + intOnEduLoan
				+ ", intToHomeLoan=" + intToHomeLoan + ", medicalInsurancePremiumBills=" + medicalInsurancePremiumBills
				+ ", donationUnder80G=" + donationUnder80G + "]";
	}

	public String tax() {
		float tax = 0;
		int netSalary = 0;
		int hraDeduction = 0;
		int netTaxableIncome = 0;
		
		// calculating excemptions
		
		if(onRent && totalRentPaid > 0) {
			// hra scenarios -> Select the least
			int scenario1 = hra;
			int scenario2 , scenario3;
			
			if(livingInMetro) {
				scenario2 = (basic + da) * 50 / 100;
			}else {
				scenario2 = (basic + da) * 40 / 100;
			}
			
			scenario3 = totalRentPaid - (basic / 10);
			
			if(scenario1 < scenario2 && scenario1 < scenario3) {
				hraDeduction = scenario1;
			}else if(scenario2 < scenario1 && scenario2 < scenario3) {
				hraDeduction = scenario2;
			}else {
				hraDeduction = scenario3;
			}
			
			
		}else {
			netSalary = netSalary + hra;
		}
		netSalary = netSalary + basic - hraDeduction - lta - 50000;
		
		// incomeEarnedFromOtherSources = rental income, interest earned + capital gains
		
		netSalary = netSalary + incomeEarnedFromOtherSources;
		
		// calculating deductions;
		
		netTaxableIncome = netSalary;
		
		// ----------------- Excemptions -------------
			
		// investments and expenses under section 80
			
		// section 80 C (upto 1.5 lakhs)
		// eg. ppf, elss, epf, sukanya (SSY), premium paid for term insurance ,
		// repayment towards principal of home loan
		
		netTaxableIncome = netTaxableIncome - invUnder80c; 
		
		// nps upto 50,000 under section 80cccd(1B)
		
		if(npsInv > 50000) {
			netTaxableIncome -= 50000;
		}else {
			netTaxableIncome -= npsInv;
		}
		
		// interest earned on savings account upto 10,000
		
		if(savingsAccInterest > 10000) {
			netTaxableIncome += savingsAccInterest - 10000; 
		}
		
		// upto 25,000 on medical insurance premium bills
		if(medicalInsurancePremiumBills > 25000) {
			netTaxableIncome -= 25000;
		}else {
			netTaxableIncome -= medicalInsurancePremiumBills;
		}
		
		// donation under 80G
		netTaxableIncome -= donationUnder80G;
		
		
		// deduction on interest of education loan
		netTaxableIncome -= intOnEduLoan;
		
		//deduction of upto 2 lakh on interest paid in financial year to home loan
		
		if(intToHomeLoan > 200000) {
			netTaxableIncome -= 20000;
		}else {
			netTaxableIncome -= intToHomeLoan;
		}
		
		// ------------ calculate tax
		
		if(netTaxableIncome < 500000) {
			tax = 0;
		}else if (netTaxableIncome < 750000 && netTaxableIncome > 500000 ) {
			tax = (float) (netTaxableIncome * 0.1);
		}else if(netTaxableIncome < 1000000 && netTaxableIncome > 750000 ) {
			tax = (float) (netTaxableIncome * 0.15);
		}else if (netTaxableIncome > 1000000 && netTaxableIncome < 1250000 ) {
			tax = (float) (netTaxableIncome * 0.2);
		}else if (netTaxableIncome < 1500000 && netTaxableIncome > 1250000 ) {
			tax = (float) (netTaxableIncome * 0.25);
		}else if(netTaxableIncome > 1500000) {
			tax = (float) (netTaxableIncome * 0.3);
			
		}
		
		return "tax: " + tax + ", net salary: " + netSalary + ", net taxable Income: " + netTaxableIncome + "SalariedUser [basic=" + basic + ", da=" + da + ", hra=" + hra + ", onRent=" + onRent
				+ ", livingInMetro=" + livingInMetro + ", totalRentPaid=" + totalRentPaid + ", lta=" + lta
				+ ", incomeEarnedFromOtherSources=" + incomeEarnedFromOtherSources + ", invUnder80c=" + invUnder80c
				+ ", npsInv=" + npsInv + ", savingsAccInterest=" + savingsAccInterest + ", intOnEduLoan=" + intOnEduLoan
				+ ", intToHomeLoan=" + intToHomeLoan + ", medicalInsurancePremiumBills=" + medicalInsurancePremiumBills
				+ ", donationUnder80G=" + donationUnder80G + "]" ;
				
	}
	


	public int getBasic() {
		return basic;
	}

	public void setBasic(int basic) {
		this.basic = basic;
	}

	public int getHra() {
		return hra;
	}

	public void setHra(int hra) {
		this.hra = hra;
	}

	public int getLta() {
		return lta;
	}

	public void setLta(int lta) {
		this.lta = lta;
	}

	public int getDa() {
		return da;
	}

	public void setDa(int da) {
		this.da = da;
	}


	public boolean isLivingInMetro() {
		return livingInMetro;
	}

	public void setLivingInMetro(boolean livingInMetro) {
		this.livingInMetro = livingInMetro;
	}

	public boolean isOnRent() {
		return onRent;
	}

	public void setOnRent(boolean onRent) {
		this.onRent = onRent;
	}

	public int getTotalRentPaid() {
		return totalRentPaid;
	}

	public void setTotalRentPaid(int totalRentPaid) {
		this.totalRentPaid = totalRentPaid;
	}

	public int getIncomeEarnedFromOtherSources() {
		return incomeEarnedFromOtherSources;
	}

	public void setIncomeEarnedFromOtherSources(int incomeEarnedFromOtherSources) {
		this.incomeEarnedFromOtherSources = incomeEarnedFromOtherSources;
	}

	public int getInvUnder80c() {
		return invUnder80c;
	}

	public void setInvUnder80c(int invUnder80c) {
		this.invUnder80c = invUnder80c;
	}

	public int getNpsInv() {
		return npsInv;
	}

	public void setNpsInv(int npsInv) {
		this.npsInv = npsInv;
	}

	public int getSavingsAccInterest() {
		return savingsAccInterest;
	}

	public void setSavingsAccInterest(int savingsAccInterest) {
		this.savingsAccInterest = savingsAccInterest;
	}

	public int getIntOnEduLoan() {
		return intOnEduLoan;
	}

	public void setIntOnEduLoan(int intOnEduLoan) {
		this.intOnEduLoan = intOnEduLoan;
	}

	public int getIntToHomeLoan() {
		return intToHomeLoan;
	}

	public void setIntToHomeLoan(int intToHomeLoan) {
		this.intToHomeLoan = intToHomeLoan;
	}

	public int getMedicalInsurancePremiumBills() {
		return medicalInsurancePremiumBills;
	}

	public void setMedicalInsurancePremiumBills(int medicalInsurancePremiumBills) {
		this.medicalInsurancePremiumBills = medicalInsurancePremiumBills;
	}

	public int getDonationUnder80G() {
		return donationUnder80G;
	}

	public void setDonationUnder80G(int donationUnder80G) {
		this.donationUnder80G = donationUnder80G;
	}
	
	
}
