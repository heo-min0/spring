package main;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import dto.BbsDto;
import dto.BbsParam;
import dto.MemberDto;

public class MainClass {

	public static void main(String[] args) throws Exception {
		//mybatis 설정파일을 읽어들인다
		InputStream is = Resources.getResourceAsStream("mybatis/config.xml");
		
		//SqlSessionFactory 객체를 취득
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
		
		//쿠키는 문자열만 저장 섹션은 오브젝트 저장 섹션은 서버마다 있다
		//DB의 섹션에 접근
		//SqlSession 객체를 취득
		SqlSession session = factory.openSession(); // session 실세 
		
		//MemberDto dto = new MemberDto("aaa", "111", "a1@a");
		//MemberDto dto = new MemberDto("bbb", "222", "b1@b");
		//MemberDto dto = new MemberDto("ccc", "333", "c1@c");
		
		/*
		int n = session.insert("add", dto);
		if(n>0) {
			session.commit();
			System.out.println("추가 성공");
		}else {
			session.rollback();
			System.out.println("추가 실패");
		}*/
		
		
		//delete
		/*
		String id = "ccc"
		int d = session.delete("del", new MemberDto(id,"",""));
		int d = session.delete("del", "ccc");
		if(d>0) {
			session.commit();
			System.out.println("삭제 성공");
		}else {
			session.rollback();
			System.out.println("삭제 실패");
		}*/
		
		//update
		/*MemberDto dto = new MemberDto("bbb", "222", "b2@b");
		int d = session.update("upd", dto);
		if(d>0) {
			session.commit();
			System.out.println("추가 성공");
		}else {
			session.rollback();
			System.out.println("추가 실패");
		}*/
		
		//select
		/*String id = "bbb";
		MemberDto dto = session.selectOne("find", id);
		System.out.println(dto.toString());*/
		
		/*List<MemberDto> list = session.selectList("allData");
		for (MemberDto m : list) {
			System.out.println(m.toString());
		}*/
		
		//BBS select
		/*BbsParam param = new BbsParam("title", "0");
		List<BbsDto> list = session.selectList("bbsSearch", param);
		for (BbsDto bbs : list) {
			System.out.println(bbs.toString());
		}*/
		
		String a = session.selectOne("getmember","aaa");
		System.out.println("rhkdus:"+a);
		
	}

}
