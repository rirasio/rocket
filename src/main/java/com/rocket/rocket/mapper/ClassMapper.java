package com.rocket.rocket.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.rocket.rocket.domain.ClassVO;
import com.rocket.rocket.domain.Criteria;

public interface ClassMapper {

	@Insert("insert into class "
			+ "values ('class_'||seq_class.nextval, #{title}, #{intro}, sysdate, null, null, null, null, null, null, null)")
	public void insert(ClassVO classVO);

	@Select("select * from class where class_num = #{class_num}")
	@ResultType(ClassVO.class)
	public ClassVO select(String class_Num);

	@Update("update class set title = #{title}, intro = #{intro}, regdate = #{regdate}, modidate = sysdate, filename = null, filetype = null, filePath = null, thumbname = null, thumbtype = null, thumbPath = null where class_num = #{class_num}")
	public int update(ClassVO classVO);

	@Delete("delete from class where class_num = #{class_num}")
	public int delete(String class_num);

	@Select("select count(*) from class")
	@ResultType(Integer.class)
	public int getTotalCount(Criteria cri);
	
	@Select("")
	@ResultType(ClassVO.class)
	public ClassVO getListWithPaging(Criteria cri);
}
