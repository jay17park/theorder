package application.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import application.vo.ShopVO;
import application.vo.UserVO;

@Repository
public class ShopDAO {
	@Autowired
    private JdbcTemplate template;
 
    public List<ShopVO> selectRestOrder() {
        String query = "SELECT T1.SHOP_ID,COUNT(T2.ORDER_ID) AS ORDER_CNT, IFNULL(SUM(T3.ORDER_QTY), 0) AS TOTAL_QTY \n" + 
        			   "  FROM SHOP T1\n" + 
        			   "LEFT OUTER JOIN ORDR T2\n" + 
        			   "  ON T1.SHOP_ID = T2.SHOP_ID\n" +
        			   " AND T2.CMPL_YN = 'N'\n" +
        			   "LEFT OUTER JOIN ORDER_MENU_RLT T3\n" + 
        			   "  ON T2.ORDER_ID = T3.ORDER_ID\n" + 
        			   "WHERE 1=1\n" + 
        			   " GROUP BY T1.SHOP_ID  \n"
        			   ;
        return template.query(query, new BeanPropertyRowMapper(ShopVO.class));
    }

}
