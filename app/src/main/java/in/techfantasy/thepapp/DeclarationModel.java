package in.techfantasy.thepapp;

/**
 * Created by campusiq on 06/02/18.
 */

public class DeclarationModel {
    private String UrName;
    private String PartName;
    private String Story;
    private String StDate;
    private String EnDate;

    public String getUrName() {
        return UrName;
    }

    public void setUrName(String urName) {
        UrName = urName;
    }

    public String getPartName() {
        return PartName;
    }

    public void setPartName(String partName) {
        PartName = partName;
    }

    public String getStory() {
        return Story;
    }

    public void setStory(String story) {
        Story = story;
    }

    public String getStDate() {
        return StDate;
    }

    public void setStDate(String stDate) {
        StDate = stDate;
    }

    public String getEnDate() {
        return EnDate;
    }

    public void setEnDate(String enDate) {
        EnDate = enDate;
    }

    public DeclarationModel(String urName, String partName, String story, String stDate, String enDate) {
        UrName = urName;
        PartName = partName;
        Story = story;
        StDate = stDate;
        EnDate = enDate;
    }
    public DeclarationModel(){

    }


}
