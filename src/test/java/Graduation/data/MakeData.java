package Graduation.data;

import cn.zl.dao.*;
import cn.zl.domain.*;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.apache.ibatis.annotations.Options;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;

/**
 * @author ZL.
 * @project Graduation
 * @right Copyright(C) 2018-2028, ZL. All rights reserved
 * @date 2018/4/11 10:30
 * @des 数据库造数
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:spring-context.xml")
public class MakeData {
    @Resource
    private CustomerMapper customerMapper;

    @Resource
    private CreditMapper creditMapper;

    @Resource
    private CardMapper cardMapper;

    @Resource
    private StaffMapper staffMapper;

    @Resource
    private CaseMapper caseMapper;

    @Resource
    private ApproveMapper approveMapper;

    /**
     * 客户表造数
     */
    @Test
    public void customerData(){
        Customer customer = new Customer();
        for(int i = 0; i < 1000; i++){
            customer.setName(RandomData.getChineseName());
            customer.setGender(RandomData.name_sex);
            customer.setId(RandomData.getRandomUUID());
            customer.setAddress(RandomData.getRoad());
            customer.setPhone(RandomData.getTel());
            customer.setCredit(RandomData.getNum(40,90));
            customer.setLevel(RandomData.getNum(1,9));
            customer.setCard(RandomData.getCard());
            try {
                customerMapper.insert(customer);
            } catch (Exception e) {
                System.out.println("插入失败：" + customer.getId() + customer.getName());
            }
            System.out.println("插入成功：" + customer.getId() + customer.getName());
        }
    }

    /**
     * 信用表造数
     */
    @Test
    public void creditData(){
        Credit credit = new Credit();
        List<Customer> list;
        for(int i = 1; i < 21; i++){
            PageHelper.startPage(i,50);
            list = customerMapper.selectByExample(new CustomerExample());
            for (Customer customer : list) {
                credit.setId(customer.getId());
                credit.setName(customer.getName());
                credit.setTotal(RandomData.getNum(5,20));
                credit.setDelay(RandomData.getNum(0,5));
                credit.setMoney(BigDecimal.valueOf(Math.random()*10000));
                credit.setDebt(BigDecimal.valueOf(Math.random()*1000));
                creditMapper.insert(credit);
                System.out.println("插入成功：" + customer.getId() + customer.getName());
            }
        }
    }

    /**
     * 信用卡表造数
     */
    @Test
    public void cardData(){
        Card card = new Card();
        List<Customer> list;
        for(int i = 1; i < 21; i++){
            PageHelper.startPage(i,50);
            list = customerMapper.selectByExample(new CustomerExample());
            for (Customer customer : list) {
                card.setCard(customer.getCard());
                card.setId(customer.getId());
                card.setAmount(BigDecimal.valueOf(Math.random()*10000));
                card.setDate(RandomData.randomDate("2016-1-1","2018-4-1"));
                card.setBill(5);
                card.setStatus(0);
                cardMapper.insert(card);
                System.out.println("插入成功：" + customer.getId() + customer.getName());
            }
        }
    }

    /**
     * 工单表造数
     */
    @Test
    public void CaseData(){
        Case cases = new Case();
        Staff staff = staffMapper.selectByPrimaryKey("01704");
        PageHelper.startPage(1,100);
        List<Card> list = cardMapper.selectByExample(new CardExample());
        int temp = 0;
        for (Card card : list) {
            cases.setCard(card.getCard());
            cases.setBusiness(staff.getUsername());
            cases.setBusinessTime(RandomData.randomDate("2018-1-1","2018-4-1"));
            if(temp++ < 10){
                cases.setChannel("web");
            }else if(temp++ < 30){
                cases.setChannel("bank");
            }else if(temp++ < 60){
                cases.setChannel("wx");
            }else if(temp++ <100){
                cases.setChannel("app");
            }
            cases.setDeadline(7);
            cases.setId(card.getId());
            cases.setStatus("Y");
            caseMapper.insert(cases);
            System.out.println("插入成功：" + card.getId());
        }
    }

    /**
     * 审批表造数
     */
    @Test
    public void ApproveData(){
        Approve approve = new Approve();
        Staff staff = staffMapper.selectByPrimaryKey("00206");
        List<Case> list = caseMapper.selectByExample(new CaseExample());
        for (Case cases : list) {
            approve.setApprove(staff.getUsername());
            approve.setCard(cases.getCard());
            approve.setChannel(cases.getChannel());
            approve.setId(cases.getId());
            approve.setLevel(RandomData.getNum(1,5));
            approve.setApproveTime(RandomData.randomDate("2018-4-1","2018-4-12"));
            approveMapper.insert(approve);
            System.out.println("插入成功：" + cases.getId());
        }
    }
}
