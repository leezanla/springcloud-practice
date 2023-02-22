package work.leezan.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import work.leezan.entities.CommentResult;
import work.leezan.entities.Payment;
import work.leezan.service.PaymentService;

@RestController
@Slf4j
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @PostMapping("/payment/create")
    public CommentResult create(@RequestBody Payment payment) {
        int result = paymentService.create(payment);
        log.info("插入结果：{}", result);
        if (result > 0) {
            return new CommentResult(200,"插入数据库成功,serverPort:" + serverPort,result);
        } else {
            return new CommentResult(444,"插入数据库失败", null);
        }
    }

    @GetMapping("/payment/get/{id}")
    public CommentResult getPaymentById(@PathVariable Long id) {
        Payment result = paymentService.getPaymentById(id);
        log.info("查询结果：{}", result);
        if (result != null) {
            return new CommentResult(200,"查询成功,serverPort:" + serverPort, result);
        } else {
            return new CommentResult(444,"查询失败", null);
        }
    }

}
