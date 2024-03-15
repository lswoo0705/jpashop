package jpabook.jpashop.service.query;

import jpabook.jpashop.domain.Item.OrderItem;
import lombok.Getter;

@Getter
public class OrderItemDto {
    private String itemName;
    private int orderPrice;
    private int count;

    // 생성자로 원하는 데이터만 보여주기
    public OrderItemDto(OrderItem orderItem) {
        itemName = orderItem.getItem().getName();
        orderPrice = orderItem.getOrderPrice();
        count = orderItem.getCount();
    }
}
