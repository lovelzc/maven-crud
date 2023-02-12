import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lzc.crud.entity.Dept;
import com.lzc.crud.entity.Emp;
import com.lzc.crud.mapper.DeptMapper;
import com.lzc.crud.mapper.EmpMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@SpringJUnitConfig(locations = "classpath:spring-persist.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class TestJDBC {

    @Autowired
    private DeptMapper deptMapper;

    @Autowired
    private EmpMapper empMapper;
    @Autowired
    private SqlSession session;

    @Test
    public void  testAddDept() {
        deptMapper.insertSelective(new Dept(null,"开发部"));
        deptMapper.insertSelective(new Dept(null,"测试部"));
    }

    @Test
    public void testPatch(){
        PageHelper.startPage(1, 4);
        List<Emp> emps = empMapper.selectByExample(null);
        PageInfo<Emp> pageInfo = new PageInfo<>(emps);
        System.out.println("pageInfo = " + pageInfo);

    }
}
