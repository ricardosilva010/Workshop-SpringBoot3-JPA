package com.example.course.entities;

import com.example.course.entities.pk.OrderItemPK;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "table_order_item")
public class OrderItem implements Serializable
{
    @EmbeddedId
    private OrderItemPK id = new OrderItemPK();
    public Integer quantity;
    public Double price;

    public OrderItem()
    {
    }

    public OrderItem(Order order, Product product, Integer quantity, Double price)
    {
        id.setOrder(order);
        id.setProduct(product);
        this.quantity = quantity;
        this.price = price;
    }

    @JsonIgnore
    public Order getOrder()
    {
        return id.getOrder();
    }

    public void setOrder(Order order)
    {
        id.setOrder(order);
    }

    public Product getProduct()
    {
        return id.getProduct();
    }

    public void setProduct(Product product)
    {
        id.setProduct(product);
    }

    public Integer getQuantity()
    {
        return quantity;
    }

    public void setQuantity(Integer quantity)
    {
        this.quantity = quantity;
    }

    public Double getPrice()
    {
        return price;
    }

    public void setPrice(Double price)
    {
        this.price = price;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof OrderItem orderItem)) return false;

        return Objects.equals(id, orderItem.id);
    }
}
