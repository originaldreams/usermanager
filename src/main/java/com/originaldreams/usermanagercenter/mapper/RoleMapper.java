package com.originaldreams.usermanagercenter.mapper;

import com.originaldreams.usermanagercenter.entity.Role;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import java.util.List;

@Mapper
public interface RoleMapper {
    String tableName = "role";


     @Select("SELECT id, name, description, createTime FROM " + tableName + " WHERE id = #{id}")
     Role getById(Integer Id);

     @Select("SELECT id, name, description, createTime FROM " + tableName)
     List<Role> getAll();

     @Insert("INSERT INTO " + tableName + "(id, name, description, createTime) VALUES (#{id}, #{name}, #{description}, #{createTime})")
     Integer insert(Role role);

     @Delete("DELETE FROM " + tableName + " WHERE id = #{id}")
     Integer deleteById(Integer id);
     @Update("UPDATE " + tableName + " SET name=#{name}, description=#{description}, createTime=#{createTime} WHERE id = #{id}")
     Integer update(Role role);


}