package yiezi.ml.domain.customer.gateway;

import yiezi.ml.domain.customer.Customer;

public interface CustomerGateway {
    public Customer getByById(String customerId);
}
