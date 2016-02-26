package application.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import application.vo.AdminOrderVO;
import application.vo.PmtVO;
import application.vo.UserVO;

@Repository
public class AdminDAO {
	@Autowired
    private JdbcTemplate template;
    
    public List<AdminOrderVO> getOrderList(String shopId) {
		String query ="SELECT	A1.ORDER_NO, "
					+"A4.USER_ID, "
					+"A4.USER_NM, "
					+"A3.MENU_NM, "
					+"CASE WHEN A2.ICE_OPT = '1' THEN '얼음많이' "
					+"ELSE CASE WHEN A2.ICE_OPT = '2' THEN '얼음적게' "
					+"ELSE '' "
					+"END END ICE_OPT, "
					+"CASE WHEN A2.SHOT_OPT = 'Y' THEN '샷추가' "
					+"ELSE '' "
					+"END SHOT_OPT, "
					+"A2.ORDER_QTY, "
					+"A2.ORDER_AMT, "
					+"A1.ORDER_AMT_SUM "
					+"FROM		ORDR A1 "
					+"INNER JOIN ORDER_MENU_RLT A2 " 
					+"ON			A1.ORDER_ID = A2.ORDER_ID "
					+"INNER JOIN MENU A3 "
					+"ON			A2.MENU_ID = A3.MENU_ID "
					+"INNER JOIN USER A4 "
					+"ON			A1.ORDER_USER_ID = A4.USER_ID "
					+"WHERE		1=1 "
					+"AND		A1.CMPL_YN <> 'Y' "
					+"AND		A1.SHOP_ID = ?   /* 입력 */ "
					+"AND		A1.ORDER_DT >= CURDATE() "
					+"ORDER BY A1.ORDER_ID, A3.SHOW_NO";
		return template.query(query, new Object[] {shopId}, new BeanPropertyRowMapper<AdminOrderVO>(AdminOrderVO.class));
    }
    
    /**
     * 주문 완료 처리
     * @param orderVO
     * @return
     */
    public int updateVO(int orderNo) {
    	String query = "UPDATE ORDR SET CMPL_YN = 'Y' WHERE ORDER_NO = ?";
        return template.update(query, orderNo);
    }
    
    public String selectUser(int orderId) {
        String query = "SELECT	USER_REG_ID\n"
        			 + "FROM		ORDR A1\n"
        			 + "INNER JOIN USER A2\n"
        			 + "ON 		A1.ORDER_USER_ID = A2.USER_ID\n"
        			 + "WHERE		1=1\n"
        			 + "AND		A1.ORDER_ID = ?";
        UserVO vo = (UserVO) template.queryForObject(query, new Object[] {orderId}, new BeanPropertyRowMapper(UserVO.class));
        return vo.getUserRegId();
    }
}
