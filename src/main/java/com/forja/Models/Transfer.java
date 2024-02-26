package com.forja.Models;

import com.forja.Models.Account.Account;
import com.forja.Models.Enums.TransferStatusEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Transfer {
    private Long id;
    private Account to;
    private Account from;
    private BigDecimal value;
    private LocalDateTime at;
    private TransferStatusEnum status;
}
