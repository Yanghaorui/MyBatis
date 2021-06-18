package org.yhr.utils;

/**
 * 执行Mapper里的方法
 * 不用每次都去openSession，提高代码利用率
 *
 * @param <T> Mapper接口
 */
public interface ExeMapper <T>{

    void exe(T t);
}
