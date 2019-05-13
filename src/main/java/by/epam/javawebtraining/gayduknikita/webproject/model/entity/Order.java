package by.epam.javawebtraining.gayduknikita.webproject.model.entity;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;
import java.util.Set;

/**
 * @author NikitaGayduk
 * @date 25.04.2019
 */
public class Order extends Entity {
    private Timestamp desiredTime;
    private int tenantID;
    private OrderState state;
    private Timestamp worksBegin;
    private Timestamp worksEnd;
    private String orderDiscription;

    public Order() {
    }

    public Order(int id, Timestamp desiredTime, int tenantID, OrderState state, Timestamp worksBegin
            , Timestamp worksEnd, String orderDiscription) {
        super(id);
        this.desiredTime = desiredTime;
        this.tenantID = tenantID;
        this.state = state;
        this.worksBegin = worksBegin;
        this.worksEnd = worksEnd;
    }

    public Timestamp getDesiredTime() {
        return desiredTime;
    }

    public void setDesiredTime(Timestamp desiredTime) {
        this.desiredTime = desiredTime;
    }

    public int getTenantID() {
        return tenantID;
    }

    public void setTenantID(int tenantID) {
        this.tenantID = tenantID;
    }

    public OrderState getState() {
        return state;
    }

    public void setState(OrderState state) {
        this.state = state;
    }

    public Timestamp getWorksBegin() {
        return worksBegin;
    }

    public void setWorksBegin(Timestamp worksBegin) {
        this.worksBegin = worksBegin;
    }

    public Timestamp getWorksEnd() {
        return worksEnd;
    }

    public void setWorksEnd(Timestamp worksEnd) {
        this.worksEnd = worksEnd;
    }

    public String getOrderDiscription() {
        return orderDiscription;
    }

    public void setOrderDiscription(String orderDiscription) {
        this.orderDiscription = orderDiscription;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Order order = (Order) o;
        return Objects.equals(desiredTime, order.desiredTime) &&
                Objects.equals(tenantID, order.tenantID) &&
                state == order.state &&
                Objects.equals(worksBegin, order.worksBegin) &&
                Objects.equals(worksEnd, order.worksEnd);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), desiredTime, tenantID, state, worksBegin, worksEnd);
    }

    @Override
    public String toString() {
        return "Order{" +
                "desiredTime=" + desiredTime +
                ", tenantID=" + tenantID +
                ", state=" + state +
                ", worksBegin=" + worksBegin +
                ", worksEnd=" + worksEnd +
                "} " + super.toString();
    }
}
