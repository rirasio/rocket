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
	@Insert("insert into sub values (num.nextval, #{title}, #{content}, 1, 1, #{num})")
	public void insert(NoticeVO noticevo);

	@Select("select * from sub where num = #{num}")
	@ResultType(NoticeVO.class)
	public NoticeVO select(long num);

	@Update("update notice set title = #{title}, content = #{content} where num = #{num}")
	public int update(NoticeVO noticevo);

	@Delete("delete from notice where num = #{num}")
	public int delete(long num);

	@Select("select * from notice order by num acs")
	public List<NoticeVO> getList();
}
