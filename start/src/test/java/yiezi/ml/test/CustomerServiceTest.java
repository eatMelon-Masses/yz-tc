package yiezi.ml.test;

import com.alibaba.cola.dto.Response;
import org.junit.Assert;
import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;
import yiezi.ml.api.CustomerServiceI;
import yiezi.ml.dto.CustomerAddCmd;
import yiezi.ml.dto.data.CustomerDTO;
import yiezi.ml.dto.data.ErrorCode;

/**
 * This is for integration test.
 * <p>
 * Created by fulan.zjf on 2017/11/29.
 */
//@RunWith(SpringRunner.class)
//@SpringBootTest
public class CustomerServiceTest {

    @Autowired
    private CustomerServiceI customerService;


    @Before
    public void setUp() {

    }

    // @Test
    public void testCustomerAddSuccess() {
        //1.prepare
        CustomerAddCmd customerAddCmd = new CustomerAddCmd();
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setCompanyName("NormalName");
        customerAddCmd.setCustomerDTO(customerDTO);

        //2.execute
        Response response = customerService.addCustomer(customerAddCmd);

        //3.assert
        Assert.assertTrue(response.isSuccess());
    }

    //@Test
    public void testCustomerAddCompanyNameConflict() {
        //1.prepare
        CustomerAddCmd customerAddCmd = new CustomerAddCmd();
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setCompanyName("ConflictCompanyName");
        customerAddCmd.setCustomerDTO(customerDTO);

        //2.execute
        Response response = customerService.addCustomer(customerAddCmd);

        //3.assert error
        Assert.assertEquals(ErrorCode.B_CUSTOMER_companyNameConflict.getErrCode(), response.getErrCode());
    }
}
