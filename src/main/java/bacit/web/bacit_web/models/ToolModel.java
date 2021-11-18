package bacit.web.bacit_web.models;

public class ToolModel {
    private String Tool_id;
    private String Tool_Name;
    private String Tool_type;
    private String Tool_condition;
    private int Tool_price;
    private int Tool_freeFirstDay;
    private String Tool_importantInformation;
    private byte[] Tool_image;

    public ToolModel(String Tool_id, String Tool_Name, String Tool_type, String Tool_condition, int Tool_price, int Tool_freeFirstDay, String Tool_importantInformation, byte[] Tool_image) {
        this.Tool_id = Tool_id;
        this.Tool_Name = Tool_Name;
        this.Tool_type = Tool_type;
        this.Tool_condition = Tool_condition;
        this.Tool_price = Tool_price;
        this.Tool_freeFirstDay = Tool_freeFirstDay;
        this.Tool_importantInformation = Tool_importantInformation;
        this.Tool_image = Tool_image;

    }

    public String getId() {
        return Tool_id;
    }

    public void setId(String id) {
        this.Tool_id = id;
    }

    public String getName() {
        return Tool_Name;
    }

    public void setName(String name) {
        this.Tool_Name = name;
    }


    public String getType() {
        return Tool_type;
    }

    public void setType(String type) {
        this.Tool_type = type;
    }


    public String getCondition() {
        return Tool_condition;
    }

    public void setCondition(String condition) {
        this.Tool_condition = condition;
    }


    public int getPrice() {return Tool_price;}

    public void setPrice(int price) {this.Tool_price = price;}


    public int getFreeFirstDay() {return Tool_freeFirstDay;}

    public void setFreeFirstDay(int freeFirstDay) {this.Tool_freeFirstDay = freeFirstDay;}


    public String geImportantInforamtion() {return Tool_importantInformation;}

    public void setImportantInformation(String importantInformation) {this.Tool_importantInformation = importantInformation;}

    public byte[] getImage() {return Tool_image;}

    public void setImage(byte[] image) {this.Tool_image = image;}
}
