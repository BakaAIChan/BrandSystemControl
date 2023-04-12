package Mapper;

import Domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {
    User selectOneUser(User user);
    User selectByUsername(User user);
    void add(User user);
}
