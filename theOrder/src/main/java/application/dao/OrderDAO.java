package application.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import application.vo.OrderVO;


@Repository
public class OrderDAO {
	@Autowired
    private JdbcTemplate template;
 
    /**
     * 주문정보 insert
     * @param orderVO
     * @return
     */
    public int insertVO(OrderVO orderVO) {
    	String query = "INSERT INTO ORDR( ORDER_NO, SHOP_ID, ORDER_USER_ID, ORDER_AMT_SUM, TOGO_YN) VALUES ( ?, ?, ?, ?, ?)";
        return template.update(query, orderVO.getOrderNo(),orderVO.getShopId(), orderVO.getOrderUserId(), orderVO.getOrderAmtSum(), orderVO.getTogoYn());
    }
    
    /**
     * 신규주문번호 생성
     * @return
     */
    public int getNewOrderNo() {
    	String query = "SELECT COUNT(1) + 1 AS ORDER_NO FROM ORDR WHERE ORDER_DT >= CURDATE()";
    	OrderVO orderVO = (OrderVO) template.query(query, new BeanPropertyRowMapper<OrderVO>(OrderVO.class)).get(0);
    	return orderVO.getOrderNo();
    }
    
    /**
     * 주문ID 조회
     * 
     * @param orderNo
     * @return
     */
    public int getOrderId(int orderNo, int shopId) {
    	
    	System.out.println(orderNo);
    	
    	String query = "SELECT ORDER_ID FROM ORDR WHERE ORDER_NO = ? AND ORDER_DT >= CURDATE() AND SHOP_ID = ?";
    	Integer result =  template.queryForObject(query, new Object[] {orderNo, shopId}, Integer.class);
    	if ( result != null ) {
    		return  result;
    	} else {
    		return 0;
    	}
    }

}
