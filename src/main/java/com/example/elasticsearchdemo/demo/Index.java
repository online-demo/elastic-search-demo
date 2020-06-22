package com.example.elasticsearchdemo.demo;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author zhouguanya
 * @version Id: Index.java, v 0.1  2020/6/22 zhouguanya Exp $$
 */
@AllArgsConstructor
@Getter
public enum Index {
    /**
     * 测试索引
     */
    TEST("test", "测试索引");
    private String name;
    private String desc;
}
