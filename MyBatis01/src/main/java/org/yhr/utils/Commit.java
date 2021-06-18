package org.yhr.utils;

import org.apache.ibatis.session.SqlSession;

/**
 * 事务提交
 */
public interface Commit {

    void commit(SqlSession sqlSession);

}
