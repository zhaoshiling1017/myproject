package models.proc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

import play.db.DB;


public class ExcuProc {
	public static void executeProcedure(){
		String sql = "call simpleproc(?)";
		try{
			CallableStatement callableStatement = DB.getConnection().prepareCall(sql);
			//callableStatement.setInt(1, 1); //设置输入参数
			callableStatement.registerOutParameter(1, Types.INTEGER);//设置输出参数
			callableStatement.execute();//执行存储过程
			System.out.println(callableStatement.getInt(1));
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public static boolean createBussinKinds(String ywbh, String ywmc, String ywbz) {
		Connection con = null;
		CallableStatement  ps = null;
		int insertResult = 0;
		try {
			con = DB.getConnection();
			con.setAutoCommit(false);
			ps = con.prepareCall(" call ps_isa_ywxx_insert(?,?,?,?)");
			ps.setString(1, ywbh);
			ps.setString(2, ywmc);
			ps.setString(3, ywbz);
		    ps.registerOutParameter(4, Types.INTEGER) ;
		    ps.execute() ;
			insertResult = ps.getInt(4);
			System.out.println("BBBBBBBBBBBBBBBBBBBB"+insertResult);
			if (insertResult > 0) {
				System.out.println("执行添加操作 操作数据库成功！");
				return true;
			}

		} catch (SQLException e) {
		  e.printStackTrace();
		} finally {
			try{
				ps.close();
				con.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return false;
	}
}
