package com.example.elasticsearchdemo;
import java.io.IOException;
import	java.text.SimpleDateFormat;
import java.util.Date;

import com.alibaba.fastjson.JSON;
import com.example.elasticsearchdemo.demo.Index;
import com.example.elasticsearchdemo.demo.RestHighLevelClientService;
import com.example.elasticsearchdemo.demo.VoucherBaseInfoDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author zhouguanya
 * @version Id: ElasticSearchTest.java, v 0.1  2020/6/22 zhouguanya Exp $$
 */
@SpringBootTest
public class ElasticSearchTest {

    @Autowired
    private RestHighLevelClientService restHighLevelClientService;

    @Test
    public void testAdd() throws IOException {
       for (int i = 1111; i < 1130; i++) {
           SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
           VoucherBaseInfoDTO voucherBaseInfoDTO = new VoucherBaseInfoDTO();
           voucherBaseInfoDTO.setVoucherNo(String.valueOf(i));
           voucherBaseInfoDTO.setEquityNo(String.valueOf(i));
           voucherBaseInfoDTO.setProductNo(String.valueOf(i));
           voucherBaseInfoDTO.setDenomination(0L);
           voucherBaseInfoDTO.setCreatedAt(sdf.format(new Date()));
           voucherBaseInfoDTO.setUpdatedAt(sdf.format(new Date()));
           voucherBaseInfoDTO.setEffectiveDate(sdf.format(new Date()));
           voucherBaseInfoDTO.setExpireDate(sdf.format(new Date()));
           voucherBaseInfoDTO.setVoucherStatus(String.valueOf(i));
           voucherBaseInfoDTO.setContractNo(String.valueOf(i));
           voucherBaseInfoDTO.setExternalRelatedId(String.valueOf(i));
           voucherBaseInfoDTO.setVoucherCategory(String.valueOf(i));
           restHighLevelClientService.add(Index.TEST.getName(), null, JSON.toJSONString(voucherBaseInfoDTO));
       }
    }
}
