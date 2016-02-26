package application.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import application.vo.MenuVO;
import application.vo.UserVO;

@Repository
public class MenuDAO {
	@Autowired
    private JdbcTemplate template;
 
    public List<MenuVO> select() {
        String query = "SELECT * FROM MENU ORDER BY SHOW_NO";
        return template.query(query, new BeanPropertyRowMapper(MenuVO.class));
    }

}
