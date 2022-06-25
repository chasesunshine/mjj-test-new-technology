package org.wanbang.service;

import org.springframework.web.multipart.MultipartFile;
import org.wanbang.common.entity.Result;

import java.io.IOException;

public interface TestService {

    Result importFile(MultipartFile file);

    Result importFile1(MultipartFile file) throws IOException;
}
