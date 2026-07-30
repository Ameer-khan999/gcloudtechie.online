package com.tcs.hospitalmanagement;

public class Billing {
	   
    private static final double[] payment = null;

	public static double[] computePaymentAmount(Patient patient, double amount) {
        double[] payments = new double[2];
        
        HealthInsurancePlan patientInsurancePlan = patient.getInsurancePlan();
		return payment;

        // your logic 
    }
        public static  HealthInsurancePlan platinumPlan(HealthInsurancePlan his) {
		if (his instanceof PlatinumPlan) {
			((PlatinumPlan) his).platinumPlan(1000);
			System.out.println("\n");
		} else {
			System.out.println("Invalid object passed1 !!\n");
		}
		    return his;
    }
		
		public static void main(String[] args) {
		    //computePaymentAmount(PlatinumPlan,1000.0);
		    Billing b=new Billing();
		    b.platinumPlan(new PlatinumPlan());
		}

}

        

