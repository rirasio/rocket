package com.rocket.rocket.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.rocket.rocket.domain.Criteria;
import com.rocket.rocket.domain.DoHwVO;

public interface DoHwMapper {

	@Insert("insert into dohw values (seq_dohw.nextval, sysdate, sysdate, 1, 1, 1, #{user_num}, #{hw_num})")
	public void insert(DoHwVO doHwVO);

	@Select("select * from dohw where num = #{num}")
	@ResultType(DoHwVO.class)
	public DoHwVO select(long num);

	@Update("update dohw set modidate = sysdate, fileName = 'updatedName', fileType = 0, filePath = 'updatedPath' where num = #{num}")
	public int update(DoHwVO dohwvo);

	@Delete("delete from dohw where num = #{num}")
	public int delete(long num);

//	@Select("select * from (select rownum rn, dohw.* from dohw where hw_num = #{hw_num}) where rn BETWEEN ((#{cri.pageNum} - 1) * #{cri.amount}	+ 1) and #{cri.pageNum} * #{cri.amount}")
	@Select("select * from dohw order by num desc")
	@ResultType(DoHwVO.class)
	public List<DoHwVO> readList();

	@Select("select count(*) from dohw")
	@ResultType(Integer.class)
	public int getTotalCount(Criteria cri);
}
