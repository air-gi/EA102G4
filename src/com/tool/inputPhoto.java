package com.tool;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;

import com.individualClass.model.IndividualClassVO;
import com.license.model.LicenseJDBCDAO;
import com.license.model.LicenseVO;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class inputPhoto {

	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:XE";
	String userid = "INGYM";
	String passwd = "123456";

	private static final String UPDATE = "UPDATE LICENSE SET PRO_ID=?, LIC_NAME=?, NO_REG=?, L_PIC=? WHERE LICENSE_NO=?";
	private static final String UPDATEPIC = "UPDATE INDIVIDUAL_CLASS SET PRO_ID=?,C_TYPE_NO=? ,C_NAME=?,LOC=?,C_DETAIL=?,C_PIC=?,C_STATUS=?,P_COIN=? where I_CLASS_NO=?";

	public void update(LicenseVO licenseVO) {
		java.sql.Connection con = null;
		java.sql.PreparedStatement pstmt = null;

		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(UPDATE);

			pstmt.setString(1, licenseVO.getPro_ID());
			pstmt.setString(2, licenseVO.getLic_name());
			pstmt.setString(3, licenseVO.getNo_reg());
			pstmt.setBytes(4, licenseVO.getL_pic());
			pstmt.setString(5, licenseVO.getLicense_no());

			pstmt.executeUpdate();

			// testing
			System.out.println("Update successfully");

		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
	}

	public static void main(String args[]) throws IOException {
		LicenseJDBCDAO dao = new LicenseJDBCDAO();
		LicenseVO licenseVO = new LicenseVO();
		String url = "C:\\EA102G4_WebApp\\eclipse_WTP_EA102G4\\EA102G4\\WebContent\\front-end\\ProAndClass\\assets\\coachImg\\";

		// ??
		byte[] pic = null;
		licenseVO.setPro_ID("PRO1000000");
		licenseVO.setLic_name("???O?T??");
		licenseVO.setNo_reg("pow1000001");
		licenseVO.setLicense_no("LIC1000000");
		pic = getPictureByteArray(url + "lic1.jpeg");
		licenseVO.setL_pic(pic);
		dao.update(licenseVO);

		licenseVO.setPro_ID("PRO1000000");
		licenseVO.setLic_name("????C????");
		licenseVO.setNo_reg("pow1000002");
		licenseVO.setLicense_no("LIC1000001");
		pic = getPictureByteArray(url + "lic2.png");
		licenseVO.setL_pic(pic);
		dao.update(licenseVO);

		licenseVO.setPro_ID("PRO1000001");
		licenseVO.setLic_name("????????C?????a????");
		licenseVO.setNo_reg("pow1000003");
		licenseVO.setLicense_no("LIC1000002");
		pic = getPictureByteArray(url + "lic4.png");
		licenseVO.setL_pic(pic);
		dao.update(licenseVO);

		licenseVO.setPro_ID("PRO1000001");
		licenseVO.setLic_name("???Oc??????");
		licenseVO.setNo_reg("pow1000003");
		licenseVO.setLicense_no("LIC1000003");
		pic = getPictureByteArray(url + "lic6.jpg");
		licenseVO.setL_pic(pic);
		dao.update(licenseVO);

		licenseVO.setPro_ID("PRO1000001");
		licenseVO.setLic_name("???Oc??????");
		licenseVO.setNo_reg("pow1000003");
		licenseVO.setLicense_no("LIC1000004");
		pic = getPictureByteArray(url + "lic4.png");
		licenseVO.setL_pic(pic);
		dao.update(licenseVO);

		licenseVO.setPro_ID("PRO1000002");
		licenseVO.setLic_name("????a??");
		licenseVO.setNo_reg("pow1000003");
		licenseVO.setLicense_no("LIC1000005");
		pic = getPictureByteArray(url + "lic5.png");
		licenseVO.setL_pic(pic);
		dao.update(licenseVO);

		licenseVO.setPro_ID("PRO1000002");
		licenseVO.setLic_name("???A??");
		licenseVO.setNo_reg("pow1000006");
		licenseVO.setLicense_no("LIC1000005");
		pic = getPictureByteArray(url + "lic6.jpg");
		licenseVO.setL_pic(pic);
		dao.update(licenseVO);

		licenseVO.setPro_ID("PRO1000003");
		licenseVO.setLic_name("???A??");
		licenseVO.setNo_reg("pow1000007");
		licenseVO.setLicense_no("LIC1000006");
		pic = getPictureByteArray(url + "lic7.jpg");
		licenseVO.setL_pic(pic);
		dao.update(licenseVO);

		licenseVO.setPro_ID("PRO1000003");
		licenseVO.setLic_name("???O?T??");
		licenseVO.setNo_reg("pow1000008");
		licenseVO.setLicense_no("LIC1000007");
		pic = getPictureByteArray(url + "lic8.jpg");
		licenseVO.setL_pic(pic);
		dao.update(licenseVO);

		licenseVO.setPro_ID("PRO1000004");
		licenseVO.setLic_name("????");
		licenseVO.setNo_reg("pow1000009");
		licenseVO.setLicense_no("LIC1000008");
		pic = getPictureByteArray(url + "lic9.png");
		licenseVO.setL_pic(pic);
		dao.update(licenseVO);

		licenseVO.setPro_ID("PRO1000004");
		licenseVO.setLic_name("???O?T??");
		licenseVO.setNo_reg("pow1000010");
		licenseVO.setLicense_no("LIC1000009");
		pic = getPictureByteArray(url + "lic10.jpg");
		licenseVO.setL_pic(pic);
		dao.update(licenseVO);

		licenseVO.setPro_ID("PRO1000005");
		licenseVO.setLic_name("?]?B");
		licenseVO.setNo_reg("pow1000010");
		licenseVO.setLicense_no("LIC1000010");
		pic = getPictureByteArray(url + "lic1.jpeg");
		licenseVO.setL_pic(pic);
		dao.update(licenseVO);

		licenseVO.setPro_ID("PRO1000005");
		licenseVO.setLic_name("?k??");
		licenseVO.setNo_reg("pow1000011");
		licenseVO.setLicense_no("LIC1000011");
		pic = getPictureByteArray(url + "lic2.png");
		licenseVO.setL_pic(pic);
		dao.update(licenseVO);

		licenseVO.setPro_ID("PRO1000005");
		licenseVO.setLic_name("???R");
		licenseVO.setNo_reg("pow1000012");
		licenseVO.setLicense_no("LIC1000012");
		pic = getPictureByteArray(url + "lic4.png");
		licenseVO.setL_pic(pic);
		dao.update(licenseVO);

		inputPhoto dao1 = new inputPhoto();
		IndividualClassVO individualClassVO = new IndividualClassVO();

//??
		byte[] pic1 = null;
		pic1 = getPictureByteArray(url + "Class1.jpg");
		individualClassVO.setI_class_no("IC1000000");
		individualClassVO.setPro_ID("PRO1000000");
		individualClassVO.setC_type_no("CT001");
		individualClassVO.setC_pic(pic1);
		individualClassVO.setC_name("?|??????");
		individualClassVO.setLoc("???s?????s?????s?????s??????");
		individualClassVO.setC_detail("???O?`?????V?m?@??????????????????\r\n" + 
				"???@?O???????i?H?O?@?U?????A???w?h???k?h?A\r\n" + 
				"???F?????B?????O?B???????????P?A?]?i?H???K?B?????`?A\r\n" + 
				"?????k?k?????????q?F???A???B\r\n" + 
				"???T???V?m???????m???????i?H?[?t?????N???A???????q?A\r\n" + 
				"???U?U???B?????P?????????A???????J???????u???A\r\n" + 
				"?????n???A?C\r\n" + 
				"?[?j???@?O?B?B???O?B?z?o?O?A???C?B?????`\r\n" + 
				"???????????????s?A?R???U?N?C?T???@\r\n" + 
				"?????\???????A???C?h???B?W?[?????????N???v\r\n" + 
				"?U???Z???????A?????u???A???y?????u?????A\r\n" + 
				"?????????F???????P?B?????j????????','????????','?x?_???Q?s???????F??-???O??????");
		individualClassVO.setC_status(1);
		individualClassVO.setP_coin(1500);
		dao1.updatePIC(individualClassVO);
		
		pic1 = getPictureByteArray(url + "class2.jpg");
		individualClassVO.setI_class_no("IC1000001");
		individualClassVO.setPro_ID("PRO1000000");
		individualClassVO.setC_type_no("CT002");
		individualClassVO.setC_pic(pic1);
		individualClassVO.setC_name("???????{");
		individualClassVO.setLoc("???s?????s?????s?????s??????");
		individualClassVO.setC_detail("???O?`?????V?m?@??????????????????\r\n" + 
				"???@?O???????i?H?O?@?U?????A???w?h???k?h?A\r\n" + 
				"???F?????B?????O?B???????????P?A?]?i?H???K?B?????`?A\r\n" + 
				"?????k?k?????????q?F???A???B\r\n" + 
				"???T???V?m???????m???????i?H?[?t?????N???A???????q?A\r\n" + 
				"???U?U???B?????P?????????A???????J???????u???A\r\n" + 
				"?????n???A?C\r\n" + 
				"?[?j???@?O?B?B???O?B?z?o?O?A???C?B?????`\r\n" + 
				"???????????????s?A?R???U?N?C?T???@\r\n" + 
				"?????\???????A???C?h???B?W?[?????????N???v\r\n" + 
				"?U???Z???????A?????u???A???y?????u?????A\r\n" + 
				"?????????F???????P?B?????j????????','????????','?x?_???Q?s???????F??-???O??????");		individualClassVO.setC_status(1);
		individualClassVO.setP_coin(1500);
		dao1.updatePIC(individualClassVO);

		pic1 = getPictureByteArray(url + "class3.jpg");
		individualClassVO.setI_class_no("IC1000002");
		individualClassVO.setPro_ID("PRO1000001");
		individualClassVO.setC_type_no("CT001");
		individualClassVO.setC_pic(pic1);
		individualClassVO.setC_name("?`??????");
		individualClassVO.setLoc("?_???J?????K?[?E??????????????");
		individualClassVO.setC_detail("???O?`?????V?m?@??????????????????\r\n" + 
				"???@?O???????i?H?O?@?U?????A???w?h???k?h?A\r\n" + 
				"???F?????B?????O?B???????????P?A?]?i?H???K?B?????`?A\r\n" + 
				"?????k?k?????????q?F???A???B\r\n" + 
				"???T???V?m???????m???????i?H?[?t?????N???A???????q?A\r\n" + 
				"???U?U???B?????P?????????A???????J???????u???A\r\n" + 
				"?????n???A?C\r\n" + 
				"?[?j???@?O?B?B???O?B?z?o?O?A???C?B?????`\r\n" + 
				"???????????????s?A?R???U?N?C?T???@\r\n" + 
				"?????\???????A???C?h???B?W?[?????????N???v\r\n" + 
				"?U???Z???????A?????u???A???y?????u?????A\r\n" + 
				"?????????F???????P?B?????j????????','????????','?x?_???Q?s???????F??-???O??????");		individualClassVO.setC_status(1);
		individualClassVO.setP_coin(2500);
		dao1.updatePIC(individualClassVO);
		
		pic1 = getPictureByteArray(url + "class4.jpg");
		individualClassVO.setI_class_no("IC1000003");
		individualClassVO.setPro_ID("PRO1000001");
		individualClassVO.setC_type_no("CT002");
		individualClassVO.setC_pic(pic1);
		individualClassVO.setC_name("?W??????");
		individualClassVO.setLoc("?_???J?????K?[?E??????????????");
		individualClassVO.setC_detail("???O?`?????V?m?@??????????????????\r\n" + 
				"???@?O???????i?H?O?@?U?????A???w?h???k?h?A\r\n" + 
				"???F?????B?????O?B???????????P?A?]?i?H???K?B?????`?A\r\n" + 
				"?????k?k?????????q?F???A???B\r\n" + 
				"???T???V?m???????m???????i?H?[?t?????N???A???????q?A\r\n" + 
				"???U?U???B?????P?????????A???????J???????u???A\r\n" + 
				"?????n???A?C\r\n" + 
				"?[?j???@?O?B?B???O?B?z?o?O?A???C?B?????`\r\n" + 
				"???????????????s?A?R???U?N?C?T???@\r\n" + 
				"?????\???????A???C?h???B?W?[?????????N???v\r\n" + 
				"?U???Z???????A?????u???A???y?????u?????A\r\n" + 
				"?????????F???????P?B?????j????????','????????','?x?_???Q?s???????F??-???O??????");		individualClassVO.setC_status(1);
		individualClassVO.setP_coin(3000);
		dao1.updatePIC(individualClassVO);
		
		pic1 = getPictureByteArray(url + "class5.jpg");
		individualClassVO.setI_class_no("IC1000004");
		individualClassVO.setPro_ID("PRO1000001");
		individualClassVO.setC_type_no("CT003");
		individualClassVO.setC_pic(pic1);
		individualClassVO.setC_name("?W.???A??");
		individualClassVO.setLoc("?_???J?????K?[?E??????????????");
		individualClassVO.setC_detail("???O?`?????V?m?@??????????????????\r\n" + 
				"???@?O???????i?H?O?@?U?????A???w?h???k?h?A\r\n" + 
				"???F?????B?????O?B???????????P?A?]?i?H???K?B?????`?A\r\n" + 
				"?????k?k?????????q?F???A???B\r\n" + 
				"???T???V?m???????m???????i?H?[?t?????N???A???????q?A\r\n" + 
				"???U?U???B?????P?????????A???????J???????u???A\r\n" + 
				"?????n???A?C\r\n" + 
				"?[?j???@?O?B?B???O?B?z?o?O?A???C?B?????`\r\n" + 
				"???????????????s?A?R???U?N?C?T???@\r\n" + 
				"?????\???????A???C?h???B?W?[?????????N???v\r\n" + 
				"?U???Z???????A?????u???A???y?????u?????A\r\n" + 
				"?????????F???????P?B?????j????????','????????','?x?_???Q?s???????F??-???O??????");		individualClassVO.setC_status(1);
		individualClassVO.setP_coin(4999);
		dao1.updatePIC(individualClassVO);

		pic1 = getPictureByteArray(url + "class6.jpg");
		individualClassVO.setI_class_no("IC1000005");
		individualClassVO.setPro_ID("PRO1000002");
		individualClassVO.setC_type_no("CT003");
		individualClassVO.setC_pic(pic1);
		individualClassVO.setC_name("??????");
		individualClassVO.setLoc("?j?o?]???j?o?]???j?o?]??????");
		individualClassVO.setC_detail("???O?`?????V?m?@??????????????????\r\n" + 
				"???@?O???????i?H?O?@?U?????A???w?h???k?h?A\r\n" + 
				"???F?????B?????O?B???????????P?A?]?i?H???K?B?????`?A\r\n" + 
				"?????k?k?????????q?F???A???B\r\n" + 
				"???T???V?m???????m???????i?H?[?t?????N???A???????q?A\r\n" + 
				"???U?U???B?????P?????????A???????J???????u???A\r\n" + 
				"?????n???A?C\r\n" + 
				"?[?j???@?O?B?B???O?B?z?o?O?A???C?B?????`\r\n" + 
				"???????????????s?A?R???U?N?C?T???@\r\n" + 
				"?????\???????A???C?h???B?W?[?????????N???v\r\n" + 
				"?U???Z???????A?????u???A???y?????u?????A\r\n" + 
				"?????????F???????P?B?????j????????','????????','?x?_???Q?s???????F??-???O??????");		individualClassVO.setC_status(1);
		individualClassVO.setP_coin(1999);
		dao1.updatePIC(individualClassVO);
		
		pic1 = getPictureByteArray(url + "class7.jpg");
		individualClassVO.setI_class_no("IC1000006");
		individualClassVO.setPro_ID("PRO1000002");
		individualClassVO.setC_type_no("CT004");
		individualClassVO.setC_pic(pic1);
		individualClassVO.setC_name("????????");
		individualClassVO.setLoc("?j?o?]???j?o?]???j?o?]??????");
		individualClassVO.setC_detail("???O?`?????V?m?@??????????????????\r\n" + 
				"???@?O???????i?H?O?@?U?????A???w?h???k?h?A\r\n" + 
				"???F?????B?????O?B???????????P?A?]?i?H???K?B?????`?A\r\n" + 
				"?????k?k?????????q?F???A???B\r\n" + 
				"???T???V?m???????m???????i?H?[?t?????N???A???????q?A\r\n" + 
				"???U?U???B?????P?????????A???????J???????u???A\r\n" + 
				"?????n???A?C\r\n" + 
				"?[?j???@?O?B?B???O?B?z?o?O?A???C?B?????`\r\n" + 
				"???????????????s?A?R???U?N?C?T???@\r\n" + 
				"?????\???????A???C?h???B?W?[?????????N???v\r\n" + 
				"?U???Z???????A?????u???A???y?????u?????A\r\n" + 
				"?????????F???????P?B?????j????????','????????','?x?_???Q?s???????F??-???O??????");		individualClassVO.setC_status(1);
		individualClassVO.setP_coin(2500);
		dao1.updatePIC(individualClassVO);
		
		pic1 = getPictureByteArray(url + "class8.jpg");
		individualClassVO.setI_class_no("IC1000007");
		individualClassVO.setPro_ID("PRO1000003");
		individualClassVO.setC_type_no("CT004");
		individualClassVO.setC_pic(pic1);
		individualClassVO.setC_name("?T??????");
		individualClassVO.setLoc("?????s????????????");
		individualClassVO.setC_detail("???O?`?????V?m?@??????????????????\r\n" + 
				"???@?O???????i?H?O?@?U?????A???w?h???k?h?A\r\n" + 
				"???F?????B?????O?B???????????P?A?]?i?H???K?B?????`?A\r\n" + 
				"?????k?k?????????q?F???A???B\r\n" + 
				"???T???V?m???????m???????i?H?[?t?????N???A???????q?A\r\n" + 
				"???U?U???B?????P?????????A???????J???????u???A\r\n" + 
				"?????n???A?C\r\n" + 
				"?[?j???@?O?B?B???O?B?z?o?O?A???C?B?????`\r\n" + 
				"???????????????s?A?R???U?N?C?T???@\r\n" + 
				"?????\???????A???C?h???B?W?[?????????N???v\r\n" + 
				"?U???Z???????A?????u???A???y?????u?????A\r\n" + 
				"?????????F???????P?B?????j????????','????????','?x?_???Q?s???????F??-???O??????");		individualClassVO.setC_status(1);
		individualClassVO.setP_coin(1600);
		dao1.updatePIC(individualClassVO);
		
		pic1 = getPictureByteArray(url + "class9.jpg");
		individualClassVO.setI_class_no("IC1000008");
		individualClassVO.setPro_ID("PRO1000003");
		individualClassVO.setC_type_no("CT004");
		individualClassVO.setC_pic(pic1);
		individualClassVO.setC_name("?w?|????");
		individualClassVO.setLoc("?????s????????????");
		individualClassVO.setC_detail("???O?`?????V?m?@??????????????????\r\n" + 
				"???@?O???????i?H?O?@?U?????A???w?h???k?h?A\r\n" + 
				"???F?????B?????O?B???????????P?A?]?i?H???K?B?????`?A\r\n" + 
				"?????k?k?????????q?F???A???B\r\n" + 
				"???T???V?m???????m???????i?H?[?t?????N???A???????q?A\r\n" + 
				"???U?U???B?????P?????????A???????J???????u???A\r\n" + 
				"?????n???A?C\r\n" + 
				"?[?j???@?O?B?B???O?B?z?o?O?A???C?B?????`\r\n" + 
				"???????????????s?A?R???U?N?C?T???@\r\n" + 
				"?????\???????A???C?h???B?W?[?????????N???v\r\n" + 
				"?U???Z???????A?????u???A???y?????u?????A\r\n" + 
				"?????????F???????P?B?????j????????','????????','?x?_???Q?s???????F??-???O??????");		individualClassVO.setC_status(1);
		individualClassVO.setP_coin(1700);
		dao1.updatePIC(individualClassVO);
		
		pic1 = getPictureByteArray(url + "class10.jpg");
		individualClassVO.setI_class_no("IC1000009");
		individualClassVO.setPro_ID("PRO1000004");
		individualClassVO.setC_type_no("CT004");
		individualClassVO.setC_pic(pic1);
		individualClassVO.setC_name("????????");
		individualClassVO.setLoc("??????????????");
		individualClassVO.setC_detail("???O?`?????V?m?@??????????????????\r\n" + 
				"???@?O???????i?H?O?@?U?????A???w?h???k?h?A\r\n" + 
				"???F?????B?????O?B???????????P?A?]?i?H???K?B?????`?A\r\n" + 
				"?????k?k?????????q?F???A???B\r\n" + 
				"???T???V?m???????m???????i?H?[?t?????N???A???????q?A\r\n" + 
				"???U?U???B?????P?????????A???????J???????u???A\r\n" + 
				"?????n???A?C\r\n" + 
				"?[?j???@?O?B?B???O?B?z?o?O?A???C?B?????`\r\n" + 
				"???????????????s?A?R???U?N?C?T???@\r\n" + 
				"?????\???????A???C?h???B?W?[?????????N???v\r\n" + 
				"?U???Z???????A?????u???A???y?????u?????A\r\n" + 
				"?????????F???????P?B?????j????????','????????','?x?_???Q?s???????F??-???O??????");		individualClassVO.setC_status(1);
		individualClassVO.setP_coin(1520);
		dao1.updatePIC(individualClassVO);
		
		pic1 = getPictureByteArray(url + "class1.jpg");
		individualClassVO.setI_class_no("IC1000010");
		individualClassVO.setPro_ID("PRO1000004");
		individualClassVO.setC_type_no("CT004");
		individualClassVO.setC_pic(pic1);
		individualClassVO.setC_name("????POSING");
		individualClassVO.setLoc("??????????????");
		individualClassVO.setC_detail("???O?`?????V?m?@??????????????????\r\n" + 
				"???@?O???????i?H?O?@?U?????A???w?h???k?h?A\r\n" + 
				"???F?????B?????O?B???????????P?A?]?i?H???K?B?????`?A\r\n" + 
				"?????k?k?????????q?F???A???B\r\n" + 
				"???T???V?m???????m???????i?H?[?t?????N???A???????q?A\r\n" + 
				"???U?U???B?????P?????????A???????J???????u???A\r\n" + 
				"?????n???A?C\r\n" + 
				"?[?j???@?O?B?B???O?B?z?o?O?A???C?B?????`\r\n" + 
				"???????????????s?A?R???U?N?C?T???@\r\n" + 
				"?????\???????A???C?h???B?W?[?????????N???v\r\n" + 
				"?U???Z???????A?????u???A???y?????u?????A\r\n" + 
				"?????????F???????P?B?????j????????','????????','?x?_???Q?s???????F??-???O??????");		individualClassVO.setC_status(1);
		individualClassVO.setP_coin(1900);
		dao1.updatePIC(individualClassVO);
	}

	public static byte[] getPictureByteArray(String path) throws IOException {
		File file = new File(path);
		FileInputStream fis = new FileInputStream(file);
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		byte[] buffer = new byte[8192];
		int i;
		while ((i = fis.read(buffer)) != -1) {
			baos.write(buffer, 0, i);
		}
		baos.close();
		fis.close();

		return baos.toByteArray();
	}

	public void updatePIC(IndividualClassVO individualClassVO) {
		java.sql.Connection con = null;
		java.sql.PreparedStatement pstmt = null;

		try {
//			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(UPDATEPIC);

			pstmt.setString(1, individualClassVO.getPro_ID());
			pstmt.setString(2, individualClassVO.getC_type_no());
			pstmt.setString(3, individualClassVO.getC_name());
			pstmt.setString(4, individualClassVO.getLoc());
			pstmt.setString(5, individualClassVO.getC_detail());
			pstmt.setBytes(6, individualClassVO.getC_pic());
			pstmt.setInt(7, individualClassVO.getC_status());
			pstmt.setInt(8, individualClassVO.getP_coin());
			pstmt.setString(9, individualClassVO.getI_class_no());

			pstmt.executeUpdate();

			System.out.println("Update successfully"); // testing

//		} catch (ClassNotFoundException e) {
//			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
	}

}