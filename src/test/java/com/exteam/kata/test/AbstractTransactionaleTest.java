package com.exteam.kata.test;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.exteam.kata.AppConf;

/**
 * The Class AbstractTransactionaleTest.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { AppConf.class })
public abstract class AbstractTransactionaleTest extends AbstractTransactionalJUnit4SpringContextTests {
}
