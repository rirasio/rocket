package com.rocket.rocket.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.rocket.rocket.domain.NoticeVO;
import com.rocket.rocket.domain.SubVO;

public interface NoticeMapper {
	@Insert("insert into notice (num,title,content,regdate,modidate,email) values (seq_notice.nextval, #{title}, #{content}, sysdate, sysdate, 'qqruqq@naver.com')") // 서비스에서
	public void insert(NoticeVO noticevo);

	@Select("select * from notice where num = #{num}")
	@ResultType(NoticeVO.class)
	public NoticeVO select(long num);

	@Update("update notice set title = #{title}, content = #{content}, modidate = sysdate where num = #{num}")
	public int update(NoticeVO noticevo);
	
	@Update("update notice set deldate = sysdate where num = #{num}")
	public int delete(long num);

	
//	@Delete("delete from notice where num = #{num}")
//	public int delete(long num);

	
	@Select("select * from notice where email = #{email} ")
	public List<NoticeVO> getList(String email); // 한 선생님의 리스트 전체 데려오기

	@Select("select * from (select from users)where nickName = #{nickName}  ")
	public List<NoticeVO> getListbyNickname22(String nickName); // 한 선생님의 리스트 전체 데려오기
}
