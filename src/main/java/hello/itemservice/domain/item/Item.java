package hello.itemservice.domain.item;

import lombok.Getter;
import lombok.Setter;

// @Data 는 도메인에 사용하면 위험할때가 있다.
@Getter @Setter
public class Item {

    private Long id;
    private String itemName;
    private Integer price;
    private Integer quantity;

    public Item() {}

    public Item(String itemName, Integer price, Integer quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }
}
