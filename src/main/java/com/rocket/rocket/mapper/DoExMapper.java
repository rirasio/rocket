package com.rocket.rocket.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.rocket.rocket.domain.Criteria;
import com.rocket.rocket.domain.DoExDTO;
import com.rocket.rocket.domain.DoExVO;
import com.rocket.rocket.domain.DoHwDTO;
import com.rocket.rocket.domain.DoHwVO;

public interface DoExMapper {

	@Insert("insert into doex values (seq_doex.nextval, #{content}, #{score}, #{ex_num}, #{email})")
	public void insert(DoExVO doex);

	@Select("select doex.*, users.nickname from doex, users where doex.email = users.email and num = #{num}")
	@ResultType(DoExDTO.class)
	public DoExDTO select(long num);

	@Update("update doex set content = #{content}, score = #{score} where num = #{num}")
	public int update(DoExVO doex);

	@Delete("delete from doex where num = #{num}")
	public int delete(long num);

//	@Select("select * from (select rownum rn, dohw.* from dohw where hw_num = #{hw_num}) where rn BETWEEN ((#{cri.pageNum} - 1) * #{cri.amount}	+ 1) and #{cri.pageNum} * #{cri.amount}")
	@Select("select doex.*, users.nickname from doex, users where doex.email = users.email and ex_num = #{ex_num}")
	@ResultType(DoExDTO.class)
	public List<DoExDTO> readList(long ex_num);

}
