package com.example.elasticsearchdemo.demo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;


@ToString
@Setter
@Getter
public class VoucherBaseInfoDTO implements Serializable {

    private static final long serialVersionUID = 9139106842168366289L;

    /**
     * 代金券编号
     */
    private String voucherNo;

    /**
     * 权益编号
     */
    private String equityNo;

    /**
     * 手机号
     */
    private String productNo;

    /**
     * 券面值
     */
    private Long denomination;

    /**
     * 券创建时间
     */
    private String createdAt;

    /**
     * 券修改时间
     */
    private String updatedAt;

    /**
     * 券生效时间
     */
    private String effectiveDate;

    /**
     * 券失效时间
     */
    private String expireDate;

    /**
     * 券使用状态
     */
    private String voucherStatus;

    /**
     * 客户账户号
     */
    private String contractNo;

    /**
     * 外部关联Id
     */
    private String externalRelatedId;

    /**
     * 券大类
     */
    private String voucherCategory;

}