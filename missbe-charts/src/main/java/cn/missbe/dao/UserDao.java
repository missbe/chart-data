package cn.missbe.dao;

import java.util.List;

public interface UserDao<T> {
     T getUser(String username,String password);
     List<T> find(String hql , Object... params);
}
