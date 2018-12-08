package com.wisdom.service;

import com.wisdom.common.Result;
import com.wisdom.entity.Teachers;

public interface LoginService {

	Teachers findTeacher(Integer id);

	Result login(Teachers teachers);
}
