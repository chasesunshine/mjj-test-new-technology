package org.wanbang.service;

import org.springframework.web.multipart.MultipartFile;
import org.wanbang.common.entity.Result;

public interface TestService {

    Result importFile(MultipartFile file);
}
