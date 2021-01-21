package com.htl.generator.service.impl;

import com.htl.generator.entity.Account;
import com.htl.generator.mapper.AccountMapper;
import com.htl.generator.service.AccountService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Hantianle
 * @since 2020-12-22
 */
@Service
public class AccountServiceImpl extends ServiceImpl<AccountMapper, Account> implements AccountService {

}
