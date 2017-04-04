package com.utsoft.pring.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

/**
 * <br />日期：2017/4/4
 * <br />时间：20:42
 * <br />创建人：刘坤
 * <br />描述：
 */
@Repository
@EnableTransactionManagement // 启用事物。
public class ProductDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void add(String name){
        String sql = " INSERT INTO user(username)VALUE ('"+name+"') ";
        jdbcTemplate.execute(sql);
    }

    /**
     * 事物如果失败，是一条数据都保存不了的。
     * 注：它只对运行时异常有效。
     *
     * rollbackFor = Exception.class  对所有的异常进行一个回滚。
     * 就是如果保存一条数据时、在保存其它数据报错、它就进行回滚。？？？
     * 它可以设置对哪些异常进行回滚。默认是对运行时异常进行回滚。
     *
     * 还可以设置对哪些异常不进行回滚。
     * noRollbackFor = NullPointerException.class 对空指针不进行回滚。
     *
     * 注：要想事物生效必须在你调用的哪个方法上面有 @Transactional 注解才行。
     *
     * @param names
     */
    // springBoot 对事物控制。
    @Transactional(noRollbackFor = NullPointerException.class) // 使用事物。
    public void Things(String... names) throws NullPointerException {
        for (String name:names){
            String sql = " INSERT INTO user(username)VALUE ('"+name+"') ";
            jdbcTemplate.execute(sql);
            if("".equals("")){
                throw new NullPointerException();
            }
        }
    }

}
