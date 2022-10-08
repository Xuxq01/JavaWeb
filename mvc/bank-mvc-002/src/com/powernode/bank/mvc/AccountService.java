package com.powernode.bank.mvc;

import com.powernode.bank.exceptions.AppException;
import com.powernode.bank.exceptions.MoneyNotEnoughException;

/**
 * service翻译为：业务。
 * AccountService：专门处理Account业务的一个类。
 * 在该类中应该编写纯业务代码。（只专注业务。不写别的。不和其他代码混合在一块。）
 * 只希望专注业务，能够将业务完美实现，少量bug。
 *
 * 业务类一般起名：XxxService、XxxBiz.....
 */
public class AccountService {

    // 为什么定义到这里？因为在每一个业务方法中都可以需要连接数据库。
    private AccountDao accountDao = new AccountDao();

    // 这里的方法起名，一定要体现出，你要处理的是什么业务。
    // 我们要提供一个能够实现转账的业务方法（一个业务对应一个方法。）

    /**
     * 完成转账的业务逻辑
     * @param fromActno 转出账号
     * @param toActno 转入账号
     * @param money 转账金额
     */
    public void transfer(String fromActno, String toActno, double money) throws MoneyNotEnoughException, AppException {
        // 查询余额是否充足
        Account fromAct = accountDao.selectByActno(fromActno);
        if (fromAct.getBalance() < money) {
            throw new MoneyNotEnoughException("对不起，余额不足");
        }
        // 程序到这里说明余额充足
        Account toAct = accountDao.selectByActno(toActno);
        // 修改余额（只是修改了内存中java对象的余额）
        fromAct.setBalance(fromAct.getBalance() - money);
        toAct.setBalance(toAct.getBalance() + money);
        // 更新数据库中的余额
        int count = accountDao.update(fromAct);

        // 模拟异常
        String s = null;
        s.toString();

        count += accountDao.update(toAct);
        if (count != 2) {
            throw new AppException("账户转账异常！！！");
        }
    }

}

