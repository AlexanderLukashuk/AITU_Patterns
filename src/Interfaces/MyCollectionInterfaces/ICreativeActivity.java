package Interfaces.MyCollectionInterfaces;

public interface ICreativeActivity {
    public String Genre = "No genre";
    public String Description = "No description";

    public void SetGenre(String genre);
    public String GetGenre();
    public void SetDescription(String desc);
    public String GetDescription();
}
