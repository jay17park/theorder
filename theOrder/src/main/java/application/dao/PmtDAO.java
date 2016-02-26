package application.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import application.vo.OrderVO;
import application.vo.PmtVO;
import application.vo.UserVO;

@Repository
public class PmtDAO {
	@Autowired
    private JdbcTemplate template;
 
    /**
     * 결제정보 insert
     * @param orderVO
     * @return
     */
    public int insertVO(PmtVO pmtVO) {
    	String query = "INSERT INTO PMT( ORDER_ID, PMT_AMT, PMT_USER_ID ) VALUES ( ?, ?, ? )";
        return template.update(query, pmtVO.getOrderId(),pmtVO.getPmtAmt(), pmtVO.getPmtUserId());
    }

}
