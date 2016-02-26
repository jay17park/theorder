package application.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import application.vo.UserVO;
import application.vo.WatingVO;

@Repository
public class WatingDAO {
	@Autowired
    private JdbcTemplate template;
 
    public int insert(UserVO user) {
    	String query = "INSERT INTO USER(USER_ID, PASSWORD, USER_NM) VALUES(?, ?, ?)";
        return template.update(query, user.getUserId(), user.getPassword(), user.getUserNm());
    }
    
    public List<WatingVO> selectWaitingUserInfo(String orderUserId){
    	String query = "SELECT ORDER_ID\n" + 
				     ",ORDER_NO\n" + 
				     ",SHOP_ID\n" +  
				     ",ORDER_DT\n" + 
					 "FROM ORDR\n" +  
					 "WHERE ORDER_USER_ID = ?\n" + 
					 "AND CMPL_YN = 'N'";

    	return template.query(query, new Object[] {orderUserId}, new BeanPropertyRowMapper(WatingVO.class));
    }
    
    
    
    public List<WatingVO> selectWaitingInfo(WatingVO inWatingVO) {
        String query = "SELECT\n "
	        		+ "(SELECT COUNT(*) FROM ORDR Z1 WHERE Z1.ORDER_DT < ? AND CMPL_YN='N' AND Z1.ORDER_DT >= CURDATE()) AS ORDER_SNT\n"
	        		+ ",A1.ORDER_NO\n"
	        		+ ",(SELECT SUM(Z2.ORDER_QTY) FROM ORDER_MENU_RLT Z2 WHERE A2.ORDER_ID = Z2.ORDER_ID) AS ORDER_QTY_ALL\n"
	        		+ ",A2.ORDER_QTY\n"
	        		+ ",A3.MENU_NM\n"
	        		+ ",A3.ICE_OPT_USE_YN\n"
	        		+ ",A3.SHOT_OPT_USE_YN\n"
	        		+ ",A1.ORDER_DT\n"
	        		+ ",A4.SHOP_NM\n"
	        		+ ",A2.ICE_OPT\n"
	        		+ ",A2.SHOT_OPT\n"
	        		+ ",CASE WHEN A2.ICE_OPT = '1' THEN '얼음많이' WHEN A2.ICE_OPT = '2' THEN '얼음적게' ELSE '기본' END AS ICE_OPT_NM\n"
	        		+ ",CASE WHEN A2.SHOT_OPT = 'Y' THEN '샷추가' ELSE '기본' END AS SHOT_OPT_NM\n"
	        		+ "FROM ORDR A1\n"
	        		+ "INNER JOIN ORDER_MENU_RLT A2\n"
	        		+ "ON A2.ORDER_ID = A1.ORDER_ID\n"
	        		+ "INNER JOIN MENU A3\n"
	        		+ "ON A3.MENU_ID = A2.MENU_ID\n"
	        		+ "INNER JOIN SHOP A4\n"
	        		+ "ON A4.SHOP_ID = A1.SHOP_ID\n"
	        		+ "WHERE A1.ORDER_ID = ?\n"
	        		+ "AND A1.ORDER_DT = ?\n"
	        		+ "GROUP BY A3.MENU_NM, A2.ICE_OPT, A2.SHOT_OPT\n"
	        		+ "ORDER BY A3.SHOW_NO\n"
	        		;

        return template.query(query, new Object[] {inWatingVO.getOrderDt(), inWatingVO.getOrderId(), inWatingVO.getOrderDt()}, new BeanPropertyRowMapper(WatingVO.class));
    }

}
