package com.backend.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VoucherOrderResponse {
    private Long id;

    private String code;

    private String name;

    private Integer quantity;

    private BigDecimal discountAmount;

    private BigDecimal minBillValue;

    private LocalDateTime startDate;

    private LocalDateTime endDate;

    private LocalDateTime createDate;

    private LocalDateTime updateAt;

    private String reduceForm;

    private Integer status;
}