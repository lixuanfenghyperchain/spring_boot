/**
 * Copyright (C), 2016-2019, 趣链科技有限有限公司
 * FileName: CCBController
 * Author:   lixuanfeng
 * Date:     2019/4/12 上午9:59
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.hyperchain.spring_boot.ccb;

import ccb.charity.contract.ContractConstant;
import ccb.charity.model.DonateFeedbackRecord;
import ccb.charity.model.DonorDAF;
import ccb.charity.model.DonorDAFDetail;
import ccb.charity.model.OrganSettlementFlow;
import ccb.charity.service.CharityListService;
import ccb.charity.service.CharityService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author lixuanfeng
 * @create 2019/4/12
 * @since 1.0.0
 */
@RestController
@RequestMapping(value = "/ccb")
public class CCBController {

    @RequestMapping(value = "/insertDonorDAF", method = RequestMethod.GET)
    public Boolean insertDonorDAF() {
        String replace = UUID.randomUUID().toString().replace("-", "");
//        System.out.println(replace);
        DonorDAF donorDAF = new DonorDAF(replace, "456", "we");
        return CharityService.insertDonorDAF(donorDAF);
    }


    @RequestMapping(value = "/queryDonorDAF", method = RequestMethod.GET)
    public DonorDAF queryDonorDAF(String userId) {
        return CharityService.queryDonorDAF(userId);
    }

    @RequestMapping(value = "/insertDonorDAFList", method = RequestMethod.GET)
    public void insertDonorDAFList() {
        List<DonorDAF> donorDAFList = new ArrayList<>();
        for (int i = 3000; i < 3300; i++) {
            DonorDAF donorDAF = new DonorDAF("123" + i, "456", "we");
            donorDAFList.add(donorDAF);
        }
        CharityListService.insertDonorDAFList(donorDAFList);
    }


    @RequestMapping(value = "/insertDonorDAFDetailList", method = RequestMethod.GET)
    public void insertDonorDAFDetailList() {
        List<DonorDAFDetail> donorDAFDetailList = new ArrayList<>();
        for (int j = 1; j < 100; j++) {
            DonorDAFDetail donorDAF1 = new DonorDAFDetail("88" + j, "456", "we", "23", "45", "453", "1", 6, 8);
            donorDAFDetailList.add(donorDAF1);
        }
        CharityListService.insertDonorDAFDetailList(donorDAFDetailList);
    }

    @RequestMapping(value = "/insertOrganSettlementFlow", method = RequestMethod.GET)
    public boolean insertOrganSettlementFlow() {
        String replace = UUID.randomUUID().toString().replace("-", "");
        OrganSettlementFlow organSettlementFlow = new OrganSettlementFlow(replace, "2", "3", "4", "1234", 1.34, "2", "3", "df", "rt", "er", "fd", "sg", "fdv", "zv", "gf");
        return CharityService.insertOrganSettlementFlow(organSettlementFlow);
    }


    @RequestMapping(value = "/insertOrganSettlementFlowList", method = RequestMethod.GET)
    public void insertOrganSettlementFlowList() {
        List<OrganSettlementFlow> organSettlementFlows = new ArrayList<>();
        for (int j = 1; j < 2000; j++) {
            String replace = UUID.randomUUID().toString().replace("-", "");
            OrganSettlementFlow organSettlementFlow = new OrganSettlementFlow(replace, "2", "3", "4", "1234", 1.34, "2", "3", "df", "rt", "er", "fd", "sg", "fdv", "zv", "gf");
            organSettlementFlows.add(organSettlementFlow);
        }
        CharityListService.insertOrganSettlementFlowList(organSettlementFlows);
    }

    @RequestMapping(value = "/insertDonateFeedbackRecord", method = RequestMethod.GET)
    public boolean insertDonateFeedbackRecord() {
        String replace = UUID.randomUUID().toString().replace("-", "");
        DonateFeedbackRecord donateFeedbackRecord = new DonateFeedbackRecord(replace, "2", "3", 4.02, "334", "df", "svd", "ds", "gs");
        return CharityService.insertDonateFeedbackRecord(donateFeedbackRecord);
    }

    public static void main(String[] args) throws Exception {
        ContractConstant.deployContract();
    }
}