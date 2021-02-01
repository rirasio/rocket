package com.rocket.rocket.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;

import com.rocket.rocket.domain.FilesVO;

public interface ClassAttachMapper {

	@Insert("insert into files (uuid, uploadpath, filename, filetype, class_num)"
			+ "values (#{uuid}, #{uploadpath}, #{filename}, null, seq_class.currval)")
	public void insertClassThumbnail(FilesVO filesVO);
	
	@Delete("delete from files where uuid = #{uuid}")
	public int delete(String uuid);
	
}
