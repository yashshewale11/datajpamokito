package com.csi.dao.test;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;





import com.csi.dao.EmployeeDaoImpl;
import com.csi.model.Employee;
import com.csi.repo.EmployeeRepo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootTest
@RunWith(SpringRunner.class)
public class EmployeeDaoImplTest {

    @Autowired
    EmployeeDaoImpl employeeDaoImpl;

    @MockBean
    EmployeeRepo employeeRepoImpl;

    @Test

    public void getAllDataTest(){

        when(employeeRepoImpl.findAll()).thenReturn((List<Employee>) Stream.of(new Employee(101,"Yash",551151.23,"Nashik"),new Employee(102,"Rushi",652351.23,"Pune"),new Employee(103,"Akash",820036.323,"Igatpuri")).collect(Collectors.toList()));

        assertEquals(3,employeeDaoImpl.getAllData().size());

    }

    @Test
    public void saveDataTest(){

        Employee employee=new Employee(101,"Yash",551151.23,"Nashik");
        employeeDaoImpl.saveData(employee);

        verify(employeeRepoImpl,times(1)).save(employee);
    }

    @Test
    public void updateDataTest(){

        Employee employee=new Employee(101,"Yash",551151.23,"Nashik");
        employeeDaoImpl.updateData(employee);

        verify(employeeRepoImpl,times(1)).save(employee);
    }

    @Test
    public void deleteDataByIdTest(){

        Employee employee=new Employee(101,"Yash",551151.23,"Nashik");
        employeeDaoImpl.deleteDataById(employee.getEmpId());

        verify(employeeRepoImpl,times(1)).deleteById(employee.getEmpId());
    }


}
