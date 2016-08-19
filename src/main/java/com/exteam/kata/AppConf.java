package com.exteam.kata;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({ "com.exteam.kata,com", "com.exteam.kata.test"})
public class AppConf {
}
