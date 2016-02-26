package application.dao;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import application.vo.OrderMenuRltVO;
import application.vo.OrderVO;

@Repository
public class OrderMenuRltDAO {
	@Autowired
	private JdbcTemplate template;

	public int[] insert(List<OrderMenuRltVO> orderMenuRltVOList) {
		String query = "INSERT INTO ORDER_MENU_RLT(ORDER_ID, MENU_ID, ORDER_QTY, ORDER_AMT, ICE_OPT, SHOT_OPT) VALUES(?, ?, ?, "
				+ "(SELECT MENU_AMT FROM MENU WHERE MENU_ID = ?) * ?, ?, ?)";
		// INSERT INTO ORDER_MENU_RLT(ORDER_ID, MENU_ID, ORDER_QTY, ORDER_AMT, ICE_OPT, SHOT_OPT) VALUES(1, 1, 1, 1500, "1", "Y")
		
		return template.batchUpdate(query, new BatchPreparedStatementSetter() {

			public int getBatchSize() {
				return orderMenuRltVOList.size();
			}

			@Override
			public void setValues(java.sql.PreparedStatement ps, int i)
					throws SQLException {
				ps.setInt(1, orderMenuRltVOList.get(i).getOrderId());
				ps.setInt(2, orderMenuRltVOList.get(i).getMenuId());
				ps.setInt(3, orderMenuRltVOList.get(i).getOrderQty());
				ps.setInt(4, orderMenuRltVOList.get(i).getMenuId());
				ps.setInt(5, orderMenuRltVOList.get(i).getOrderQty());
				ps.setString(6, orderMenuRltVOList.get(i).getIceOpt());
				ps.setString(7, orderMenuRltVOList.get(i).getShotOpt());
			}
		});
	}

	public int getNewOrderId() {
		String query = "SELECT IFNULL(MAX(ORDER_ID) + 1, 1) AS ORDER_ID FROM ORDR";
		
		OrderVO orderVO = (OrderVO) template.query(query, new BeanPropertyRowMapper(OrderVO.class)).get(0);
		
		return orderVO.getOrderId();
	}
}
