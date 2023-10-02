package com.backend.controller;

import com.backend.dto.request.VoucherOrderRequest;
import com.backend.service.IVoucherOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/admin")
public class VoucherOrderController {

    @Autowired
    private IVoucherOrderService voucherOrderService;

    @PostMapping("/addNewVoucherOrder")
    public ResponseEntity<?> addVoucherOrder(@RequestBody VoucherOrderRequest voucherOrderRequest) {
        return ResponseEntity.ok(voucherOrderService.addVoucher(voucherOrderRequest));
    }

    @PutMapping("/updateVoucherOrder/{id}")
    public ResponseEntity<?> updateVoucherOrder(@RequestBody VoucherOrderRequest voucherOrderRequest, @PathVariable(name = "id")Long id) {
        return ResponseEntity.ok(voucherOrderService.updateVoucher(voucherOrderRequest,id));
    }
}
