package raisetech.StudentManagement;

import org.apache.ibatis.annotations.*;

@Mapper
public interface StudentRepository {

    @Select("SELECT * FROM student WHERE name =#{name}")
    Student searchByName(String name);

    @Insert("INSERT student values(#{name}, #{age})")
    void registerStudent(String name, int age);

    @Update("UPDATE student SET age = #{age} WHERE name = #{name}")
    void updateStudent(String name, int age);

    @Delete("DELETE FROM student WHERE name = #{name}")
    void deleteStudent(String name);
    //修正
}
