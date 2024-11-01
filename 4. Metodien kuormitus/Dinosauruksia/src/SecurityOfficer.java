public class SecurityOfficer extends Employee implements Security {
    private boolean hasGunLicense;

    public SecurityOfficer(String name, String jobTitle, int yearsOfExperience, boolean hasGunLicense) {
        super(name, jobTitle, yearsOfExperience);
        this.hasGunLicense = hasGunLicense;
        super.setEmployeeRole(EmployeeRole.SECURITY);
    }

    public void patrol() {
        System.out.println(this.getName() + " is patrolling.");
    }


    @Override
    public String toString() {
        return super.toString() + ", SecurityOfficer{" +
                "hasGunLicense=" + hasGunLicense +
                '}';
    }
}
