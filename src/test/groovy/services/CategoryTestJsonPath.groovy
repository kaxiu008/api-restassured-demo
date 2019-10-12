package testServices

public class CategoryTestJsonPath {

    public static String name = "Name";
    public static String canRelist = "CanRelist";

    //Find a Promotion's Description by specific Name
    public String findPromotionDescriptionByName(String name){
        return "Promotions.find { it.Name == '${name}' }.Description";
    }
}