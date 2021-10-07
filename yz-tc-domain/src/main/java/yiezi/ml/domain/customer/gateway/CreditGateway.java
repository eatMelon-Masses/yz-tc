package yiezi.ml.domain.customer.gateway;

import yiezi.ml.domain.customer.Customer;
import yiezi.ml.domain.customer.Credit;

//Assume that the credit info is in antoher distributed Service
public interface CreditGateway {
    public Credit getCredit(String customerId);
}
