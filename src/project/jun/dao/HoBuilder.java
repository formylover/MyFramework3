package project.jun.dao;import org.apache.ibatis.jdbc.SelectBuilder;import org.apache.ibatis.jdbc.SqlBuilder;public class HoBuilder {	private String selectSql() {		SelectBuilder.BEGIN(); // Clears ThreadLocal variable		SelectBuilder.SELECT("P.ID, P.USERNAME, P.PASSWORD, P.FULL_NAME");		SelectBuilder.SELECT("P.LAST_NAME, P.CREATED_ON, P.UPDATED_ON");		SelectBuilder.FROM("PERSON P");		SelectBuilder.FROM("ACCOUNT A");		SelectBuilder.INNER_JOIN("DEPARTMENT D on D.ID = P.DEPARTMENT_ID");		SelectBuilder.INNER_JOIN("COMPANY C on D.COMPANY_ID = C.ID");		SelectBuilder.WHERE("P.ID = A.ID");		SelectBuilder.WHERE("P.FIRST_NAME like ?");		SelectBuilder.OR();		SelectBuilder.WHERE("P.LAST_NAME like ?");		SelectBuilder.GROUP_BY("P.ID");		SelectBuilder.HAVING("P.LAST_NAME like ?");		SelectBuilder.OR();		SelectBuilder.HAVING("P.FIRST_NAME like ?");		SelectBuilder.ORDER_BY("P.ID");		SelectBuilder.ORDER_BY("P.FULL_NAME");		return SelectBuilder.SQL();	}		public static void main(String [] args) {		HoBuilder bulider = new HoBuilder();				// System.out.println( bulider.selectSql() );	}}