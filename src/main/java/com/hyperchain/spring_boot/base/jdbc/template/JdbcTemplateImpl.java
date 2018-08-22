///**
// * Copyright (C), 2016-2018, 趣链科技有限有限公司
// * FileName: JdbcTemplateImpl
// * Author:   lixuanfeng
// * Date:     2018/8/9 上午10:42
// * Description:
// * History:
// * <author>          <time>          <version>          <desc>
// * 作者姓名           修改时间           版本号              描述
// */
//package com.hyperchain.spring_boot.base.jdbc.template;
//
///**
// * 〈一句话功能简述〉<br>
// * 〈〉
// *
// * @author lixuanfeng
// * @create 2018/8/9
// * @since 1.0.0
// */
//
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.jdbc.datasource.DataSourceTransactionManager;
//import org.springframework.stereotype.Component;
//import org.springframework.transaction.PlatformTransactionManager;
//import org.springframework.transaction.TransactionStatus;
//import org.springframework.transaction.support.DefaultTransactionDefinition;
//
//import javax.sql.DataSource;
//
//@Component
//public class JdbcTemplateImpl extends JdbcTemplate implements com.hyperchain.spring_boot.base.jdbc.template.JdbcTemplate {
//    private PlatformTransactionManager platformTransactionManager;
//    private DefaultTransactionDefinition transactionDefinition;
//    private ThreadLocal<TransactionStatus> transcationStatus = new ThreadLocal();
//
//    public JdbcTemplateImpl(DataSource dataSource) {
//        super(dataSource);
//    }
//
//    public JdbcTemplateImpl() {
//    }
//
//    /**
//     * 开启事务
//     */
//    public void beginTranstaion() {
//        TransactionStatus tmp = this.platformTransactionManager.getTransaction(this.transactionDefinition);
//        //把事务状态放入本地线程
//        this.transcationStatus.set(tmp);
//    }
//
//    /**
//     * 提交事务
//     */
//    public void commit() {
//        //从本地线程中获取事务状态
//        TransactionStatus tmp = (TransactionStatus) this.transcationStatus.get();
//        if (tmp == null) {
//            throw new RuntimeException("no transcation");
//        } else {
//            this.platformTransactionManager.commit(tmp);
//            this.transcationStatus.remove();
//        }
//    }
//
//    /**
//     * 回滚事务
//     */
//    public void rollback() {
//        TransactionStatus tmp = (TransactionStatus) this.transcationStatus.get();
//        if (tmp == null) {
//            throw new RuntimeException("no transcation");
//        } else {
//            this.platformTransactionManager.rollback(tmp);
//            this.transcationStatus.remove();
//        }
//    }
//
//    public void afterPropertiesSet() {
//        super.afterPropertiesSet();
//        this.transactionDefinition = new DefaultTransactionDefinition();
//        this.transactionDefinition.setIsolationLevel(2);
//        this.transactionDefinition.setPropagationBehavior(0);
//        this.platformTransactionManager = new DataSourceTransactionManager(this.getDataSource());
//    }
//
//    public PlatformTransactionManager getPlatformTransactionManager() {
//        return this.platformTransactionManager;
//    }
//
//    public DefaultTransactionDefinition getTransactionDefinition() {
//        return this.transactionDefinition;
//    }
//
//    public ThreadLocal<TransactionStatus> getTranscationStatus() {
//        return this.transcationStatus;
//    }
//
//    public DataSource getDataSource() {
//        return super.getDataSource();
//    }
//}