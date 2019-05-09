package by.epam.javawebtraining.gayduknikita.webproject.model.entity;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/**
 * @author NikitaGayduk
 * @date 25.04.2019
 */
public class Order extends Entity {
    private Timestamp desiredTime;
    private Tenant tenant;
    private OrderState state;
    private Timestamp worksBegin;
    private Timestamp worksEnd;
    private Set<Employee> workers;

    public Order() {
    }

    public Order(int id, Timestamp desiredTime, Tenant tenant, OrderState state, Timestamp worksBegin
            , Timestamp worksEnd, Collection<Employee> workers) {
        super(id);
        this.desiredTime = desiredTime;
        this.tenant = tenant;
        this.state = state;
        this.worksBegin = worksBegin;
        this.worksEnd = worksEnd;
        this.workers.addAll(workers);
    }

    public Timestamp getDesiredTime() {
        return desiredTime;
    }

    public void setDesiredTime(Timestamp desiredTime) {
        this.desiredTime = desiredTime;
    }

    public Tenant getTenant() {
        return tenant;
    }

    public void setTenant(Tenant tenant) {
        this.tenant = tenant;
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

    public Collection<Employee> getWorkers() {
        return workers;
    }

    public void setWorkers(Collection<Employee> workers) {
        this.workers.addAll(workers);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Order order = (Order) o;
        return Objects.equals(desiredTime, order.desiredTime) &&
                Objects.equals(tenant, order.tenant) &&
                state == order.state &&
                Objects.equals(worksBegin, order.worksBegin) &&
                Objects.equals(worksEnd, order.worksEnd) &&
                Objects.equals(workers, order.workers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), desiredTime, tenant, state, worksBegin, worksEnd, workers);
    }

    @Override
    public String toString() {
        return "Order{" +
                "desiredTime=" + desiredTime +
                ", tenant=" + tenant +
                ", state=" + state +
                ", worksBegin=" + worksBegin +
                ", worksEnd=" + worksEnd +
                ", workers=" + workers +
                "} " + super.toString();
    }
}
