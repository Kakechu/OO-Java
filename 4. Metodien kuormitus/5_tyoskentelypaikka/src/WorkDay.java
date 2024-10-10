public enum WorkDay {
    // Konstruktorin arvot määritellään vakioarvoja lueteltaessa
    MONDAY("9-17"),
    TUESDAY("9-17"),
    WEDNESDAY("9-17"),
    THURSDAY("9-17"),
    FRIDAY("9-17"),
    SATURDAY("10-13"){
        @Override
        public String getWorkLocation(){
            return "Home";
        }
        };
    /*
    SUNDAY("Off"){
        @Override
        public String getWorkLocation() {
            return "Home";
        }
    };
     */

    private String hoursOfWOrk; // oliomuuttuja

    WorkDay(String hoursOfWOrk) { // konstruktori
        this.hoursOfWOrk = hoursOfWOrk;
    }

    public String getHoursOfWOrk() {
        return hoursOfWOrk;
    }

    public String getWorkLocation() {
        return "Office";
    }


}

