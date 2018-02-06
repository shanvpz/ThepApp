package in.techfantasy.thepapp;

/**
 * Created by campusiq on 06/02/18.
 */

public class CalcModel {
    private String myName;
    private String partnerName;
    private String result;

    public String getMyName() {
        return myName;
    }

    public void setMyName(String myName) {
        this.myName = myName;
    }

    public String getPartnerName() {
        return partnerName;
    }

    public void setPartnerName(String partnerName) {
        this.partnerName = partnerName;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }



    public CalcModel(String myName, String partnerName, String result) {
        this.myName = myName;
        this.partnerName = partnerName;
        this.result = result;
    }


}
