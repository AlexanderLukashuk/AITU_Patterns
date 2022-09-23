public class workOfArt implements games{
    String name;
    int price;
    public  workOfArt(String name, int price){
        this.name=name;
        this.price=price;
    }
    @Override
    public void play( int value) {
        System.out.println(value*1.3 +" you can play with this items");
    }
}
