package yiezi.ml.customer;

import org.springframework.stereotype.Component;
import yiezi.ml.domain.customer.Customer;
import yiezi.ml.domain.customer.gateway.CustomerGateway;

@Component
public class CustomerGatewayImpl implements CustomerGateway {


    public Customer getByById(String customerId) {
        //Convert to Customer
        return null;
    }
}
