package application.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import application.vo.OrderVO;
import application.vo.UserVO;

@Repository
public class UserDAO {
	@Autowired
    private JdbcTemplate template;
    public UserVO selectUser(UserVO userVO) {
        String query = "SELECT COUNT(*) AS CNT, USER_ID, USER_REG_ID, USER_NM FROM USER\n"
        			 + " WHERE USER_ID = ?"
        			 + "   AND PASSWORD = ?";
        return (UserVO) template.queryForObject(query, new Object[] {userVO.getUserId(), userVO.getPassword()}, new BeanPropertyRowMapper(UserVO.class));
    }
    public int updateUserRegId(UserVO userVO) {
    	String query = "UPDATE USER SET USER_REG_ID = ?"
    				 + " WHERE USER_ID = ?";
    	return template.update(query, userVO.getUserRegId(),userVO.getUserId());
    }

}
