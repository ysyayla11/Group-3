package bacit.web.bacit_web.models;

public class ToolModel {
    private String Tool_id;
    private String Tool_toolName;
    private String Tool_type;
    private String Tool_condition;
    private int Tool_price;
    private int Tool_freeFirstDay;
    private String Tool_importantInformation;
    private String Tool_image;
    private Boolean Tool_delivered;

    public ToolModel(String Tool_id, String Tool_Name, String Tool_type, String Tool_condition, int Tool_price, int Tool_freeFirstDay, String Tool_importantInformation, String Tool_image, Boolean Tool_delivered) {
        this.Tool_id = Tool_id;
        this.Tool_toolName = Tool_Name;
        this.Tool_type = Tool_type;
        this.Tool_condition = Tool_condition;
        this.Tool_price = Tool_price;
        this.Tool_freeFirstDay = Tool_freeFirstDay;
        this.Tool_importantInformation = Tool_importantInformation;
        this.Tool_image = Tool_image;
        this.Tool_delivered = Tool_delivered;

    }

    public String getId() {
        return Tool_id;
    }

    public void setId(String id) {
        this.Tool_id = id;
    }

    public String getName() {
        return Tool_toolName;
    }

    public void setName(String name) {
        this.Tool_toolName = name;
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


    public int getPrice() {return Tool_price;}


    public int getFreeFirstDay() {return Tool_freeFirstDay;}


    public String getImportantInformation() {return Tool_importantInformation;}


    public String getImage() {return Tool_image;}

    public Boolean getTool_delivered(){return Tool_delivered;}
}
