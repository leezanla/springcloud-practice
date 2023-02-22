package work.leezan.service;

import org.apache.ibatis.annotations.Param;
import work.leezan.entities.Payment;

public interface PaymentService {
    int create(Payment payment);
    Payment getPaymentById(@Param("id") Long id);
}
