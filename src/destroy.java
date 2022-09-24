import Entities.Item;

import java.util.ArrayList;
import java.util.List;

public class destroy implements Idestroy {
    List<Item> items;
    public void Idestroy(){
        this.items=new ArrayList<Item>();

    }
    public int calculateTotal(){
        int sum = 0;
        for(Item item : items){
            sum += item.GetPrice();
        }
        return sum;
    }
    @Override
    public void decay(int price) {
        System.out.println(price*0.7 +" 30% sale because it might destroy");
    }
}
